import { identifierName } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';

import { ActivatedRoute, Router } from '@angular/router';
import { CartServiceService } from '../services/cart-service.service';
import { EmployeeService } from '../services/employee.service';
import { ProfileService } from '../services/profile.service';

@Component({
  selector: 'app-appointment-service',
  templateUrl: './appointment-service.component.html',
  styleUrls: ['./appointment-service.component.css']
})
export class AppointmentServiceComponent implements OnInit {
  constructor(private router: Router, private employeeService: EmployeeService, private dom: DomSanitizer, private proService:ProfileService, 
    private activatedRoute:ActivatedRoute,private cart:CartServiceService) { }
  isPresent = false;

 
  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(params=>{
      let id=params.get("serviceId") ?? 0;
      console.log(id);
      this.serviceId=id;
      localStorage.setItem("serviceId",this.serviceId);
    })
    if(localStorage.getItem("d1")==null){
      localStorage.setItem("d1",new Date().toISOString().split('T')[0])

    }
    this.d1=localStorage.getItem("d1")
    this.getByServiceIdAndDate(this.serviceId,this.d1)
    setTimeout(this.getAllEmployee, 1000)

  }
  getByServiceIdAndDate(serviceId,date) {
    this.employeeService.getSlotByServiceId(serviceId, date).subscribe(
      (data: any) => {
        console.log(data);
        for (let j = 0; j < data.length; j++) {
          this.emp.add(data[j].employeeId)
        }

      }
    )
    console.log(this.emp);
    
  }
  getAllEmployee=()=>{
    this.proService.getAllEmployees().subscribe(
      (data: any) => {
        console.log(data);
        let index=0;
        for (let j = 0; j < data.length; j++) {
          for (let i of this.emp) {
            console.log(i);
            console.log(j+data[j].employeeEmail);
            if (i == data[j].employeeEmail) {
              
              
              this.employees.push(data[j])
              this.employees[index].profilePhoto = this.dom.bypassSecurityTrustResourceUrl("data:img/" + "jpg" + ";base64," + data[j].profilePhoto);
              index++;
            }
          }
        }
        console.log(this.employees);
        
      }
    )
  }

  //proficiency and serviceId get it from salon-service
  proficiency = "Hair";
  serviceId:any;
  // serviceId="SER001";
  appointments = [];
  emp = new Set();
  empImage: any = [];
  slotsData: any = [];
  employees: any=[];
  p: any;
  page = 1;
  count = 0;
  pageSize = 2;
  pageSizes = [2, 4, 6, 8]
  d:string=localStorage.getItem("date");

  scrollItems = [
    '10AM-11AM',
    '11AM-12PM',
    '12PM-2PM',
    '2PM-3PM',
    '4PM-6PM'
  ];

  minDate = new Date();
  date = new FormControl(this.minDate);
  x = this.minDate.getDate() + 2;
  // //  y=this.minDate.setDate();
  maxDate = new Date(2023, 1, this.x);
  // dateFilter = (date: { getDay: () => any; }) => {
  //   const day = date.getDay();
  //   return day != 0;
  // }
  //  hello(){
  //   let btn=document.getElementById("d");
  //   console.log(btn);

  //   btn.style.cssText='background: black; color:white;'
  // }
  
  // getEmployee(){
  //   this.employeeService.getEmployeeByProficiency(this.proficiency).subscribe(
  //     data=>{
  //       console.log(data);
  //     }
  //   )
  // }
  cartObj:any;
  toCart(empId: any) {
    this.cartObj={
     serviceId:this.serviceId,
     appointmentId:localStorage.getItem("appointmentId"),
      employeeId:empId,
      slotTime: localStorage.getItem("d1")+" "+localStorage.getItem("cartSlot").split("-")[0],
     emailId:localStorage.getItem("emailId")
    }
    this.cart.addToCart(this.cartObj).subscribe(
      (data:any)=>{
        console.log(data);
        this.router.navigateByUrl("/cart")
      }
    )

  }
  // onChange(d) {
  //   this.date = d;
  //   console.log(this.date);

  // }
  d1:any=new Date().toISOString().split('T')[0];
  myFunction(){
    console.log("click");
    // console.log(d.value);
    console.log(this.d1);
    
    this.d=this.d1.toString();
    console.log(this.d);
    localStorage.setItem("date",this.d)
    window.location.reload();
   
    
    
  }
  onDateChange(){
    console.log(this.d1);
    localStorage.setItem("d1",this.d1)
    this.getByServiceIdAndDate(this.serviceId,localStorage.getItem("d1"))
    location.reload();
  }
}
function moment(): any {
  throw new Error('Function not implemented.');
}




