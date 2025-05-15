import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";


@Injectable({
  providedIn: "root",
})
export class EmployeeService {
 

  url: string = "https://Glamore.stackroute.io/employee";

  appointmentUrl = "https://Glamore.stackroute.io/appointment";
  constructor(private http: HttpClient) {}



  getAllRegisteredEmp() {
    return this.http.get(`${this.url}/employees`);
  }

  getAllAppointments() {
    return this.http.get(`${this.appointmentUrl}/get-all-appointments`);
  }

  postEmployee(data: any) {
    return this.http.post(`${this.appointmentUrl}/new-appointment`, data);
  }

  getServiceById(serviceId: String) {
    return this.http.get(
      `${this.appointmentUrl}/get-appointment-by-serviceId/${serviceId}`
    );
  }

  getEmployeeById(employeeId: String) {
    return this.http.get(
      `${this.appointmentUrl}/get-appointment-by-employeeId/${employeeId}`
    );
  }

  updateEmployee(employee: any) {
    return this.http.put(`${this.appointmentUrl}/update-appointment`, employee);
  }

  getEmployeeByProficiency(proficiency: any) {
    return this.http.get(`${this.url}/employees/` + proficiency);
  }

  getEmployeeByEmail(empId: any) {
    return this.http.get(`${this.url}/employee/` + empId);
  }
  getSlotByServiceId(serviceId: any, date: any) {
    return this.http.get(
      this.appointmentUrl +
        "/get-appointment-by-serviceId/" +
        serviceId +
        "/" +
        date
    );
  }
  getSlotByEmpIdAndDate(employeeId: any, date: any) {
    return this.http.get(this.appointmentUrl + "/" + employeeId + "/" + date);
  }
}
