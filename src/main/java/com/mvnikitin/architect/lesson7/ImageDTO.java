package com.mvnikitin.architect.lesson7;

import lombok.Data;

import java.io.Serializable;

@Data
public class ImageDTO implements Serializable {

    private static final long serialVersionUID = -843536500661366067L;

    private Integer id;
    private String name;
    private String originalName;
    private String description;
    private Integer size;
    private String contentType;
    private Boolean selected;
}
