package com.intelliacademy.ga.cp3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {
    private final Queue<String> queue;
    private final List<String> discoveredWebsites;

    public WebCrawler() {
        this.queue = new LinkedList<>();
        this.discoveredWebsites = new ArrayList<>();
    }


    public void discoverWeb(String root) {
        this.queue.add(root);
        this.discoveredWebsites.add(root);

        while (!queue.isEmpty()){
            var v = this.queue.remove();
            var rawHtml = readUrl(v);
            var pattern = Pattern.compile("https://(\\w+\\.)*(\\w+)");
            Matcher matcher = pattern.matcher(rawHtml);
            while (matcher.find()){
                var url = matcher.group();
                if (!discoveredWebsites.contains(url)){
                    discoveredWebsites.add(url);
                    System.out.println("Website found with URL: " + url);
                    queue.add(url);
                }
            }
        }
    }

    private String readUrl(String url) {
        var rawHtml = new StringBuilder();
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));) {
            String inputLine = "";
            while ((inputLine = bufferedReader.readLine()) != null){
                rawHtml.append(inputLine);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return rawHtml.toString();
    }
}
