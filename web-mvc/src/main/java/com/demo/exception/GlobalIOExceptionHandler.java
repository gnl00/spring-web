package com.demo.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.impl.FileUploadIOException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.nio.file.FileSystemException;

/**
 * TODO
 *
 * @author gnl
 * @since 2023/4/21
 */
@ControllerAdvice
@Slf4j
public class GlobalIOExceptionHandler {

    @ExceptionHandler(value = {RuntimeException.class})
    public void handleRuntimeException(HttpServletRequest request) {
        log.info("GlobalIOExceptionHandler [RuntimeException] in url {}", request.getRequestURI());
    }

    @ExceptionHandler(value = {ArithmeticException.class})
    public void handleArithmeticException(HttpServletRequest request) {
        log.info("GlobalIOExceptionHandler [ArithmeticException] in url {}", request.getRequestURI());
    }

    @ExceptionHandler(value = { FileSystemException.class })
    public void handleFileSystemException(HttpServletRequest request, HttpServletResponse response) {}

    @ExceptionHandler(value = { FileUploadIOException.class })
    public void handleFileUploadException(HttpServletRequest request, HttpServletResponse response) {}

    @ExceptionHandler(value = { IOException.class })
    public void handleRootIOException(HttpServletRequest request, HttpServletResponse response) {}

}
