import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

const httpOptions = {
  headers: new HttpHeaders({ "Content-Type": "application/json" }),
};
@Injectable({
  providedIn: "root",
})
export class OrderServiceService {
  constructor(private http: HttpClient) {}

  baseUrl: String = "https://Glamore.stackroute.io/payment";

  appointment: String = "https://Glamore.stackroute.io/bookappointment";

  createOrder(): Observable<any> {
    return this.http.post(
      this.baseUrl + "/createOrder",
      {
        customerName: localStorage.getItem("username"),
        email: localStorage.getItem("emailId"),
        phoneNumber: localStorage.getItem("mobileNo"),
        amount: parseInt(localStorage.getItem("amount")),
       
      },
      httpOptions
    );
  }
  getByEmailId(emailId: String): Observable<any> {
    return this.http.get(this.baseUrl + "/order-details/" + emailId);
  }
  bookAppointment(bookAppointmentObj: any): Observable<any> {
    return this.http.post(
      this.appointment + "/appointment",
      bookAppointmentObj
    );
  }
}
