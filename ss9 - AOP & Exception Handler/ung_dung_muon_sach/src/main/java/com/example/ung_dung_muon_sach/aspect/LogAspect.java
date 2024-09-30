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
        String message = "1 tín hiệu đã được gửi đi lúc " + LocalDateTime.now();

        // Log to console
        logger.info(message);

        // Write to file
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("logAdvice.csv", true))) {
            bufferedWriter.write(message);
            bufferedWriter.newLine();
        } catch (IOException e) {
            logger.error("Error writing log to file", e);
        }
    }

    @After("execution(* com.example.ung_dung_muon_sach.service.borrow.BorrowService.returnBook(..))")
    public void logReturnAction() {
        String message = "1 tín hiệu đã được trả về lúc " + LocalDateTime.now();

        // Log to console
        logger.info(message);

        // Write to file
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("logAdvice.csv", true))) {
            bufferedWriter.write(message);
            bufferedWriter.newLine();
        } catch (IOException e) {
            logger.error("Error writing log to file", e);
        }
    }

    @Before("execution(* com.example.ung_dung_muon_sach.controller..*(..))")
    public void logControllerAction() {
        String message = "Đã có người xâm nhập vào lúc " + LocalDateTime.now();

        // Log to console
        logger.info(message);

        // Write to file
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("log.csv", true))) {
            bufferedWriter.write(message);
            bufferedWriter.newLine();
        } catch (IOException e) {
            logger.error("Error writing log to file", e);
        }
    }

    @AfterThrowing("execution(* com.example.ung_dung_muon_sach..*(..))")
    public void logExceptionAction() {
        String message = "Đã có lỗi xảy ra!!! FIX GẤP FIX GẤP lúc " + LocalDateTime.now();

        // Log to console as error
        logger.error(message);

        // Write to file
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("logException.csv", true))) {
            bufferedWriter.write(message);
            bufferedWriter.newLine();
        } catch (IOException e) {
            logger.error("Error writing log to file", e);
        }
    }
}
