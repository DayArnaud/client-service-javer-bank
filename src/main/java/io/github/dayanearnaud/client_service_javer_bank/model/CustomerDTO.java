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
    private Boolean accountHolder;
    private String accountNumber;
    private Double balance;
    private Double creditScore;
    private LocalDateTime createdAt;
}
