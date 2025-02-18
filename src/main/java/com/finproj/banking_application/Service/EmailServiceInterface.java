package com.finproj.banking_application.Service;

import com.finproj.banking_application.dto.EmailDetails;

public interface EmailServiceInterface {
    void sendAlertEmail(EmailDetails emailDetails);
}
