package com.example.HW2.phone.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhoneDto {
    private Long phoneNumber;
    private String phoneName;
    private Long phonePrice;
}

