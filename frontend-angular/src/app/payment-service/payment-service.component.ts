import { Component, HostListener } from '@angular/core';
import { OrderServiceService } from '../services/order-service.service';

declare var Razorpay: any;

@Component({
  selector: 'app-payment-service',
  templateUrl: './payment-service.component.html',
  styleUrls: ['./payment-service.component.css']
})
export class PaymentServiceComponent {
  // constructor(private orderService:OrderServiceService){}

  // // sayHello() {
  // //   alert("Hello DK");
  // // }

  // paymentId: string;
  // error: string;
  
  // options = {
  //   "key": "",
  //   "amount": "", 
  //   "name": "Glamorce",
  //   "description": "Salon",
  //   // "image": "https://www.javachinna.com/wp-content/uploads/2020/02/android-chrome-512x512-1.png",
  //   "image": "../../assets/Images/logo.jpg",
  //   "order_id":"",
  //   "handler": function (response){
  //     var event = new CustomEvent("payment.success", 
  //       {
  //         detail: response,
  //         bubbles: true,
  //         cancelable: true
  //       }
  //     );
      
      	  
  //     window.dispatchEvent(event);
  //   },
  //   "prefill": {
  //   "name": "",
  //   "email": "",
  //   "contact": ""
  //   }
    // "notes": {
    // "address": ""
    // },
    // "theme": {
    // "color": "#3399cc"
    // }
    // };
  
//     onSubmit(): void {
//       this.paymentId = ''; 
//       this.error = ''; 
//       this.orderService.createOrder().subscribe(
//       data => {
//         this.options.key = "rzp_test_ERxBHlTNtotw4m";
//         this.options.order_id = data.razorpayOrderId;
//         this.options.amount = data.serviceFee; 
//         this.options.prefill.name = "vijay";
//         this.options.prefill.email = data.emailId;
//         this.options.prefill.contact = "999999999";
        
      
//           // this.options.image="";
//           var rzp1 = new Razorpay(this.options);
//           console.log(rzp1);
         
//           rzp1.open();
        
       
                
//         rzp1.on('payment.failed', function (response){    
          
//           console.log(response);
//           console.log(response.error.code);    
//           console.log(response.error.description);    
//           console.log(response.error.source);    
//           console.log(response.error.step);    
//           console.log(response.error.reason);    
//           console.log(response.error.metadata.order_id);    
//           console.log(response.error.metadata.payment_id);
//           this.error = response.error.reason;
//         }
//         );
//       }
//       ,
//       err => {
//         this.error = err.error.message;
//       }
//       );
//     }

//     @HostListener('window:payment.success', ['$event']) 
//     onPaymentSuccess(event): void {
//         console.log(event.detail);
//     }
  
}
