import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api-service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  firstname: String = '';
  lastname: String = '';
  username: String = '';
  password: String = '';
  address: String = '';
  message: String = '';
  message1: String ='';
  login_password: String = '';
  loading : Boolean =false;
  login_email: String = '';
  showMessage: Boolean = false;
  isLoggedIn: Boolean =false;
  constructor(private apiService: ApiService, private router: Router) { }

  ngOnInit() {
  }

  submit(): void {

    let data = {
        'firstname' : this.firstname,
        'lastname' : this.lastname,
        'username' : this.username,
        'password': this.password,
        'address': this.address
    };

    this.apiService.doPost('/signup', data).subscribe(response => {
      this.showMessage = true;
      this.message = "Submitted successfully!!"
      this.reset();
  }, error => {
      this.showMessage = true;
      this.message = error.error.message;
  });
  }
  reset() {
    this.firstname = '';
      this.lastname = '';
      this.username = '';
      this.password = '';
      this.address = '';
  }
validate(){
  if(this.firstname=""){
    alert("required");
  }
}

login(): void {
  this.loading= true;
  this.apiService.login(this.login_email, this.login_password).subscribe(response => {
    localStorage.setItem("isLoggedIn", "1");
    localStorage.setItem("userId", response["userId"]);
    this.router.navigate(['/profile']);
}, error => {
    this.showMessage = true;
    this.message1 = error.error.message;
});
}

}


