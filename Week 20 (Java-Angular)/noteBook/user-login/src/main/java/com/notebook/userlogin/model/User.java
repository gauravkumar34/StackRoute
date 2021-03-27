package com.notebook.userlogin.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = User.class)
@Entity
@Table(name = "User")
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {

    @Id
    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "password")
    private String password;
}
