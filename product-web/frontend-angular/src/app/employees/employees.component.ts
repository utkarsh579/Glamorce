import { Component, Input, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { employee } from '../Model/EmployeeReg';
import { EmployeeService } from '../services/employee.service';
import { ProfileService } from '../services/profile.service';

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {
  p :any;
  page = 1;
  count = 0;
  pageSize = 4;
  pageSizes = [4, 8, 12,16];

  @Input()
  employee?: any;
  empData: any;
  constructor(private proService: ProfileService, private dom: DomSanitizer) { }
  ngOnInit() {
    console.log(this.employee);
    
    this.proService.getEmployeeById(this.employee).subscribe(
      (data: any) => {
        console.log(data);
        
        this.empData = data;
        // this.empData.profilePhoto = this.dom.bypassSecurityTrustResourceUrl("data:img/" + "jpg" + ";base64," + data.profilePhoto);
        // console.log(this.empData);
        
      }
    )
  }
  
}
