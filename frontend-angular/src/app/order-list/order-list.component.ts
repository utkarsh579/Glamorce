import { Component } from '@angular/core';
import { Order } from '../Model/orderList';
import { OrderListService } from '../services/order-list.service';
import { SalonserviceService } from '../services/salonservice.service';
import { DomSanitizer } from '@angular/platform-browser';
import { OrderHistory } from '../Model/OrderHistory';
import { EmployeeService } from '../services/employee.service';
import { map, mergeMap } from 'rxjs/operators';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent {

  orders:Order[]=[];
  
  

  p :any;
  page = 1;
  count = 0;
  pageSize = 3;
  pageSizes = [3,6,12,15];
  services!: any;
  allEmployees!: any;


  constructor(private ser:OrderListService,
    private salonService:SalonserviceService,
    private dom:DomSanitizer,
    private employeeService:EmployeeService){}
  
  orderdetails!:any;
  ngOnInit(): void {
//     // this.getOrders();
//     this.getappointmentDetails();  
//     setTimeout(() => {
//       this.getAllRegisteredEmp();
      
      
//   }, 1000);
//   setTimeout(() => {
//     this.getAllServices();
    
    
// }, 1000);

this.chainServicesAndEmployees().subscribe((response:any)=>{
  console.log(response);
  this.getappointmentDetails();
  
})
  
  }
  
  emailId=localStorage.getItem("emailId");//change when doing integration to localStorage.getItem("emailId");
 getAllServices(){
  this.salonService.getServices().subscribe(
    (data:any)=>{
        console.log(data);
        this.services=data;
      
        
        
        // let appointmentlength=this.orderdetails.length;
        // let empDatalength=this.allEmployees.length;
        // console.log(appointmentlength);
        // for(let j=0;j<=appointmentlength-1;j++){
        //   console.log(this.orderdetails[j].serviceId);
        //   for(let k=0;k<=empDatalength-1;k++){
        //     if(this.orderdetails[j].employeeId==this.allEmployees[k].employeeEmail){
        //       console.log("emp hello");
        //       this.orderdetails[j].employeeName=this.allEmployees[k].name;
        //       this.orderdetails[j].employeeProficiency=this.allEmployees[k].proficiency;
        //       continue;
        //     }
        //   }
        //   for(let i=0;i<=data.length-1;i++){
        //     if(this.orderdetails[j].serviceId==data[i].serviceId){
        //       console.log("hello");
        //       this.orderdetails[j].serviceImage=this.dom.bypassSecurityTrustResourceUrl("data:img/"+"jpg"+";base64,"+data[i].serviceImage);
        //       this.orderdetails[j].servicePrice=data[i].servicePrice;
        //       this.orderdetails[j].serviceTime=data[i].serviceTime;
        //       continue;
        //      }
        //   }
          
        // }

    });
      
 }

getappointmentDetails(){
  
    this.ser.getbookedAppointmentDetails(this.emailId).subscribe(
      (data:any)=>{
        console.log(data);
        console.log(data.serviceDetailsList);
        this.orderdetails=data.serviceDetailsList;
        let appointmentlength=this.orderdetails.length;
        let empDatalength=this.allEmployees.length;
        console.log(appointmentlength);
        for(let j=0;j<=appointmentlength-1;j++){
          console.log(this.orderdetails[j].serviceId);
          for(let k=0;k<=empDatalength-1;k++){
            if(this.orderdetails[j].employeeId==this.allEmployees[k].employeeEmail){
              console.log("emp hello");
              this.orderdetails[j].employeeName=this.allEmployees[k].name;
              this.orderdetails[j].employeeProficiency=this.allEmployees[k].proficiency;
              
            }
          }
          for(let i=0;i<=this.services.length-1;i++){
            if(this.orderdetails[j].serviceId==this.services[i].serviceId){
              console.log("hello");
              this.orderdetails[j].serviceImage=this.dom.bypassSecurityTrustResourceUrl("data:img/"+"jpg"+";base64,"+this.services[i].serviceImage);
              this.orderdetails[j].servicePrice=this.services[i].servicePrice;
              this.orderdetails[j].serviceTime=this.services[i].serviceTime;
              
             }
          }
          
        }
        console.log("Order Details");
        
        console.log(this.orderdetails);
        
      }
    )
    
}
currentappointmentId:any="";
feedback(data:any){
this.currentappointmentId=data;

}
getAllRegisteredEmp(){ 
  this.employeeService.getAllRegisteredEmp().subscribe((data:any)=>{
    
    console.log(data);
    this.allEmployees=data;
   
    
  })
}


chainServicesAndEmployees(){
  return this.salonService.getServices().pipe(mergeMap((data:any)=>{
    this.services=data;
    console.log("services");
    
    console.log(this.services);
    
    return this.employeeService.getAllRegisteredEmp().pipe(map((resp:any)=>{
      this.allEmployees=resp;
      console.log("employees");
      console.log( this.allEmployees);
      
    }))
}))

}
}
