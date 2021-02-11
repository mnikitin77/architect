package com.mvnikitin.architect.lesson7;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(generator = "image_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "image_id_seq",
            sequenceName = "image_id_seq",
            allocationSize = 1)
    private Integer id;

    @Column
    private String name;

    @Column(name = "original_name")
    private String originalName;

    @Column
    private String description;

    @Column
    private Integer size;

    @Column(name = "content_type")
    private String contentType;

    @Column
    private Boolean selected;
}
