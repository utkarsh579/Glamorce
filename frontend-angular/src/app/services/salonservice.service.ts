import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
@Injectable({
  providedIn: "root",
})
export class SalonserviceService {
  // salonAppBaseUrl = "http://localhost:8085/category";

  salonAppBaseUrl = "https://Glamore.stackroute.io/category";

  // employeeUrl = "http://localhost:8087/employee/";
  employeeUrl = "https://Glamore.stackroute.io/employee/";

  // appointmentUrl = "http://localhost:8081";

  appointmentUrl = "https://Glamore.stackroute.io";

  categoryname: any;

  constructor(private client: HttpClient) {}

  addCategory(services: any) {
    return this.client.post(`${this.salonAppBaseUrl}/add-category`, services);
  }

  updateCategory(service: any, file: File, categoryName: any) {
    const formdata: FormData = new FormData();
    service.serviceImage = null;
    const a = JSON.stringify(service);
    formdata.append("service", a);
    formdata.append("serviceImage", file);
    return this.client.put(
      `${this.salonAppBaseUrl}/category/` + categoryName,
      formdata
    );
  }

  updateService(services: any, file: File, serviceId: any) {
    const formdata: FormData = new FormData();
    services.serviceImage = null;
    const a = JSON.stringify(services);
    formdata.append("services", a);
    formdata.append("serviceImage", file);
    return this.client.put(
      `${this.salonAppBaseUrl}/service/` + serviceId,
      formdata
    );
  }

  // getAllServices() {
  //   console.log("get all services");
  //   return this.client.get(this.salonAppBaseUrl + "/categories");
  // }

  getCategoryByName(categoryName: any) {
    this.categoryname = categoryName;
    console.log(categoryName);

    return this.client.get(this.salonAppBaseUrl + "/category/" + categoryName);
  }

  getEmployeesByProficiency(proficiency: string) {
    return this.client.get(this.employeeUrl + "employees/" + proficiency);
  }

  getAllCategories() {
    return this.client.get(this.salonAppBaseUrl + "/categories");
  }

  getAppointmentsByEmployeeAndDate(employeeId: any, date: any) {
    return this.client.get(
      this.appointmentUrl + "/appointment/" + employeeId + "/" + date
    );
  }

  newAppointment(slot: any) {
    return this.client.post(
      // this.appointmentUrl + "/appointment/new-appointment",
      this.appointmentUrl + "/appointment/create-appointment",
      slot
    );
  }

  createAppointment(data: any) {
    return this.client.post(
      // this.appointmentUrl + "/appointment/new-appointment",
      this.appointmentUrl + "/appointment/create-appointment",
      data
    );
  }

  getServices() {
    return this.client.get(this.salonAppBaseUrl + "/services");
  }
}
