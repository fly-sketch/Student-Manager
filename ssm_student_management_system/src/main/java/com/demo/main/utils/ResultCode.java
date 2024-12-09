package com.demo.main.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {
    SUCCESS(200, "操作成功"),
    FAILURE(500, "操作失败");

    private final int code;
    private final String message;
}
