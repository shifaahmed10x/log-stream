package com.axlero.logstream.service;

import com.axlero.logstream.dto.response.LogResponse;
import com.axlero.logstream.entity.Log;
import com.axlero.logstream.mapper.LuceneDocumentMapper;
import lombok.RequiredArgsConstructor;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LuceneIndexService {

    private final Directory directory;
    private final Analyzer analyzer;

    public void indexLog(Log log) throws IOException {

        IndexWriterConfig config = new IndexWriterConfig(analyzer);

        try (IndexWriter writer = new IndexWriter(directory, config)) {

            Document document = new Document();

            document.add(new StringField("id", String.valueOf(log.getId()), Field.Store.YES));
            document.add(new StringField("applicationName", safe(log.getApplicationName()), Field.Store.YES));
            document.add(new StringField("serviceName", safe(log.getServiceName()), Field.Store.YES));
            document.add(new StringField("hostName", safe(log.getHostName()), Field.Store.YES));
            document.add(new StringField("logLevel", log.getLogLevel().name(), Field.Store.YES));

            document.add(new TextField("message", safe(log.getMessage()), Field.Store.YES));

            document.add(new StringField("loggerName", safe(log.getLoggerName()), Field.Store.YES));
            document.add(new StringField("threadName", safe(log.getThreadName()), Field.Store.YES));
            document.add(new StringField("timestamp", log.getTimestamp().toString(), Field.Store.YES));

            writer.addDocument(document);
            writer.commit();
        }
    }

    public List<LogResponse> searchByMessage(String keyword)
            throws IOException, ParseException {

        try (DirectoryReader reader = DirectoryReader.open(directory)) {

            IndexSearcher searcher = new IndexSearcher(reader);

            QueryParser parser = new QueryParser("message", analyzer);

            Query query = parser.parse(keyword);

            TopDocs topDocs = searcher.search(query, 20);

            List<LogResponse> responses = new ArrayList<>();

            for (ScoreDoc scoreDoc : topDocs.scoreDocs) {

                Document document = searcher.storedFields().document(scoreDoc.doc);

                responses.add(LuceneDocumentMapper.toResponse(document));
            }

            return responses;
        }
    }

    private String safe(String value) {
        return value == null ? "" : value;
    }
}