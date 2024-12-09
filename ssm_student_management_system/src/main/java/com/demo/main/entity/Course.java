package com.demo.main.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Course implements Serializable {
    private Integer id;

    private String name;

    private Integer teacherId;

    private String description;

    private static final long serialVersionUID = 1L;

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}