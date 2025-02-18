package com.finproj.banking_application.dto;

public class EmailDetails {
    private String recipient;
    private String subject;
    private String body;

    public EmailDetails(String recipient, String subject, String body) {
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public static class Builder {
        private String recipient;
        private String subject;
        private String body;

        public Builder recipient(String recipient) {
            this.recipient = recipient;
            return this;
        }

        public Builder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public EmailDetails build() {
            return new EmailDetails(recipient, subject, body);
        }
    }
}
