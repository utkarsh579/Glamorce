import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { AuthenticationServiceService } from '../services/authentication-service.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { responseData } from '../Model/responsedata';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  constructor(private fb:FormBuilder,
    private authenticationService:AuthenticationServiceService,
    private _snackBar:MatSnackBar, private router:Router){}

    hide:boolean=true;
  loginform=this.fb.group({
    emailId:['', [Validators.required,Validators.email]],
    password:['', [Validators.required]]});
    jwt:String;
    responsedata:responseData;
    errorData:String;
    OnLogin(){
      console.log(this.loginform.value);
      this.authenticationService.loginCheck(this.loginform.value).subscribe(
        response=>{
          console.log(response);
          this.responsedata=response;
          this.jwt=this.responsedata.token;
          let jwtData = this.jwt.split('.')[1]
          let decodedJwtJsonData = window.atob(jwtData)
          let decodedJwtData = JSON.parse(decodedJwtJsonData)
          localStorage.setItem("role",decodedJwtData.role)
          localStorage.setItem("emailId",decodedJwtData.emailId)
          console.log(decodedJwtData);
          console.log(localStorage.getItem("role"));
          console.log(localStorage.getItem("emailId"));
          if(localStorage.getItem("role")=="User"){
            this.router.navigateByUrl("/service");
          }
          else if(localStorage.getItem("role")=="ROLE_ADMIN"){
            this.router.navigateByUrl("/adminDashboard");
          }
          this._snackBar.open('Logged In Successfully', 'ok', {
            duration: 5000,
            panelClass: ['mat-toolbar', 'mat-primary']
          });
        },
        error=>{
          console.log(error.error.message);
          this.errorData=error.error.message;
          this._snackBar.open('Please ReEnter EmailId and Password', 'ok', {
            duration: 5000,
            panelClass: ['mat-toolbar', 'mat-primary']
          });
          this.loginform.reset();
        });
        
    }
}
