package com.practise.signup.Controller;

import com.practise.dto.LoggedInUser;
import com.practise.signup.Exception.LoggedException;
import com.practise.signup.Exception.SignupException;
import com.practise.signup.Service.signupService;
import com.practise.signup.model.Signup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;
import java.util.List;

@RestController
public class signupController {
    @Autowired
    private signupService signupService;

    @GetMapping("/logging")
    public LoggedInUser sigingIn(HttpServletRequest request) throws LoggedException {
        String authToken = request.getHeader("Authorization")
                .substring("Basic".length()).trim();
        String decodedAuthToken = new String(Base64.getDecoder().decode(authToken));
        String userName = decodedAuthToken.split(":")[0];
        String password = decodedAuthToken.split(":")[1];
        return this.signupService.validate(userName, password);
    }


    @GetMapping("/signup")
    public List<Signup> allrecords() {
        return signupService.getAllRecords();
    }

    @PostMapping("/signup")
    public void addRecords(@RequestBody Signup signup) throws SignupException {
        signupService.addRecords(signup);

    }

    @DeleteMapping("/signup/{id}")
    public void deleteRecords(@PathVariable("id") Long id) {
        signupService.deleteRecords(id);
    }

    @GetMapping("signup/{id}")
    public Signup record(@PathVariable("id") Long id) {
        return signupService.record(id);
    }

    @PutMapping("signup/{id}")
    public void updateRecords(@RequestBody Signup signup, @PathVariable("id") Long id) {
        signupService.updateRecords(signup, id);
    }
}
