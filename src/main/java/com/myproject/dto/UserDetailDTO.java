package com.myproject.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDetailDTO {
    private Long id;
    private String username;
    private String email;
    private String password;
}
