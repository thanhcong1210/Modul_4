package com.example.setting.service;

import com.example.setting.model.Email;
import com.example.setting.repository.IEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService{

    @Autowired
    private IEmailRepository emailRepository;

    @Override
    public boolean save(Email email) {
        return emailRepository.save(email);
    }
}
