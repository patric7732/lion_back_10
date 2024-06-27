package org.example.zizonsecurity.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Entity
@Table(name = "roles")
@Getter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String name;
}
