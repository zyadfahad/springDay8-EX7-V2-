package com.example.ex7.Repository;

import com.example.ex7.Model.UserModel;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Integer> {

    UserModel findUserModelByEmail(String email);
    UserModel findUserModelByID(Integer id);
    List<UserModel> findAllByRole(String role);
    List<UserModel> findAllByAgeGreaterThanEqual(Integer age);


}
