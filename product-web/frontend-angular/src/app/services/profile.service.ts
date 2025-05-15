import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Address } from "../Model/Address";
import { User } from "../Model/User";

@Injectable({
  providedIn: "root",
})
export class ProfileService {
  URL: string = "https://Glamore.stackroute.io/user";
  url: string = "https://Glamore.stackroute.io/employee/";

  constructor(private http: HttpClient) {}

  getUser(emailId: string) {
    return this.http.get(`${this.URL}/user/${emailId}`);
  }

  deleteUser(emailId: string) {
    return this.http.delete<User>(`${this.URL}/${emailId}`);
  }

  updateUser(formData: FormData, emailId: string): Observable<any> {
    return this.http.put<User>(`${this.URL}/${emailId}`, formData);
  }

  updateName(emailId: string, name: string) {
    return this.http.patch(`${this.URL}/name?emailId=${emailId}`, name);
  }

  updateMobileNo(emailId: string, mobileNo: string) {
    return this.http.patch(`${this.URL}/mobileNo?emailId=${emailId}`, mobileNo);
  }

  updateAddress(emailId: string, address: Address) {
    return this.http.patch(`${this.URL}/address?emailId=${emailId}`, address);
  }

  updateImage(emailId: string, file: File) {
    const formData: FormData = new FormData();
    formData.append("profilePhoto", file);
    return this.http.patch(`${this.URL}/image?emailId=${emailId}`, formData);
  }
  getEmployeeById(empId: any) {
    return this.http.get(this.url + "employee/" + empId);
  }
  getAllEmployees() {
    return this.http.get(this.url + "employees");
  }
}
