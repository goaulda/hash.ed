package com.hash.mongoDB.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document
@Getter
@Setter
@NoArgsConstructor
public class PasswordsHashMD5Entity {

    @Id
    Long id;

    String hashPassword;

    String password;
}
