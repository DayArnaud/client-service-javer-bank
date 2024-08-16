package io.github.dayanearnaud.client_service_javer_bank.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class CustomerDTO {
    private UUID id;
    private String name;
    private Long phone;
    private String email;
    private Boolean account_holder;
    private String account_number;
    private Double balance;
    private Double credit_score;
    private LocalDateTime created_at;
}
