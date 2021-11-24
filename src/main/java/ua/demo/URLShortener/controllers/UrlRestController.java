package ua.demo.URLShortener.controllers;

import org.springframework.web.bind.annotation.*;
import ua.demo.URLShortener.services.UrlService;

import javax.annotation.Resource;

@RestController
public class UrlRestController {

    @Resource
    UrlService urlService;

    @PostMapping("/encode")
    public String encodeURL (@RequestParam(name = "url") String url) {

        return "http://localhost:8080/" + urlService.urlShortener(url);
    }

}
