package com.example.springboothtml.service;

import org.springframework.http.ResponseEntity;

/**
 * @author licunzhi
 * @desc 服务层
 * @date 2018-11-17
 */
public interface ProductService {

    ResponseEntity scrapHtml(String query, Integer startPage, Integer endPage, Integer sortType, Boolean picture);
}
