import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { AnyMxRecord } from 'dns';
import { Address } from '../Model/Address';
import { User } from '../Model/User';
import { ProfileService } from '../services/profile.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent  {
 
//   email="utkarsh123@gmail.com";
//   name="Bhavya";
  


//   user:any={"customerEmail":"","customerPassword":"","name":"","age":0,"mobileNo":0,"address":{"houseNo":"","streetName":"","city":"","state":"","pincode":""},"gender":"","profilePhoto":""}
//   address:Address;
//   public userFile:any=File;
//   PhotoFileName: any;
//   Photopath:any;
//   // name:string;
//   comp:any;

//   gender:any;
//   g:boolean;

//   profileInformation:boolean=true;
//   manageAddress:boolean=false;
//   editInfo:boolean=false
//   message: string;
//   editButton:boolean=false;
//   editButton2:boolean=false;
//   editButton3:boolean=false;
//   saveButton:boolean;


//   // selectedFile: File;
//   // retrievedImage: any;
//   base64Data: any;
//   // retrieveResonse: any;
 
//   imageName: any;
//   services: any;
//   constructor(private profileService:ProfileService ,
//     private router:Router,private dom:DomSanitizer, private http:HttpClient,private fb: FormBuilder){

//   }

//   ngOnInit(): void {
//    this.getUser();

   
//   }
//   onClickToProfile(){
//       this.profileInformation=true
//       this.manageAddress=false;
//       this.editInfo=false;
//   }

//   onClickToAddress(){
//     this.profileInformation=false
//     this.manageAddress=true;
//     this.editInfo=false;
//   }

//   editInformation(){
//    this. profileInformation=false;
//    this.manageAddress=false;
//    this.editInfo=true;
   
//   }

//   getUser(){
//     this.profileService.getUser(this.email).subscribe((data:any)=>{
//     console.log(data);
//     this.user=data;
//     this.name=data.name;
//     this.user.profilePhoto=this.dom.bypassSecurityTrustResourceUrl("data:img/"+"jpg"+";base64,"+data.profilePhoto);

//      })
//   }

//   editName(event){
//     console.log(event.target.value);
//     this.user.name=event.target.value;
//   }

//   editState(event){
//     console.log(event.target.value);
//     this.user.address.state=event.target.value;
//   }

//   editCity(event){
//     console.log(event.target.value);
//     this.user.address.city=event.target.value;
//   }

//   editStreetName(event){
//     console.log(event.target.value);
//     this.user.address.streetName=event.target.value;
//   }

//   editPincode(event){
//     console.log(event.target.value);
//     this.user.address.pincode=event.target.value;
//   }

//   editHouseNo(event){
//     console.log(event.target.value);
//     this.user.address.houseNo=event.target.value;
//   }

//   imageUpload(event:any)
//   {
//     var file = event.target.files[0];
//     console.log(file);
//     this.userFile=file;
//     const formData:FormData= new FormData();
//     this.user.profilePhoto=null;
//     const a =JSON.stringify(this.user);
//     formData.append('user',a);
//     formData.append('profilePhoto',this.userFile);
//     this.profileService.updateUser(formData,this.email).subscribe((response)=>{
//      this.user.profilePhoto=this.dom.bypassSecurityTrustResourceUrl("data:img/"+"jpg"+";base64,"+response.profilePhoto);
//       console.log(response);

//     },
//     error=>{
//       this.user=error.error;
//       console.log(this.user);
//     }
//     )
//   }


    
    
//   addressForm = this.fb.group({
    

//     address: [null, Validators.required],
//     city: [null, Validators.required],
//     state: [null, Validators.required],
//     // mobileNumber :[null, Validators.required],
//     landmark :[null, Validators.required],
//     // alternateNumber:[null],
//     pincode: [
//       null,
//       Validators.compose([
//         Validators.required,
//         Validators.minLength(5),
//         Validators.maxLength(5)
//       ])
//     ]
//   });


//   getGender(){
//     this.profileService.getUser(this.email).subscribe((data:User)=>{
//       data.gender=this.gender;
//       if(this.gender=="Female")
//       {
//         this.g=true;
//       }
//       else{
//         this.g=false
//       }
//     })
//   }

//   editClick(){
//        this.editButton=true;
//   }

//   saveClick(){
//     this.updateName();
//     this.editButton=false;
//   }

//   cancelClick(){
//     console.log(this.name)
//     var text=document.getElementById("name")as HTMLInputElement | null;

//     // document.getElementById("name").value=this.name;
//     text.value=this.name;
//     this.editButton=false;
//   }
//   editClick2(){
//     this.editButton2=true;
// }

// saveClick2(){
// this.updateMobileNo();
//  this.editButton2=false;
// }

// cancelClick2(){
//  this.editButton2=false;
// }

// editClick3(){
//   this.editButton3=true;
// }

// saveClick3(){
// this.updateAddress();
// this.editButton3=false;
// }

// cancelClick3(){
// this.editButton3=false;
// }
  
  

