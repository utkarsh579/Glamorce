import { Component,OnInit} from '@angular/core';
import { SalonserviceService } from '../services/salonservice.service';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-salon-services',
  templateUrl: './salon-services.component.html',
  styleUrls: ['./salon-services.component.css'],
})
export class SalonServicesComponent implements OnInit
{

  triggerButton:boolean=false;
  p :any;
  page = 1;
  count = 0;
  pageSize = 3;
  pageSizes = [3,6,9];
  testSelect:string="Skin";
  servicesData=[];
  ngOnInit() {
  
    this.getAllCategories();
    
    
  }
constructor(private salonService:SalonserviceService,private dom:DomSanitizer){}

  allSalonServices:any;
  picData:any;

 
selectedValue:any;
data:any

gvshgvsav(data:any){
// this.data=data;

// for(let i=0; i<data.length; i++){
//   console.log(i);
//   this.data[i].serviceImage=this.dom.bypassSecurityTrustResourceUrl("data:img/jpg;base64,"+data[i].serviceImage);
// }
localStorage.setItem("categoryName",data);
this.getCategoryByName();


}

allCategories:any

getAllCategories()
{
  this.salonService.getAllCategories().subscribe((data:any)=>{
    console.log("categories");
    
      console.log(data);
      this.allCategories=data;
      console.log(this.allCategories);
      
  }
  
  )
  this.selectedValue="Skin";
  this.getCategoryByName();
}

catName:any;

openDiv(){
  this.catName=this.allCategories.categoryName;
  console.log(this.catName);
  this.triggerButton=true;
  this.getCategoryByName();
  
}

getCategoryByName()
{
  // if(this.salonService.categoryname!=null)
  // {
  //   localStorage.setItem('categoryName',this.salonService.categoryname)
  // }
  this.salonService.getCategoryByName(localStorage.getItem('categoryName')).subscribe({
    next:(response:any)=>
    {
      this.servicesData=response.services;
     for(var i=0;i<response.services.length;i++){
      this.servicesData[i].serviceImage=this.dom.bypassSecurityTrustResourceUrl("data:img/jpg;base64,"+response.services[i].serviceImage);
     }

    
    }
  })
}


}
















