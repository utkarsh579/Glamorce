import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { OrderListComponent } from "../order-list/order-list.component";

@Injectable({
  providedIn: "root",
})
export class FeedbackService {
  constructor(private httpClient: HttpClient) {}

  url = "https://Glamore.stackroute.io/feedback-app-v1";

  addFeedback(feedbackObj: any): Observable<any> {
    console.log(feedbackObj);

    return this.httpClient.post(this.url + "/add-feedback", feedbackObj);
  }
}
