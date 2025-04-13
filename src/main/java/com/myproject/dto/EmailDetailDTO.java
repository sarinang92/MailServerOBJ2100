package com.myproject.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmailDetailDTO {
    private Long id;
    private String fromEmail;
    private String toEmail;
    private String subject;
    private String body;
    private String timestamp;
}
