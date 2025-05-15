import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class OrderListService {
  
  appointment: String = "https://Glamore.stackroute.io/bookappointment";

  constructor(private httpconnection: HttpClient) {}
 
  getbookedAppointmentDetails(emailId: String): Observable<any> {
    return this.httpconnection.get(
      this.appointment + "/appointment-details/" + emailId
    );
  }
}
