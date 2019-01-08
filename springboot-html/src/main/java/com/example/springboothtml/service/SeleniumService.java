package com.example.springboothtml.service;

import org.springframework.http.ResponseEntity;

public interface SeleniumService {

    ResponseEntity scrapHtml(String fileName, Integer startPage, Integer endPage, Boolean picture);

    ResponseEntity relogin();

    ResponseEntity exit();

}
