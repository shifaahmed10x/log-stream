package com.axlero.logstream.config;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.Paths;

@Configuration
public class LuceneConfig {

    @Value("${lucene.index.path}")
    private String indexPath;

    @Bean
    public Directory luceneDirectory() throws IOException {
        return FSDirectory.open(Paths.get(indexPath));
    }

    @Bean
    //StandardAnalyzer : Ye text ko normalize karta hai.
    public Analyzer analyzer() {
        return new StandardAnalyzer();
    }
}