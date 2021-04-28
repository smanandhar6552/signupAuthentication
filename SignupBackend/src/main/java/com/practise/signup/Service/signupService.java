package com.practise.signup.Service;

import com.practise.dto.LoggedInUser;
import com.practise.signup.Exception.LoggedException;
import com.practise.signup.Exception.SignupException;
import com.practise.signup.SignUpRepository.SignUpRepository;
import com.practise.signup.model.Signup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class signupService {
    @Autowired
    private SignUpRepository signUpRepository;

    public List<Signup> getAllRecords() {
        return (List<Signup>) signUpRepository.findAll();
    }

    public void addRecords(Signup signup) throws SignupException {
        validation(signup);
        signUpRepository.save(signup);
    }

    public void deleteRecords(Long id) {
        signUpRepository.deleteById(id);
    }

    public Signup record(Long id) {
        return (Signup) signUpRepository.findById(id).get();
    }

    public void updateRecords(Signup signup, Long id) {
        signup.setId(Long.valueOf(id));
        signUpRepository.save(signup);
    }

    public void validation(Signup signup) throws SignupException {

        if (signup.getFirstname().equals("")) {
            throw new SignupException("Fisrt name cannot be empty");
        }
        if (signup.getLastname().equals("")) {
            throw new SignupException("Last name cannot be empty");
        }
        if (signup.getAddress().equals("")) {
            throw new SignupException("Address cannot be empty");
        }

        if (signup.getPassword().equals("")) {
            throw new SignupException("Password cannot be empty");
        }
        if (signup.getPassword().length() < 5) {
            throw new SignupException("Your character should aleast contain 6 character");
        }

        validateUser(signup.getUsername());

        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";


        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(signup.getUsername());


        if (signup.getUsername().equals("")) {
            throw new SignupException("Username cannot be empty");
        }
        if (!matcher.matches()) {
            throw new SignupException("Enter valid email");
        }

    }

    public LoggedInUser validate(String userName, String password) throws LoggedException {
        Signup signup = this.signUpRepository.validate(userName, password);
        if (signup == null) {
            throw new LoggedException("Invalid username/password");
        }
        LoggedInUser loggedInUser = new LoggedInUser();
        loggedInUser.setFirstname(signup.getFirstname());
        loggedInUser.setLastname(signup.getLastname());
        loggedInUser.setUsername(signup.getUsername());
        loggedInUser.setUserId(signup.getId());
        return loggedInUser;
    }

    public void validateUser(String userName) throws SignupException{
        Signup signup =this.signUpRepository.validateUser(userName);
        if(signup != null){
            throw new SignupException("Username already Exists");
        }
    }
}
