package com.stackroute.MongoCrud.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@Data
public class User {

    @Id
    private int id;
    private String firstName;
    private String lastName;
    private int age;

}
