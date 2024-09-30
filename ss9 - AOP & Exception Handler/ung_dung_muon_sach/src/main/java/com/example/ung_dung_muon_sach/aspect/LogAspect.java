package com.example.ung_dung_muon_sach.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @After("execution(* com.example.ung_dung_muon_sach.service.borrow.BorrowService.borrowBook(..))")
    public void logBorrowAction() {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("logAdvice.csv", true))) {
            bufferedWriter.write("1 tín hiệu đã được gửi đi" + LocalDateTime.now());
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @After("execution(* com.example.ung_dung_muon_sach.service.borrow.BorrowService.returnBook(..))")
    public void logReturnAction() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("logAdvice.csv", true))) {
            bufferedWriter.write("1 tín hiệu đã được trả về" + LocalDateTime.now());
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Before("execution(* com.example.ung_dung_muon_sach.controller..*(..))")
    public void logControllerAction() {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("log.csv", true))){
            bufferedWriter.write("Đã có người xâm nhập vào lúc " + LocalDateTime.now());
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterThrowing("execution(* com.example.ung_dung_muon_sach..*(..))")
    public void logExceptionAction() {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("logException.csv", true))){
            bufferedWriter.write("Đã có lỗi xảy ra!!! FIX GẤP FIX GẤP" + LocalDateTime.now());
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}