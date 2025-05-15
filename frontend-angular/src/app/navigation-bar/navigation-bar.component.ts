import { Component, OnInit } from '@angular/core';
import { throwToolbarMixedModesError } from '@angular/material/toolbar';
import { NavigationEnd, Router } from '@angular/router';
import { AuthenticationServiceService } from '../services/authentication-service.service';

@Component({
  selector: 'app-navigation-bar',
  templateUrl: './navigation-bar.component.html',
  styleUrls: ['./navigation-bar.component.css']
})
export class NavigationBarComponent implements OnInit{
 
currentUrl:string;
  constructor(private authenticationService:AuthenticationServiceService,private route:Router){
    
    
  }
name=localStorage.getItem("emailId");
role=localStorage.getItem("role");
account:boolean=false;
admin:boolean=true;

ngOnInit(): void{
  
  console.log(this.name);
  console.log(this.route.url);
   
  if ( this.name === null)
{
    console.log("hello");
    this.account=true;
}
if(this.role=="ROLE_ADMIN")
{
  this.admin=false;
}
}
logout(){
  localStorage.clear();
   this.account=false;
   
   this.route.navigateByUrl("");
   if(this.route.url==""){
    window.location.reload();
  }
  else{
    this.route.navigateByUrl("");
  }
}
}
