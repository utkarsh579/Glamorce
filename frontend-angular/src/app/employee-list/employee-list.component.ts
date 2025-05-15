import { Component, Input, OnInit} from '@angular/core';



@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit  {
 

  @Input()
  employees?: any; 

  @Input()
  services!:any;

  @Input()
  searchText?:string;

  // services!:any; 

  p :any;
  page = 1;
  count = 0;
  pageSize = 2;
  pageSizes = [2, 4, 6,8];

  constructor(){

  }

  ngOnInit(){
      // console.log(this.employees);   
      
  }


 

}
