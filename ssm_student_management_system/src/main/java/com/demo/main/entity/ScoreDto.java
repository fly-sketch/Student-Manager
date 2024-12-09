package com.demo.main.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ScoreDto extends Score implements Serializable {
    private String studentName;
    private String courseName;

    private static final long serialVersionUID = 1L;
}
