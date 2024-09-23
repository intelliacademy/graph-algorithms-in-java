package com.intelliacademy.ga.cp3;

public class WebCrawler_Overview {
    public static void main(String[] args) {
        WebCrawler webCrawler = new WebCrawler();
        webCrawler.discoverWeb("https://www.bbc.com");
    }
}
