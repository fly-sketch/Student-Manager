package com.demo.main.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result<T> {
    private ResultCode code;
    private T data;
}
