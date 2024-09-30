package com.example.ung_dung_muon_sach.service.book;

import com.example.ung_dung_muon_sach.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> findAll(Pageable pageable);

    void save(Book book);

    void deleteById(Long id);

    Book findById(Long id);
}
