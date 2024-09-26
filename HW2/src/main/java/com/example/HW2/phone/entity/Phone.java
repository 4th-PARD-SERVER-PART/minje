package com.example.HW2.phone.entity;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Phone {
    private Long phoneNumber;
    private String phoneName;
    private Long phonePrice;
}
