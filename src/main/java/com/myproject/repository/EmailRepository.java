package com.myproject.repository;

import com.myproject.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

    // Retrieve a list of emails where the recipient (toEmail) matches the provided email address.
    List<Email> findByToEmail(String toEmail);

    // Retrieve a list of emails where the sender (fromEmail) matches the provided email address.
    List<Email> findByFromEmail(String fromEmail);
}
