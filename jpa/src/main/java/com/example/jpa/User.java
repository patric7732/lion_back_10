package com.example.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "jpa_user")
@Getter@Setter
public class User {
    @Id
    private Long id;
    private String name;
    private String email;

}
