package com.example.ung_dung_muon_sach.service.borrow;

import com.example.ung_dung_muon_sach.model.Borrow;

import java.util.List;

public interface IBorrowService {

    Borrow borrowBook(Long bookId, String bookRenter);

    void returnBook(Borrow borrow);

    List<Borrow> findAll();

    Borrow findByCode(String code);
}
