package com.practise.signup.SignUpRepository;

import com.practise.signup.model.Signup;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SignUpRepository extends CrudRepository<Signup, Long>, JpaSpecificationExecutor<Signup> {

    @Query("SELECT s FROM Signup s WHERE s.username = :userName AND s.password = :password")
    Signup validate(String userName, String password);

    @Query("SELECT s FROM Signup s Where s.username = :username")
    Signup validateUser(String username);
}
