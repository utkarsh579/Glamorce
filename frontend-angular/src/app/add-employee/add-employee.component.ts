import { Component } from '@angular/core';
import { AbstractControl, FormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { DomSanitizer } from '@angular/platform-browser';
import { Router } from '@angular/router';

import { employee } from '../Model/EmployeeReg';
import { RegisterService } from '../services/register.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent {

  constructor(private fb:FormBuilder,private registerService:RegisterService, private dom:DomSanitizer,private router:Router,
    private _snackBar:MatSnackBar){}

  registerform=this.fb.group({
    name:['',[Validators.required,Validators.minLength(3)]],
    employeeEmail:['', [Validators.required,Validators.email]],
    employeePassword:['', [Validators.required, Validators.pattern(/^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z]).{6,}$/)]],
    age:[,[Validators.required,Validators.min(18),Validators.max(36)]],
    mobileNo:['',[Validators.required,Validators.minLength(10),Validators.maxLength(10)]],
    address:['',[]],
    experience:['',[Validators.required]],
    gender:['',[Validators.required]],
    proficiency:['',[Validators.required]],
  }
  );

  get name() { return this.registerform.get("name") }
  get employeeEmail() { return this.registerform.get("employeeEmail") }
  get employeePassword() { return this.registerform.get("employeePassword") }
  // get cpassword() { return this.registerform.get("cpassword") }
  get gender() { return this.registerform.get("gender") }
  get age() { return this.registerform.get("age") }
  get mobileNo() { return this.registerform.get("mobileNo") }
  get address() { return this.registerform.get("address") }
  get experience() { return this.registerform.get("experience") }
  get proficiency() { return this.registerform.get("proficiency") }

  
employee:employee;


  loading:boolean=false;
  file:File=null;
  shortLink: string = "";

  onChange(event) {
    this.file = event.target.files[0];
}

  OnSubmit(){
    this.loading = !this.loading;
        console.log(this.file);
        console.log(this.registerform.value);

        this.registerService.postEmployee(this.registerform.value,this.file).subscribe(
            (event: any) => {

                if (typeof (event) === 'object') {
  
                    // Short link via api response
                    this.shortLink = event.link;
  
                    this.loading = false; // Flag variable 
                    
                }
                this.employee.profilePhoto=this.dom.bypassSecurityTrustResourceUrl("data:img/"+"jpg"+";base64,"+event.profilePhoto);
                console.log(this.file);
               
            }
            
        );

    this.registerform.reset();
    this._snackBar.open('Registered Employee Successfully', 'ok', {
      duration: 5000,
      panelClass: ['mat-toolbar', 'mat-primary']
    });
    this.router.navigateByUrl("/adminDashboard");
  }

  ngOnInit(): void {
  }

}
