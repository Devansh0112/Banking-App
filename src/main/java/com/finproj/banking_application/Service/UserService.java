package com.finproj.banking_application.Service;

import com.finproj.banking_application.Entity.User;
import com.finproj.banking_application.Repository.UserRepository;
import com.finproj.banking_application.Utils.AccountUtils;
import com.finproj.banking_application.dto.AccountInfo;
import com.finproj.banking_application.dto.EmailDetails;
import com.finproj.banking_application.dto.UserRequest;
import com.finproj.banking_application.dto.BankResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService implements UserServiceInterface {
    final UserRepository userRepository;
    final EmailService emailService;

    public UserService(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    @Override
    public BankResponse createAccount(UserRequest userRequest) {
//        Check if User already has an account
        if(userRepository.existsByEmail(userRequest.getEmail())) {
            return new BankResponse.Builder()
                    .responseCode(AccountUtils.ACCOUNT_EXISTS_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_EXISTS_MESSAGE)
                    .accountInfo(null)
                    .build();
        }
//        save details into Database
        User newUser = new User.Builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .otherName(userRequest.getOtherName())
                .gender(userRequest.getGender())
                .address(userRequest.getAddress())
                .stateOfOrigin(userRequest.getStateOfOrigin())
                .accountNumber(AccountUtils.generateAccountNumber())
                .accountBalance(BigDecimal.ZERO)
                .email(userRequest.getEmail())
                .phoneNumber(userRequest.getPhoneNumber())
                .alternatePhoneNumber(userRequest.getAlternatePhoneNumber())
                .status("Active")
                .build();

        User savedUser = userRepository.save(newUser);
//        Send Email alert
        EmailDetails emailDetails = new EmailDetails.Builder()
                .recipient(savedUser.getEmail())
                .subject("Account Creation")
                .body("Congratulations Your account has been successfully created!")
                .build();

        emailService.sendAlertEmail(emailDetails);
        return new BankResponse.Builder()
                .responseCode(AccountUtils.ACCOUNT_CREATION_SUCCESS_CODE)
                .responseMessage(AccountUtils.ACCOUNT_CREATION_SUCCESS_MESSAGE)
                .accountInfo(
                        new AccountInfo.Builder()
                                .accountNumber(savedUser.getAccountNumber())
                                .accountName(savedUser.getFirstName() + savedUser.getLastName())
                                .accountBalance(savedUser.getAccountBalance())
                                .build())
                .build();



    }
}
