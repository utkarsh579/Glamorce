import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { $ } from 'protractor';
import { FeedbackService } from '../services/feedback.service';
import { ActivatedRoute } from '@angular/router';
import { ProfileService } from '../services/profile.service';
import { OrderListComponent } from '../order-list/order-list.component';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent {
  starRating = 0; 
 
  constructor(private feedbackService: FeedbackService, 
    private fb: FormBuilder,private activatedRoute:ActivatedRoute,
    private userService:ProfileService,private _snackBar:MatSnackBar
   ){}
    loggedInEmailId:string;
    userName:any="";
    
  ngOnInit(): void{
    this.activatedRoute.paramMap.subscribe(params=>{
      let id=params.get("id") ?? 0;
      console.log(id);
      this.currentappointmentId=id;
    })
    this.loggedInEmailId=localStorage.getItem("emailId");
    console.log(this.loggedInEmailId);
    this.userService.getUser(this.loggedInEmailId).subscribe(
      (data:any)=>{
        console.log(data);
        this.userName=data.name;
        console.log(this.userName);
        
      }
    )
  }


feedbackForm=this.fb.group({
  name:[""],
  appointmentId:[""],
  comments:['', [Validators.required]],
  rating:['',[Validators.required]],

}
);

get name() { return this.feedbackForm.get("name")  }
get appointmentId() { return this.feedbackForm.get("appointmentId")  }
get comments() { return this.feedbackForm.get("comments") }
get rating() { return this.feedbackForm.get("rating") }


currentappointmentId:any;

  OnSubmit(){
    
    this.feedbackForm.value.appointmentId=this.currentappointmentId;
    this.feedbackForm.value.name=this.userName;
    console.log(this.feedbackForm.value);  
    this.feedbackService.addFeedback(this.feedbackForm.value)
    .subscribe(
    data=>{
      this._snackBar.open('Thank You For The Feedback', 'ok', {
        duration: 5000,
        panelClass: ['mat-toolbar', 'mat-primary']
      });
    });
    this.feedbackForm.reset();
  }
}

