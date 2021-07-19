package com.enterprisenao.spring_reactive_no5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "admin")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @Id
    private String id;
    private String name;
    private String username;
    private String password;
    private int level;
    private boolean status;
}
