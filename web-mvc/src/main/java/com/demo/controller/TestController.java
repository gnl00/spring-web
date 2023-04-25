package com.demo.controller;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * TODO
 *
 * @author gnl
 * @since 2023/4/25
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    public final Map<String, Object> result = new HashMap<>();

    {
        result.put("code", 200);
        result.put("success", "true");
        result.put("data", null);
    }

    @GetMapping("/str")
    public String str() {
        return "Hello World";
    }

    @GetMapping("/map")
    public Map<String, Object> map() {
        result.put("data", "[TestController]map()");
        return result;
    }

    @GetMapping("/convert")
    public String testConvertor(String source) {
        log.info("converted source => {}", source);
        return "testConvertor";
    }

    @CrossOrigin("http://localhost:5173")
    @GetMapping("/cors")
    public Map<String, Object> testCors() {
        result.put("data", "[TestController] testCors()");
        return result;
    }

    @GetMapping("/entity")
    public void testEntity(HttpEntity<Object> entity) {
        log.info("entity {}", entity);
    }

    @ExceptionHandler(value = {ArithmeticException.class})
    public void handleArithmeticException(HttpServletRequest request) {
        log.info("[TestController] ArithmeticException in url {}", request.getRequestURI());
    }

    @GetMapping("/ex")
    public void testException() {
        int i = 10 / 0;
    }

    @GetMapping("/exGlobal")
    public void testGException() {
        throw new RuntimeException("test global exception");
    }

    Map<String, DeferredResult> defs = new HashMap<>();

    @GetMapping("/getDef")
    public DeferredResult<String> getDeferred() {

        DeferredResult<String> def = new DeferredResult<>();
        defs.put("getDeferred", def);

        return def;
    }

    @GetMapping("/setDef")
    public void doSomething() {
        DeferredResult def = defs.get("getDeferred");
        try {
            Thread.sleep(1000 * 3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        def.setResult("[TestController] - doSomething()");
    }

    @GetMapping("/callable")
    public Callable<String> testCallable(ServletRequest request) {
        log.info("Before callable");
        Callable<String> callable = () -> {
            // do something
            log.info("callable do something");
            return "testCallable() callable execute Done";
        };
        log.info("After callable");
        return callable;
    }

}
