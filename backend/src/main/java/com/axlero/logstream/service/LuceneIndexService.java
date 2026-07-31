package com.axlero.logstream.service;

import com.axlero.logstream.entity.Log;
import lombok.RequiredArgsConstructor;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.store.Directory;
import org.springframework.stereotype.Service;

import com.axlero.logstream.entity.Log;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;

import java.io.IOException;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class LuceneIndexService {

    private final Directory directory;
    private final Analyzer analyzer;

        public void indexLog(Log log) throws IOException {

            IndexWriterConfig config = new IndexWriterConfig(analyzer);

            try (IndexWriter writer = new IndexWriter(directory, config)) {

                Document document = new Document();

                document.add(new StringField("id",
                        String.valueOf(log.getId()),
                        Field.Store.YES));

                document.add(new StringField("applicationName",
                        log.getApplicationName(),
                        Field.Store.YES));

                document.add(new StringField("serviceName",
                        log.getServiceName(),
                        Field.Store.YES));

                document.add(new StringField("hostName",
                        log.getHostName(),
                        Field.Store.YES));

                document.add(new StringField("logLevel",
                        log.getLogLevel().name(),
                        Field.Store.YES));

                document.add(new TextField("message",
                        log.getMessage(),
                        Field.Store.YES));

                document.add(new StringField("loggerName",
                        log.getLoggerName() == null ? "" : log.getLoggerName(),
                        Field.Store.YES));

                document.add(new StringField("threadName",
                        log.getThreadName() == null ? "" : log.getThreadName(),
                        Field.Store.YES));

                document.add(new StringField("timestamp",
                        log.getTimestamp().toString(),
                        Field.Store.YES));

                writer.addDocument(document);
                writer.commit();
            }
        }
    }
