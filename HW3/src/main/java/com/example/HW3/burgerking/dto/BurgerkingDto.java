package com.example.HW3.burgerking.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BurgerkingDto {
    private String name;
    private Long price;
}
