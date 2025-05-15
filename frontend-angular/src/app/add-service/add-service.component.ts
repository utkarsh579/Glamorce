import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SalonserviceService } from '../services/salonservice.service';
import { Router } from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-add-service',
  templateUrl: './add-service.component.html',
  styleUrls: ['./add-service.component.css']
})
export class AddServiceComponent {

  salonnnService= {
    "serviceId": "",
    "serviceName": "",
    "serviceTime": "",
    "servicePrice": "",
    "serviceDescription": "",
    "serviceImage": null
}
  data={
    "categoryName": "",
    "services": [
       
    ]
}

  serviceform:FormGroup;

  constructor(private fb:FormBuilder,private salonService:SalonserviceService,private dom:DomSanitizer,private r:Router){

  this.serviceform=this.fb.group({
    categoryName:['',[Validators.required,Validators.minLength(3)]],
    services: this.fb.group({
      serviceName: [, [Validators.required]],
      serviceTime: [, [Validators.required]],
      servicePrice: ['', [Validators.required]],
      serviceDescription: ['', [Validators.required, Validators.minLength(10)]]
    }),
    });
  }

  get categoryName() { return this.serviceform.get("categoryName") }
  get serviceName() { return this.serviceform.get("serviceName") }
  get serviceTime() { return this.serviceform.get("serviceTime") }
  get servicePrice() { return this.serviceform.get("servicePrice") }
  get serviceDescription() { return this.serviceform.get("serviceDescription") }
  
  category:any=null;
  loading:boolean=false;
  file:File=null;
  shortLink: string = "";

  onChange(event) {
    this.file = event.target.files[0];
  }

  OnSubmit(){
    console.log("1");
    console.log(this.serviceform.value);
    this.data.categoryName=this.serviceform.value.categoryName;
    this.salonnnService.serviceName=this.serviceform.value.services.serviceName;
    this.salonnnService.servicePrice=this.serviceform.value.services.servicePrice;
    this.salonnnService.serviceTime=this.serviceform.value.services.serviceTime;
    this.salonnnService.serviceDescription=this.serviceform.value.services.serviceDescription;
    this.data.services=[];
    this.data.services.push(this.salonnnService);
    console.log("2");
    console.log(this.data);

    this.salonService.updateCategory(this.salonnnService,this.file,this.data.categoryName,).subscribe(response => {
      console.log("service added")
      console.log(response);
        (event: any) => {
          if (typeof (event) === 'object') {
                // Short link via api response
                this.shortLink = event.link;
                this.loading = false; // Flag variable
          }
            this.salonnnService.serviceImage=this.dom.bypassSecurityTrustResourceUrl("data:img/"+"jpg"+";base64,"+event.serviceImage);
        }
    });

   
    this.serviceform.reset();
     this.r.navigateByUrl("salon-services")
  }

  ngOnInit(): void {
  }

}
