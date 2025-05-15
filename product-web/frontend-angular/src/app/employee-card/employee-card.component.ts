import {Component, Injectable, Input, OnInit } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import { CreateSlotsComponent } from '../create-slots/create-slots.component';
import { SalonserviceService } from '../services/salonservice.service';
import { MatPaginator } from '@angular/material/paginator';
import { Observable } from 'rxjs';
import { MatTableDataSource } from '@angular/material/table';
import { EmployeeService } from '../services/employee.service';
import { Service } from '../Model/service';
import { Employee } from '../Model/Employee';
import { employee } from '../Model/EmployeeReg';

@Component({
  selector: 'app-employee-card',
  templateUrl: './employee-card.component.html',
  styleUrls: ['./employee-card.component.css']
})


export class EmployeeCardComponent implements OnInit  {

  employeeId:any;
  employeeName:any;


  @Input()
  employee?: any; 

  appointments=[];
  // text=[] = this.appointments;
  // result =[] = this.text.substring(1, 4);

  @Input()
  services:any[];

  @Input()
  allEmployees?:any;

  ngOnInit()
    {
     console.log(this.employee);
     this.getAppointmentByDate(this.employee.employeeEmail,localStorage.getItem("date"));
    }  

  constructor(private dialog: MatDialog, private salonServices:SalonserviceService) { }

  openDialog(id:any, name:any,status:any){
    this.employeeId=id;
    this.employeeName=name;
    console.log(this.employeeId);
    console.log(name);
    console.log(status);
    this.dialog.open(CreateSlotsComponent, {
    width:'30%', 
    data:{value:this.employeeId,value1:this.employeeName}
   })
  }

  getAppointmentByDate(email,date){
    this.salonServices.getAppointmentsByEmployeeAndDate(email,date).subscribe((data:any)=>{
      console.log(data);
      for(var i=0; i<data.length;i++){
         data[i].startTime= data[i].startTime.substring(11,19);
         data[i].endTime= data[i].endTime.substring(11,19);
         console.log(data[i].startTime);
         console.log(data[i].endTime); 
      }
      this.appointments=data;
    })
  }


  
}
  
