package com.example.from_dang_ky.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Getter
@Setter
@NoArgsConstructor
public class UserDTO implements Validator {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int age;
    private String email;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO userDTO = (UserDTO) target;

        // Kiểm tra First Name
        if ("".equals(userDTO.getFirstName())) {
            errors.rejectValue("firstName", null, "First name is required");
        } else if (!userDTO.getFirstName().matches("^[a-zA-Z]{5,30}$")) {
            errors.rejectValue("firstName", null, "First name is incorrect");
        }

        // Kiểm tra Last Name
        if ("".equals(userDTO.getLastName())) {
            errors.rejectValue("lastName", null, "Last name is required");
        } else if (!userDTO.getLastName().matches("^[a-zA-Z]{5,30}$")) {
            errors.rejectValue("lastName", null, "Last name is incorrect");
        }

        // Kiểm tra Phone Number
        if ("".equals(userDTO.getPhoneNumber())) {
            errors.rejectValue("phoneNumber", null, "Phone number is required");
        } else if (!userDTO.getPhoneNumber().matches("^[0-9]{10}$")) {
            errors.rejectValue("phoneNumber", null, "Phone number is incorrect");
        }

        // Kiểm tra Age
        if ("".equals(userDTO.getAge())) {
            errors.rejectValue("age", null, "Age is required");
        } else if (userDTO.getAge() < 0) {
            errors.rejectValue("age", null, "Age is incorrect");
        }

        // Kiểm tra Email
        if ("".equals(userDTO.getEmail())) {
            errors.rejectValue("email", null, "Email is required");
        } else if (!userDTO.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            errors.rejectValue("email", null, "Email is incorrect");
        }
    }

}
