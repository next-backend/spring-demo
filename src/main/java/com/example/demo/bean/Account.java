package com.example.demo.bean;

import lombok.*;

@Data
@AllArgsConstructor
public class Account {
    private Long id ;
    private String name ;
    private Long balance ;
    private Long freeze ;
}
