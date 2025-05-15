import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthenticationServiceService } from '../services/authentication-service.service';

@Injectable({
  providedIn: 'root'
})
export class UserGuardGuard implements CanActivate {
  constructor(private AuthenticationService:AuthenticationServiceService,
    private router:Router){}

    
    
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      let role=localStorage.getItem("role");
    if(role=="User"){
      
      return true;
    }
    else{
      this.router.navigateByUrl("");
      return false;
    }
      // console.log(this.AuthenticationService.checkedLoggedInUser());
      
      // if(this.AuthenticationService.checkedLoggedInUser()==true)
      // {
        
        
      //   console.log("test");
        
      //   return true;
      // }
      // else{
      //   this.router.navigate([""]);
      //   return false;
      // }

      return true;
      
  }
  
}
