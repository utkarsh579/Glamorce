import { Component, Input, OnInit } from '@angular/core';
import { EmployeeService } from '../services/employee.service';

@Component({
  selector: 'app-employees-slots',
  templateUrl: './employees-slots.component.html',
  styleUrls: ['./employees-slots.component.css']
})
export class EmployeesSlotsComponent implements OnInit {


  // p: any;
  // page = 1;
  // count = 0;
  // pageSize = 4;
  // pageSizes = [4, 8, 12, 16];
  // scrollItems: any;
  constructor(private empService: EmployeeService) {

  }
  @Input()
  employees?: any;
  @Input()
  date: any;
  slots:any=[];
  s:any=[];
  ngOnInit() {
    console.log(this.employees);
    this.empService.getSlotByEmpIdAndDate(this.employees.employeeEmail,localStorage.getItem("d1")).subscribe(
      (data:any)=>{
        console.log("data");   
        this.s=data;
        console.log(data);
        for(let i=0;i<data.length;i++){
          // if(data[i].serviceId==localStorage.getItem("serviceId")){
            this.slots.push(data[i].startTime.split(" ")[1]+"-"+data[i].endTime.split(" ")[1])

          // }
          
        }
      }
    )

  }
  UserClicked(slot: any) {
    localStorage.setItem("cartSlot",slot);
    for(let i=0;i<this.s.length;i++){
      if(this.s[i].startTime.split(" ")[1]+"-"+this.s[i].endTime.split(" ")[1]==slot){
         localStorage.setItem("appointmentId",this.s[i].appointmentId)
      }
    }
  };
}

