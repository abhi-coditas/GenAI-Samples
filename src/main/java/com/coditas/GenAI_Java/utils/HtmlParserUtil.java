package com.coditas.GenAI_Java.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for parsing HTML documents using JSoup library.
 */
public class HtmlParserUtil {

    /**
     * Parse HTML from a string
     *
     * @param html HTML content as string
     * @return Document object
     */
    public static Document parseHtml(String html) {
        return Jsoup.parse(html);
    }

    /**
     * Parse HTML from a URL
     *
     * @param url URL to fetch and parse
     * @return Document object
     * @throws IOException if the URL cannot be fetched
     */
    public static Document parseHtmlFromUrl(String url) throws IOException {
        return Jsoup.connect(url).get();
    }

    /**
     * Parse HTML from a file
     *
     * @param file File containing HTML content
     * @return Document object
     * @throws IOException if the file cannot be read
     */
    public static Document parseHtmlFromFile(File file) throws IOException {
        return Jsoup.parse(file, "UTF-8");
    }

    /**
     * Extract text content from HTML
     *
     * @param html HTML content as string
     * @return Plain text content
     */
    public static String extractText(String html) {
        Document doc = parseHtml(html);
        return doc.text();
    }

    /**
     * Extract text from elements matching a CSS selector
     *
     * @param html HTML content as string
     * @param cssSelector CSS selector to match elements
     * @return Text content from matched elements
     */
    public static String extractTextBySelector(String html, String cssSelector) {
        Document doc = parseHtml(html);
        Elements elements = doc.select(cssSelector);
        return elements.text();
    }

    /**
     * Extract links from HTML
     *
     * @param html HTML content as string
     * @return Array of href attributes from anchor tags
     */
    public static String[] extractLinks(String html) {
        Document doc = parseHtml(html);
        Elements links = doc.select("a[href]");
        return links.stream()
                .map(link -> link.attr("href"))
                .toArray(String[]::new);
    }

    /**
     * Clean HTML by removing unwanted elements and attributes
     *
     * @param html HTML content as string
     * @return Cleaned HTML content
     */
    public static String cleanHtml(String html) {
        Document doc = parseHtml(html);
        // Remove script and style elements
        doc.select("script, style").remove();
        // Remove all attributes except href and src
        for (Element element : doc.getAllElements()) {
            element.attributes().asList().stream()
                    .filter(attr -> !attr.getKey().equals("href") && !attr.getKey().equals("src"))
                    .forEach(attr -> element.removeAttr(attr.getKey()));
        }
        return doc.html();
    }

    /**
     * Parse log data from the sample log HTML file, extracting timestamp and message content in chunks
     *
     * @param filePath Path to the HTML log file
     * @param chunkSize Number of log entries per chunk
     * @return List of StringBuffer chunks containing timestamp and message content
     * @throws IOException if the file cannot be read
     */
    public static List<StringBuffer> parseLogData(String filePath, int chunkSize) throws IOException {
        File input = new File(filePath);
        Document doc = Jsoup.parse(input, "UTF-8");
        List<StringBuffer> chunks = new ArrayList<>();
        StringBuffer currentChunk = new StringBuffer();
        int entryCount = 0;

        // Select all table rows except the header row
        Elements rows = doc.select("table tr:not(:first-child)");
        
        for (Element row : rows) {
            // Get timestamp from the first column
            Element timestampCell = row.selectFirst("td.timestamp");
            // Get content from the second column (could be message or response)
            Element contentCell = row.selectFirst("td:last-child");
            
            if (timestampCell != null && contentCell != null) {
                String timestamp = timestampCell.text().trim();
                String content = contentCell.text().trim();
                
                // Determine if it's a request or response
                String type = content.startsWith("[REQUEST]") ? "REQUEST" : 
                             content.startsWith("[RESPONSE]") ? "RESPONSE" : "OTHER";
                
                // Format the log entry with type information
                String logEntry = String.format("Timestamp: %s | Type: %s | Content: %s\n", 
                    timestamp, type, content);
                currentChunk.append(logEntry);
                entryCount++;

                // If we've reached the chunk size, add the current chunk to the list and create a new one
                if (entryCount >= chunkSize) {
                    chunks.add(currentChunk);
                    currentChunk = new StringBuffer();
                    entryCount = 0;
                }
            }
        }

        // Add the last chunk if it's not empty
        if (currentChunk.length() > 0) {
            chunks.add(currentChunk);
        }

        return chunks;
    }

    /**
     * Parse log data from the sample log HTML file with default chunk size of 1000
     *
     * @param filePath Path to the HTML log file
     * @return List of StringBuffer chunks containing timestamp and message content
     * @throws IOException if the file cannot be read
     */
    public static List<StringBuffer> parseLogData(String filePath) throws IOException {
        return parseLogData(filePath, 10); // Default chunk size of 1000 entries
    }
} 