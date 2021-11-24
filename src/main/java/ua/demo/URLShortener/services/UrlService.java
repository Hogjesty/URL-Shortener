package ua.demo.URLShortener.services;

public interface UrlService {

    String urlShortener(String longUrl);

    String getUrlByShort(String shortUrl);

}
