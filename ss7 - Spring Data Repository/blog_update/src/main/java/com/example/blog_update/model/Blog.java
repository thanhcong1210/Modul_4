package com.example.blog_update.model;

import jakarta.persistence.*;


@Entity
@Table(name = "blog")

public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", columnDefinition = "LONGTEXT")
    private String name;

    @Column(name = "title", columnDefinition = "LONGTEXT")
    private String title;

    @Column(name = "content", columnDefinition = "LONGTEXT")
    private String content;

    @Column(name = "author", columnDefinition = "LONGTEXT")
    private String author;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Blog() {
    }

    public Blog(int id, String name, String title, String content, String author, Category category) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.content = content;
        this.author = author;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}