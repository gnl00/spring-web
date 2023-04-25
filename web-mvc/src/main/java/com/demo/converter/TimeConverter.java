package com.demo.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.Converter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.util.List;

/**
 * TODO
 *
 * @author gnl
 * @since 2023/4/21
 */
@Slf4j
public class TimeConverter implements Converter {

    {
        log.info("TimeConverter initialized");
    }

    @Override
    public Object convert(Object value, Class target, Object context) {
        return null;
    }
}