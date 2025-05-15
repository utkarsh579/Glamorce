import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { register } from "../Model/Register";
import { Observable } from "rxjs";
import { employee } from "../Model/EmployeeReg";
import { Employee } from "../Model/Employee";

@Injectable({
  providedIn: "root",
})
export class RegisterService {
  private url = "https://Glamore.stackroute.io/user";
  private url1 = "https://Glamore.stackroute.io/employee";

  constructor(private httpClient: HttpClient) {}

  registerUser(registerDetails: register): Observable<Object> {
    return this.httpClient.post(`${this.url}/user`, registerDetails);
  }
  registerEmployee(employee: any): Observable<Object> {
    return this.httpClient.post(`${this.url1}/employee`, employee);
  }

  postEmployee(employee: employee, file: File): Observable<any> {
    const formData: FormData = new FormData();
    employee.profilePhoto = null;
    const a = JSON.stringify(employee);
    formData.append("employee", a);
    formData.append("profilePhoto", file);
    return this.httpClient.post(`${this.url1}/employee`, formData);
  }

  getEmployeeImage() {
    return this.httpClient.get(`${this.url1}/employees`);
  }
}
