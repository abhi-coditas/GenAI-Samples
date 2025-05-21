package com.coditas.GenAI_Java;

import com.coditas.GenAI_Java.utils.HtmlParserUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import jakarta.annotation.PostConstruct;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class GenAiJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenAiJavaApplication.class, args);
    }

    @PostConstruct
    public void init() {
        try {
            // Get the path to the sample_log.html file from the resources directory
            String logFilePath = new ClassPathResource("static/sample_log.html").getFile().getAbsolutePath();

            // Parse log data in chunks of 5 entries each
            List<StringBuffer> logChunks = HtmlParserUtil.parseLogData(logFilePath);

            System.out.println("Chunk size :" + logChunks.size());
            for (int i = 0; i < logChunks.size(); i++) {
                //System.out.println("\nChunk " + (i + 1) + ":");
                //System.out.println(logChunks.get(i).toString());
                // Here you can process each chunk for embedding
                // processChunkForEmbedding(logChunks.get(i));
            }
        } catch (IOException e) {
            System.err.println("Error reading log file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
