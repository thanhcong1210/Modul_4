package com.example.ung_dung_muon_sach.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "book")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private int quantity;


}