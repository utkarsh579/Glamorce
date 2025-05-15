import { Component, HostListener, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartServiceService } from '../services/cart-service.service';
import { OrderServiceService } from '../services/order-service.service';
import { SalonserviceService } from '../services/salonservice.service';
import { DomSanitizer } from '@angular/platform-browser';
import { ProfileService } from '../services/profile.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { map, mergeMap } from 'rxjs/operators';
declare var Razorpay: any;

@Component({
  selector: 'app-cart-service',
  templateUrl: './cart-service.component.html',
  styleUrls: ['./cart-service.component.css']
})
export class CartServiceComponent implements OnInit{
  emailId:string=localStorage.getItem("emailId");
  p :any;
  page = 1;
  count = 0;
  pageSize = 3;
  pageSizes = [3, 6, 9,12]
  @Input()
  cartService:any;
  noOfService:number;
  subTotal:any;
  total:any;
  serviceDetails={
    "appointmentId":"AP012",
    "employeeId":"EMP03",
    "serviceId":"32",
    "slotTime":"",
    "serviceName":"Head Massage",
    "serviceTime":0,
    
}
  bookApp={
    "userId":"vijay@gmail.com",
    "serviceDetailsList":[ ]
}

  services!:any;
  constructor(private cart:CartServiceService,
    private route:Router,private orderService:OrderServiceService,
    private salonService:SalonserviceService,
    private dom:DomSanitizer,private profileService:ProfileService,private snack:MatSnackBar){}
  ngOnInit(): void {
    // this.getAllService();
    //  this.getAllEmployess();
    
    this. chainServicesAndEmployees().subscribe((data:any)=>{
      this.getByEmailId();
    })
    
     
   
    // setTimeout(() => {
    //   this.getByEmailId();
      
    // }, 1000);
    // this.total=this.subTotal;
  }
  // id:any=this.cartService.cartId;
  delete(id:number){
    console.log(id);
    this.cart.deleteByCartId(id).subscribe(newData => {
      // this.cartService = newData;
      // window.location.reload();
      // this.route.navigateByUrl("/cart");
  });
  window.location.reload();
    // this.refresh();
  }
  
  getAllService(){
    this.salonService.getServices().subscribe(
    (data:any)=>{
      console.log(data);
      this.services=data;
      console.log("service");
      console.log(this.services);
      
    })
  //   setTimeout(() => {
  //     this.getByEmailId();
  // }, 500);
    
  }
  employees:any;
  getAllEmployess(){
    this.profileService.getAllEmployees().subscribe(
     ( data:any)=>{
      console.log(data);
      this.employees=data;
      }
    )
  }
  mobileNo:string;
  userName:string;
  getUserDetailsByEmailId(){
     this.profileService.getUser(this.emailId).subscribe(
      (data:any)=>{
        console.log(data);
        this.mobileNo=data.mobileNo;
        this.userName=data.name;
        localStorage.setItem("username",this.userName);
        localStorage.setItem("mobileNo",this.mobileNo);
        console.log(this.mobileNo);
        console.log(this.userName);
               
      });
  }
  getByEmailId(){
    this.cart.getCartByEmailId(localStorage.getItem("emailId")).subscribe(
      (data:any)=>{
        console.log(data);
        this.cartService=data;
        // for (var index in this.cartService) {
        //   console.log(index); // prints indexes: 0, 1, 2, 3
        //   this.noOfService=parseInt(index)+1;
        //   console.log(this.cartService[index].servicePrice); // prints elements: 10, 20, 30, 40
        //   this.subTotal=this.cartService[index].servicePrice;
        // }
        let cartlength=this.cartService.length;
        this.noOfService=cartlength;
        console.log(cartlength);
        let sum=0;
        for(let i=0;i<=cartlength-1;i++){
            console.log(this.cartService[i].serviceId);
            for(let j=0;j<=this.services.length-1;j++){
              console.log(this.services[j].serviceId);
              if(this.cartService[i].serviceId==this.services[j].serviceId){
                console.log("hello");
                this.cartService[i].serviceImage=this.dom.bypassSecurityTrustResourceUrl("data:img/"+"jpg"+";base64,"+this.services[j].serviceImage);
                this.cartService[i].servicePrice=this.services[j].servicePrice;
                this.cartService[i].serviceName=this.services[j].serviceName;
                this.cartService[i].serviceTime=this.services[j].serviceTime;
                this.cartService[i].slotTime=this.cartService[i].slotTime.substring(11,19);
                continue;
               }
            }
            sum =sum+parseInt(this.cartService[i].servicePrice);
            for(let k=0;k<=this.employees.length-1;k++){
              console.log(this.employees[k].employeeEmail);
              if(this.cartService[i].employeeId==this.employees[k].employeeEmail){
                console.log("Hello");
                this.cartService[i].employeeName=this.employees[k].name;
                this.cartService[i].proficiency=this.employees[k].proficiency;
                this.cartService[i].experience=this.employees[k].experience;
                break;
              }
              
            }
          }
         this.subTotal=sum;
        // this.cartService.array.forEach((element: { servicePrice: any; }) => {

        //   console.log(element.servicePrice);
        // });
        // this.subTotal=this.subTotal+this.cartService.servicePrice;
        // for (let i = 0; i < this.cartService.length; i++) {
        //   console.log ("Block statement execution no." + i);
        //   console.log(this.cartService.servicePrice);
        // }
        this.total=this.subTotal;
        this.total=this.total-((this.total*5)/100);
        localStorage.setItem("amount",this.total);
        console.log(this.subTotal);

      });
      this.getUserDetailsByEmailId();
  }

