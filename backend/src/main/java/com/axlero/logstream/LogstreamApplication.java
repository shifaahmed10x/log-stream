package com.axlero.logstream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;

@SpringBootApplication
public class LogstreamApplication {

    public static void main(String[] args) {

        SpringApplication.run(LogstreamApplication.class, args);
        System.out.println("Run Successfully");
    }
}
