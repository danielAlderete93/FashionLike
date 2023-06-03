package com.fashionlike.proyecto_fashion_like.domain.port.service;

public interface MailSenderService {
    void sendEmail(String to, String subject, String body);
}
