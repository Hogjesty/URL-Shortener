package ua.demo.URLShortener.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UrlServiceImpl implements UrlService{

    private static Map<String, String> urlMap;

    @Override
    public String urlShortener(String longUrl) {

        if (urlMap == null) {
            urlMap = new HashMap<>();
        }

        String shortUrl = generateRandomShortString();

        urlMap.put(shortUrl, longUrl);

        return shortUrl;
    }

    @Override
    public String getUrlByShort(String shortUrl) {
        if (urlMap == null) {
            return "/";
        }

        return urlMap.get(shortUrl);
    }


    private String generateRandomShortString() {

        String allChars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            sb.append(allChars.charAt(random(0, allChars.length()-1)));
        }

        return sb.toString();
    }

    private int random(int min, int max) {
        return (int) (min + (Math.random() * (max - min + 1)));
    }

}
