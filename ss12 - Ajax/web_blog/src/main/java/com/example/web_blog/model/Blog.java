package com.example.web_blog.model;

import jakarta.persistence.*;
import lombok   .Data;


@Entity
@Table(name = "blog")
@Data
public class Blog extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private String author;
    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;


    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;


}