package com.example.ung_dung_muon_sach.repository;

import com.example.ung_dung_muon_sach.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowRepository extends JpaRepository<Borrow, Long> {
    Borrow findByCode(String code);
}
