import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from '../api-service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
productName: String ="";
quantity: String ="";
comment: String="";
address: String="";
showMessage: Boolean = false;
message: String ="";
  constructor(private apiService: ApiService, private router: Router) { }

  ngOnInit() {

  }
  signout(){
    localStorage.removeItem("isLoggedIn");
    //this.router.navigate(['/Login']);

  }
  submit(): void {

    let data = {
        'product' : this.productName,
        'quantity' : this.quantity,
        'comment': this.comment,
        'pickupAddress': this.address,
        'userID': {
          'id': localStorage.getItem('userId')
        }

    };

    this.apiService.doPost('/product', data).subscribe(response => {
      this.showMessage=true;
      this.message="Product Sent";
      this.reset();


  }, error => {
     alert("cannot send");
  });

}
reset(){
  this.productName="";
  this.quantity="";
  this.comment="";
  this.address="";
}
}
