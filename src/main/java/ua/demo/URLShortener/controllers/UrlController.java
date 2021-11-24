package ua.demo.URLShortener.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.demo.URLShortener.services.UrlService;

import javax.annotation.Resource;

@Controller
public class UrlController {

    @Resource
    UrlService urlService;

    @GetMapping("/{short}")
    public String redirect(@PathVariable("short") String shortUrl) {
        return "redirect:" + urlService.getUrlByShort(shortUrl);
    }

}
