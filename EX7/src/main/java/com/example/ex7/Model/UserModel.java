package com.example.ex7.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class UserModel {
    @NotNull(message = "id is null")
    @Id
    private Integer ID;
    @NotEmpty(message = "name is null")
    @Size(min = 4,message = "name is less then 4")
    @Column(columnDefinition = "varchar(20)not null")
    private String name;
    @NotEmpty(message = "username is null")
    @Size(min = 4,message = "username is less then 4")
    //unique
    private String username;
    //unique
    @NotEmpty(message = "password is null")
    private String password;
    @NotEmpty(message = "email is null")
    //unique
    //Valid
    private String email;
    @NotEmpty(message = "role is null")
    private String role;
    @NotNull(message = "age is null")
    //most be integer
    //
    private Integer age;
}
