package com.example.security_blog.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "blogs")
@Data
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", columnDefinition = "LONGTEXT")
    private String title;

    @Column(name = "content", columnDefinition = "LONGTEXT")
    private String content;

    @Column(name = "author", columnDefinition = "LONGTEXT")
    private String author;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