  chainServicesAndEmployees(){
    return this.salonService.getServices().pipe(mergeMap((data:any)=>{
      this.services=data;
      console.log("services");
      
      console.log(this.services);
      
      return this.profileService.getAllEmployees().pipe(map((resp:any)=>{
        this.employees=resp;
        console.log("employees");
        console.log( this.employees);
        
      }))
  }))
  
  }
  refresh(){
    console.log("hello");
    this.route.navigate([this.route.url]);
  }
  //Razor Pay
  paymentId: string;
  error: string;


  //while integrating get today's date and user clicked time for start time


  options = {
    "key": "",
    "amount": "", 
    "name": "Glamorce",
    "description": "Salon",
    // "image": "https://www.javachinna.com/wp-content/uploads/2020/02/android-chrome-512x512-1.png",
    "image": "../../assets/Images/logo.jpg",
    "order_id":"",
    "handler": function (response){
      var event = new CustomEvent("payment.success", 
        {
          detail: response,
          bubbles: true,
          cancelable: true
        }
      );
      
      	  
      window.dispatchEvent(event);
    },
    "prefill": {
    "name": "",
    "email": "",
    "contact": ""
    }
    // "notes": {
    // "address": ""
    // },
    // "theme": {
    // "color": "#3399cc"
    // }
    }; 
    

    orderObj:any;

    onSubmit(): void {

      this.paymentId = ''; 
      this.error = ''; 
      this.orderService.createOrder().subscribe(
      data => {
        this.options.key = "rzp_test_ERxBHlTNtotw4m";
        this.options.order_id = data.razorpayOrderId;
        this.options.amount = data.serviceFee; 
        this.options.prefill.name =this.userName;
        this.options.prefill.email = localStorage.getItem("emailId");
        this.options.prefill.contact = this.mobileNo;
        
      
          // this.options.image="";
          var rzp1 = new Razorpay(this.options);
          console.log(rzp1);
         
          rzp1.open();
        
       
                
        rzp1.on('payment.failed', function (response){    
          
          console.log(response);
          console.log(response.error.code);    
          console.log(response.error.description);    
          console.log(response.error.source);    
          console.log(response.error.step);    
          console.log(response.error.reason);    
          console.log(response.error.metadata.order_id);    
          console.log(response.error.metadata.payment_id);
          this.error = response.error.reason;
        }
        );
      }
      ,
      err => {
        this.error = err.error.message;
      }
      );
    }

    @HostListener('window:payment.success', ['$event']) 
    onPaymentSuccess(event): void {
        console.log(event.detail);
        
        // this.orderService.bookAppointment(event).s
        for(var i=0;i<this.cartService.length;i++){
          console.log(this.cartService[i].slotTime);
          
          this.bookApp.userId=localStorage.getItem("emailId");
          this.serviceDetails.appointmentId=this.cartService[i].appointmentId;
          this.serviceDetails.employeeId=this.cartService[i].employeeId;
          this.serviceDetails.serviceId=this.cartService[i].serviceId;
          this.serviceDetails.serviceName=this.cartService[i].serviceName;
          this.serviceDetails.slotTime=this.cartService[i].slotTime;
          this.serviceDetails.serviceTime=this.cartService[i].serviceTime;
          this.bookApp.serviceDetailsList.push(this.serviceDetails);

          this.orderService.bookAppointment(this.bookApp).subscribe((data:any)=>{
            console.log(data);

          })
          this.snack.open(
            'Payment Successful', 'ok', 
            {duration: 3000, panelClass: ['mat-toolbar', 'mat-primary']}
            );
          this.cart.deleteAll().subscribe(
            (data:any)=>{
              console.log(data);
            }
          );
          this.route.navigateByUrl("/orders")
        }
       
    }
  
}
  


