import { Component, Input, OnInit, Optional, Inject} from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { EmployeeCardComponent } from '../employee-card/employee-card.component';
import { LoginComponent } from '../login/login.component';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../Model/Employee';
import { Service } from '../Model/service';
import { EmployeeService } from '../services/employee.service';
import { SalonserviceService } from '../services/salonservice.service';
import { MatSnackBar } from '@angular/material/snack-bar';






@Component({
  selector: 'app-create-slots',
  templateUrl: './create-slots.component.html',
  styleUrls: ['./create-slots.component.css']
})



export class CreateSlotsComponent implements OnInit {


date:any;
selected:any;
selectedValue:any;
@Input()
employee?:any;

selectedTime?:any;
selectedDate?:any;
// time:any;
// meridian:any;
services:any;
slot:any={"startTime":"","employeeId":"","serviceId":0,"serviceTime":0,"employeeName":""}
meridiem:any;
// hours:any;
minutes:any;
seconds:any;
// startTime:any={"date"}
employeeId:any;
employeeName:any;



  constructor(public dialogRef: MatDialogRef<CreateSlotsComponent>,
    @Optional() @Inject(MAT_DIALOG_DATA) public data: any,
    private formBuilder : FormBuilder ,
    private employeeService:EmployeeService, private salonServices:SalonserviceService,
    private _snackBar:MatSnackBar ){
      this.employeeId=data.value;
      this.employeeName=data.value1;
      
    }

  createSlotForm:FormGroup=this.formBuilder.group({
    timeForm :this.formBuilder.group({
      hour:[,[]],
      minute:[,[]],
      second:[,[]]
    }),
    date :[''],
    service: this.formBuilder.group({
      serviceId: ['', []],
      serviceName: ['', []],
      serviceTime: ['', []],
      servicePrice: ['', []]
  }
  )
  })




  get hour() { return this.createSlotForm.get("hour") }
  get minute() { return this.createSlotForm.get("minute") }
  get second() { return this.createSlotForm.get("second") }
  get datee(){return this.createSlotForm.get("date") }
  get serviceId() { return this.createSlotForm.get("serviceId") }
  get serviceTime() { return this.createSlotForm.get("serviceTime") }
  get startTime() { return this.createSlotForm.get("startTime") }
  get service() { return this.createSlotForm.get("services") }
  

  date2 = new FormControl(new Date());
  serializedDate = new FormControl((new Date()).toISOString());

 


ngOnInit(): void {
  console.log(this.employee);
  this.salonServices.getCategoryByName(localStorage.getItem("category")).subscribe((data:any)=>{
    this.services=data.services;
    // this.slot.serviceId=data.services[i].serviceId;
    console.log("services");
    console.log(this.services);
  })
  
}

OnSubmit(){

  console.log("empId");
  console.log(this.employeeId);
  console.log("name");
  console.log(this.employeeName);
  
  
  console.log(this.slot);
  console.log(this.createSlotForm.value.timeForm.hour);
  console.log(this.serializedDate.value);

  console.log();
  
  console.log(this.date);

  this.slot.startTime=this.date+" "+this.createSlotForm.value.timeForm.hour+":"+this.createSlotForm.value.timeForm.minute+":"+this.createSlotForm.value.timeForm.second;
  console.log(this.slot.startTime);
 
  console.log(this.selectedValue);
  this.slot.serviceId=this.selectedValue.serviceId;
  this.slot.serviceName=this.selectedValue.serviceName;
  this.slot.servicePrice=this.selectedValue.servicePrice;
  this.slot.serviceTime=this.selectedValue.serviceTime;
  this.slot.employeeName=this.employeeName;
  this.slot.employeeId=this.employeeId;
  console.log(this.slot.employeeName);
  console.log(this.slot.employeeId);
  console.log(this.slot.serviceId);
  console.log(this.slot.serviceName);
  console.log( this.slot.servicePrice);
  console.log(this.slot.serviceTime);
  this.createSlot(this.slot);
}



onChange(e){

  console.log(e);

  var month:any =(e.getMonth()+1);
    var d:any=(e.getDate());
    if(month<10 ){
      month="0"+month.toString();
    }
    if(d<10 ){
      d="0"+d.toString();
    }
   this.date=e.getFullYear().toString()+"-"+month+"-"+d;
   console.log("date");
   
   console.log(this.date);
   
  
}





createSlot(slot){
  console.log("slotss");
console.log(slot);
   this.salonServices.createAppointment(slot).subscribe((data)=>{
    console.log(data);
      this.slot=data;
      console.log("slotsss");
      console.log(this.slot);
     },
    (error:any)=>{
      this._snackBar.open('Slot Cannot Be Booked', 'ok', {
        duration: 5000,
        panelClass: ['mat-toolbar', 'mat-primary']
      });
    })

   this.dialogRef.close();
   window.location.reload();
}


editEmployee() {
  this.employeeService.updateEmployee(this.employee).subscribe(data => {
    this.employee = data;
  })
}

  getErrorMessage() {
  
    return 'You must enter a value';
  }


  onNoClick(): void {
    this.dialogRef.close();
  }

  addSlot(){
    console.log(this.createSlotForm.value);
    
  }
}
function getSelectsFromPicker(timePicker: any) {
  throw new Error('Function not implemented.');
}

