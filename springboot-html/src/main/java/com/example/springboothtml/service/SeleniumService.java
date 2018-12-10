package com.example.springboothtml.service;

import org.springframework.http.ResponseEntity;

public interface SeleniumService {

    ResponseEntity demoUse(String query);

    ResponseEntity scrapHtml(String query, Integer startPage, Integer endPage, Integer sortType, Boolean picture);

}
