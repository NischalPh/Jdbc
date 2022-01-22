package com.nischal.jdbc.exception;

@FunctionalInterface
public interface ExceptionWrapper {
    void process() throws Exception;
}
