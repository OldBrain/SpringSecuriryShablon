package com.example.springsecuriryshablon.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity

@Table(name = "roles")
public class Role extends BaseSecurityEntity {

    @Column(name = "name")
    private String name;

    public Role() {
    }


}
