package com.finproj.banking_application.Service;

import com.finproj.banking_application.dto.BankResponse;
import com.finproj.banking_application.dto.UserRequest;

public interface UserServiceInterface {
   BankResponse createAccount(UserRequest userRequest);

}
