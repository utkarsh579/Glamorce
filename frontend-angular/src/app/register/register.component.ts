import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, Validators } from '@angular/forms';
import { RegisterService } from '../services/register.service';
import { Router } from '@angular/router';
import { MatSnackBar, _SnackBarContainer } from '@angular/material/snack-bar';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private fb:FormBuilder,private registerService:RegisterService, private router:Router , private snack:MatSnackBar){}

  registerform=this.fb.group({
    name:['',[Validators.required,Validators.minLength(3)]],
    customerEmail:['', [Validators.required,Validators.email]],
    customerPassword:['', [Validators.required, Validators.pattern(/^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z]).{6,}$/)]],
    cpassword:['',[Validators.required, Validators.pattern(/^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z]).{6,}$/)]],
    mobileNo:['', [Validators.required]],
    gender:['',[Validators.required]],
    cb: [false, [Validators.requiredTrue]]
  }, 
  { validators: [this.mustMatchValidator] } 
  );

  get name() { return this.registerform.get("name") }
  get customerEmail() { return this.registerform.get("customerEmail") }
  get customerPassword() { return this.registerform.get("customerPassword") }
  get cpassword() { return this.registerform.get("cpassword") }
  get gender() { return this.registerform.get("gender") }
  get mobileNo() { return this.registerform.get("mobileNo") }

  
  OnSubmit(){
    this.registerService.registerUser(this.registerform.value)
    .subscribe(data=> this.snack.open(
      'Registered Successfully', 'ok', 
      {duration: 3000, panelClass: ['mat-toolbar', 'mat-primary']}
      ));
    this.router.navigateByUrl("loginView");
    
  }
  mustMatchValidator(Ac: AbstractControl) {
    const passwordValue = Ac.get("customerPassword")?.value;
    const confirmPasswordValue = Ac.get("cpassword")?.value;
    if (!passwordValue || !confirmPasswordValue) {
      return null;
    }
    if (passwordValue != confirmPasswordValue) {
      return { mustMatch: false }
    }
    return null;
  }

  ngOnInit(): void {
  }

}
