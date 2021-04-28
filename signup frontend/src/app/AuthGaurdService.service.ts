import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})

export class AuthGaurdService implements CanActivate {

  constructor(private router: Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    
    if(localStorage.getItem("isLoggedIn") != "1") {

      this.router.navigate(['/Login']);
    }
    return true;

  }

}
