package com.example.springsecuriryshablon.models;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data
public class BaseSecurityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(name = "created_at")
    private Date created_at;

    @LastModifiedDate
    @Column(name = "updated_at")
    private Date updated_at;

    @Override
    public String toString() {
        return "Empty toString method";
    }
}
