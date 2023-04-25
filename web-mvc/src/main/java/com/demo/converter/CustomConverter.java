package com.demo.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.Assert;

/**
 * TODO
 *
 * @author gnl
 * @since 2023/4/21
 */
@Slf4j
public class CustomConverter implements Converter<String, String> {

    {
        log.info("CustomConverter initialized");
    }

    @Override
    public String convert(String source) {
        Assert.notNull(source, "source cannot be null");
        log.info("source => {}", source);

        source = source.replace("-", "/");

        return source;
    }
}