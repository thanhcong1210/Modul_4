package com.example.ung_dung_muon_sach.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "borrow")
@Data
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String bookRenter;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

}
