package com.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;

/**
 * TODO
 *
 * @author gnl
 * @since 2023/4/20
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/str")
    public String string(WebRequest webRequest, NativeWebRequest nativeWebRequest) {

        log.info("placeholder parameters WebRequest {}, NativeWebRequest {}", webRequest, nativeWebRequest);

        return "[test] - str()";
    }

    @GetMapping("/entity")
    public void testEntity(HttpEntity<Object> entity) {
        log.info("entity {}", entity);
    }

}