//   states = 
//   [
//     { name: "Alabama", abbreviation: "AL" },
//     { name: "Alaska", abbreviation: "AK" },
//     { name: "American Samoa", abbreviation: "AS" },
//     { name: "Arizona", abbreviation: "AZ" },
//     { name: "Arkansas", abbreviation: "AR" },
//     { name: "California", abbreviation: "CA" },
//     { name: "Colorado", abbreviation: "CO" },
//     { name: "Connecticut", abbreviation: "CT" },
//     { name: "Delaware", abbreviation: "DE" },
//     { name: "District Of Columbia", abbreviation: "DC" },
//     { name: "Federated States Of Micronesia", abbreviation: "FM" },
//     { name: "Florida", abbreviation: "FL" },
//     { name: "Georgia", abbreviation: "GA" },
//     { name: "Guam", abbreviation: "GU" },
//     { name: "Hawaii", abbreviation: "HI" },
//     { name: "Idaho", abbreviation: "ID" },
//     { name: "Illinois", abbreviation: "IL" },
//     { name: "Indiana", abbreviation: "IN" },
//     { name: "Iowa", abbreviation: "IA" },
//     { name: "Kansas", abbreviation: "KS" },
//     { name: "Kentucky", abbreviation: "KY" },
//     { name: "Louisiana", abbreviation: "LA" },
//     { name: "Maine", abbreviation: "ME" },
//     { name: "Marshall Islands", abbreviation: "MH" },
//     { name: "Maryland", abbreviation: "MD" },
//     { name: "Massachusetts", abbreviation: "MA" },
//     { name: "Michigan", abbreviation: "MI" },
//     { name: "Minnesota", abbreviation: "MN" },
//     { name: "Mississippi", abbreviation: "MS" },
//     { name: "Missouri", abbreviation: "MO" },
//     { name: "Montana", abbreviation: "MT" },
//     { name: "Nebraska", abbreviation: "NE" },
//     { name: "Nevada", abbreviation: "NV" },
//     { name: "New Hampshire", abbreviation: "NH" },
//     { name: "New Jersey", abbreviation: "NJ" },
//     { name: "New Mexico", abbreviation: "NM" },
//     { name: "New York", abbreviation: "NY" },
//     { name: "North Carolina", abbreviation: "NC" },
//     { name: "North Dakota", abbreviation: "ND" },
//     { name: "Northern Mariana Islands", abbreviation: "MP" },
//     { name: "Ohio", abbreviation: "OH" },
//     { name: "Oklahoma", abbreviation: "OK" },
//     { name: "Oregon", abbreviation: "OR" },
//     { name: "Palau", abbreviation: "PW" },
//     { name: "Pennsylvania", abbreviation: "PA" },
//     { name: "Puerto Rico", abbreviation: "PR" },
//     { name: "Rhode Island", abbreviation: "RI" },
//     { name: "South Carolina", abbreviation: "SC" },
//     { name: "South Dakota", abbreviation: "SD" },
//     { name: "Tennessee", abbreviation: "TN" },
//     { name: "Texas", abbreviation: "TX" },
//     { name: "Utah", abbreviation: "UT" },
//     { name: "Vermont", abbreviation: "VT" },
//     { name: "Virgin Islands", abbreviation: "VI" },
//     { name: "Virginia", abbreviation: "VA" },
//     { name: "Washington", abbreviation: "WA" },
//     { name: "West Virginia", abbreviation: "WV" },
//     { name: "Wisconsin", abbreviation: "WI" },
//     { name: "Wyoming", abbreviation: "WY" }
//   ];



//   onSubmit() {
//     alert("Thanks!");
//   }


//   updateName(){
//     this.profileService.updateName(this.email,this.user.name).subscribe((data:any)=>
//     {
//       console.log(this.user)
//       console.log(this.user.name)
//        this.user=data;
//        console.log(this.user.name)
//     },
//     error=>{
//       this.user.name=error.error;
//       console.log(this.user.name);
//     })
//   }

//   updateMobileNo(){
//     this.profileService.updateMobileNo(this.email,this.user.mobileNo).subscribe((data:any)=>
//     {
//       console.log(this.user)
//       console.log(this.user.mobileNo)
//        this.user=data;
//        console.log(this.user.mobileNo)
//     },
//     error=>{
//       this.user.mobileNo=error.error;
//       console.log(this.user.mobileNo);
//     })
//   }


//   updateAddress(){
//     this.profileService.updateAddress(this.email,this.user.address).subscribe((data:any)=>
//     {
//       console.log(this.user)
//       console.log(this.user.address)
//        this.user=data;
//        console.log(this.user.address)
//     },
//     error=>{
//       this.user.address=error.error;
//       console.log(this.user.address);
//     })
//   }

//   updateImage(event:any){
//     var file = event.target.files[0];
//     console.log(file);
//     this.userFile=file;
//     const formData:FormData= new FormData();
//     formData.append('profilePhoto',this.userFile);
//     this.profileService.updateImage(this.email,file).subscribe((response:any)=>{
//      this.user.profilePhoto=this.dom.bypassSecurityTrustResourceUrl("data:img/"+"jpg"+";base64,"+response.profilePhoto);
//       console.log(response);

//     })
//   }

//   loading:boolean=false;
//   file:File=null;
//   shortLink: string = "";

//   onChange(event) {
//     this.file = event.target.files[0];
// }

//   onUpload() {
//     this.loading = !this.loading;

//     console.log(this.file);
//     this.profileService.updateImage(this.email, this.file).subscribe(
//         (event: any) => {
          
//             if (typeof (event) === 'object') {

//                 // Short link via api response
//                 this.shortLink = event.link;

//                 this.loading = false; // Flag variable 
//             }
//             this.user.profilePhoto=this.dom.bypassSecurityTrustResourceUrl("data:img/"+"jpg"+";base64,"+event.profilePhoto);

//         }
//     );
// }


}