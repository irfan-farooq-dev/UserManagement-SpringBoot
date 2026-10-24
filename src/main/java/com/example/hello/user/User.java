package com.example.hello.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")   // "user" is a reserved word in PostgreSQL, so use "users"
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // auto-increment id
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // JPA requires a no-args constructor
    protected User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Runs just before INSERT (like Eloquent's "creating" event)
    @PrePersist
    void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
}