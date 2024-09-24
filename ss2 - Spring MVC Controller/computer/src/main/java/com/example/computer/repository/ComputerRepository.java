package com.example.computer.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ComputerRepository implements IComputerRepository {
    @Override
    public double computer(double first, double second, String item) {
        switch (item) {
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
              if (second != 0) {
                  return first / second;

              } else {
                  throw  new IllegalArgumentException("không được chia 1 số cho 0!!! Xin vui lòng nhập lại");
              }
            default:
                throw new IllegalArgumentException("The item is not valid");

        }
    }
}
