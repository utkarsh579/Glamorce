import {Component, OnInit} from '@angular/core';
import { Employee } from '../Model/Employee';
import { FormControl } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { SalonserviceService } from '../services/salonservice.service';
import { Router } from '@angular/router';

interface Category {
  value: string;
  viewValue: string;
}


@Component({
  selector: 'app-employee-dashboard',
  templateUrl: './employee-dashboard.component.html',
  styleUrls: ['./employee-dashboard.component.css']
})
export class EmployeeDashboardComponent implements OnInit
{
  categories: Category[] = [
    {value: 'Skin', viewValue: 'Skin'},
    {value: 'Body', viewValue: 'Body'},
    {value: 'Hand_Feet', viewValue: 'Hand&Feet'},
    {value: 'Face', viewValue: 'Face'},
    {value: 'Hair', viewValue: 'Hair'}
    
  ];

  employees: any;
  registeredEmp:any;
  allEmployees:any;
  selectedValue=this.categories[0].value;
  category: String = "";
  cat: Employee[] = [];
  empIds=[];
  appointments=[]
  selectedDate:any;
  searchText:any;
  displayedEmployees:any;
  services!:any;

  today: any=new Date().toISOString().split('T')[0];;



  
  constructor( private dom:DomSanitizer,private salonServices:SalonserviceService,private router:Router){
    }
  

todaysDate:any;

 ngOnInit(): void {
   this.getEmployeesByProficiency("Skin");
   localStorage.setItem("category","Skin");
    console.log(localStorage.getItem("date"));
    if(localStorage.getItem("date")==null){
      localStorage.setItem("date",this.today);
      this.today=localStorage.getItem("date");
      
    }
      this.todaysDate=new Date().toISOString().split('T')[0];
    this.today=localStorage.getItem("date");
  }
 


  // myFilter = (d: Date | null): boolean => {
  //   const day = (d || new Date()).getDay();
  //   return day !== 0 && day !== 2;
  // };



  selectCategory() {    
  
    this.getEmployeesByProficiency(this.selectedValue);
    localStorage.setItem("category",this.selectedValue);
    // this.getCategoryByName();
    // console.log(this.services);
     
  }

//   minDate=new Date();
//   date = new FormControl(this.minDate);
//   x=this.minDate.getDate()+10;
//  //  y=this.minDate.setDate();
//   maxDate=new Date(2023,this.minDate.getMonth(),this.x);
//   dateFilter=(date: { getDay: () => any; })=>{
//    const day=date.getDay();
//    return day!=0;
//   }


  onChange(event){
    console.log(this.today);
    var selectedDate =new Date(this.today)
    var month:any =(selectedDate.getMonth()+1);
    var date:any=(selectedDate.getDate());
    if(month<10 ){
      month="0"+month.toString();
    }
    if(date<10 ){
      date="0"+date.toString();
    }
    let maxDate=selectedDate.getFullYear().toString()+"-"+month+"-"+date;
   localStorage.setItem("date",maxDate);
  //  $('#txtDate').attr('min', maxDate);
    console.log(selectedDate);
    location.reload();
  }



  getEmployeesByProficiency(proficiency:any){
    
    this.salonServices.getEmployeesByProficiency(proficiency).subscribe((data:any)=>
    {
      this.employees=data;
    
      for(var i=0; i<data.length;i++){
        let img:any=(this.dom.bypassSecurityTrustResourceUrl("data:img/"+"jpg"+";base64,"+data[i].profilePhoto));
        this.employees[i].profilePhoto=img.changingThisBreaksApplicationSecurity;
        this.empIds.push(this.employees[i].employeeEmail);
      }
      
    })
    
  }


 


  // getAllRegisteredEmp(){
  //   this.employeeService.getAllRegisteredEmp().subscribe((data:any)=>{
  //     console.log(data);
  //     this.allEmployees=data;
  //     let empLength= this.employees.length;
  //     for(let j=0;j<=empLength-1;j++){
  //      console.log(this.employees[j].employeeId);  
  //      for(let i=0;i<=data.length-1;i++){
  //       if(this.employees[j].employeeId==data[i].employeeEmail){
  //         this.employees[j].proficiency = data[i].proficiency;
  //         console.log("hello");
  //         this.employees[j].employeeImage=this.dom.bypassSecurityTrustResourceUrl("data:img/"+"jpg"+";base64,"+data[i].profilePhoto);
  //         break;
  //        }
  //      }
  //     }  
  //   })
  // }

  



  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  // onSearchTextChanged(category: string) {
  //   this.employeeService.getByCategory(category).subscribe({
  //     next: data => {
  //       if (category || category !== '') 
  //       {
  //         this.cat = data.filter(employee => employee.category.toLowerCase().includes(category.toLowerCase()));
  //         console.log(this.cat);
  //       }
  //       else
  //         this.cat = data;
  //     },
  //     error: e => {
  //       alert("Network Error !! Please Try Again Later");
  //     }
  //   })
  // }


  

}
