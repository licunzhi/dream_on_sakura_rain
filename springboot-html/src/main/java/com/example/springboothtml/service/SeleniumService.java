package com.example.springboothtml.service;

import org.springframework.http.ResponseEntity;

public interface SeleniumService {
    ResponseEntity login();

    ResponseEntity scrapHtml(Integer startPage, Integer endPage, Boolean picture);

    ResponseEntity relogin();

}
