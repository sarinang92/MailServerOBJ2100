package com.myproject.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailBasicDTO {
    private Long id;
    private String fromEmail;
    private String toEmail;
    private String subject;
}
