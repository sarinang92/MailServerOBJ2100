package com.myproject.service;

import com.myproject.model.Email;
import com.myproject.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    public Email sendEmail(Email email) {
        
        email.setTimestamp(LocalDateTime.now().toString());
        
        return emailRepository.save(email);
    }

    public List<Email> getEmailsReceivedBy(String toEmail) {
        return emailRepository.findByToEmail(toEmail);
    }

    public List<Email> getEmailsSentBy(String fromEmail) {
        return emailRepository.findByFromEmail(fromEmail);
    }

    public void deleteEmail(Long id) {
        emailRepository.deleteById(id);
    }
}
