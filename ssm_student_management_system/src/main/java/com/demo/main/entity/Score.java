package com.demo.main.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Score implements Serializable {
    private Integer id;

    private Integer studentId;

    private Integer courseId;

    private Integer score;

    private static final long serialVersionUID = 1L;
}