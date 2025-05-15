import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';
import { RecommendationService } from '../services/recommendation.service';
import { SalonserviceService } from '../services/salonservice.service';

@Component({
  selector: 'app-recommendation',
  templateUrl: './recommendation.component.html',
  styleUrls: ['./recommendation.component.css']
})
export class RecommendationComponent implements OnInit {

  services!: any[]; 

  p :any;
  page = 1;
  count = 0;
  pageSize = 2;
  pageSizes = [2,4,6,8];
  serviceId:any;

  constructor(private recomService:RecommendationService, 
    private router:Router,private dom:DomSanitizer, private salonService: SalonserviceService, private activatedRoute:ActivatedRoute) {}

  ngOnInit(): void {
    this.getServices();
    this.activatedRoute.paramMap.subscribe(params=>{
      let id=params.get("serviceId") ?? 0;
      console.log(id);
      this.serviceId=id;
      localStorage.setItem("serviceId",this.serviceId);
    })
  }

  getServices(){
    this.salonService.getServices().subscribe((data:any)=> {
      console.log(data);
      this.services = data;
      for(let i=0; i<data.length; i++){
        console.log(i);
        this.services[i].serviceImage=this.dom.bypassSecurityTrustResourceUrl("data:img/"+"jpg"+";base64,"+data[i].serviceImage);
      }
    });
  }

}
