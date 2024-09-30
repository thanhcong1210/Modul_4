package com.example.ung_dung_muon_sach.service.borrow;

import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.model.Borrow;
import com.example.ung_dung_muon_sach.repository.IBookRepository;
import com.example.ung_dung_muon_sach.repository.IBorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BorrowService implements IBorrowService {

    @Autowired
    private IBorrowRepository borrowRepository;

    @Autowired
    private IBookRepository bookRepository;

    private String bookBorrowingCode(){
        Random random = new Random();
        String code;
        do {
            code = String.format("SS-%06d", random.nextInt(10000));
        }while (borrowRepository.findByCode(code) != null);
        return code;
    }

    @Override
    public Borrow borrowBook(Long bookId, String bookRenter) {
        Book book = bookRepository.findById(bookId).orElse(null);
        if (book == null || book.getQuantity() <= 0) {
            return null;
        }

        book.setQuantity(book.getQuantity() - 1);
        bookRepository.save(book);

        Borrow borrow = new Borrow();
        borrow.setBook(book);
        borrow.setBookRenter(bookRenter);
        borrow.setCode(bookBorrowingCode());
        borrowRepository.save(borrow);

        return borrow;
    }

    @Override
    public List<Borrow> findAll() {
        return borrowRepository.findAll();
    }

    @Override
    public void returnBook(Borrow borrow) {
        Book book = borrow.getBook();
        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);
        borrowRepository.delete(borrow);
    }

    @Override
    public Borrow findByCode(String code) {
        return borrowRepository.findByCode(code);
    }

}
