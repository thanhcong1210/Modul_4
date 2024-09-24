package com.example.computer.service;


import com.example.computer.repository.IComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputerService implements IComputerService{

    @Autowired
    private IComputerRepository computerRepository;

    @Override
    public double computer(double first, double second, String item) {
        return computerRepository.computer(first, second, item);
    }
}
