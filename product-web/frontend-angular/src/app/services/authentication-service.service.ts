import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { login } from "../Model/Login";

@Injectable({
  providedIn: "root",
})
export class AuthenticationServiceService {
  constructor(private httpClient: HttpClient) {}
  role: string;
  AuthenticationAppBeBaseUrl =
    "https://Glamore.stackroute.io/authentication-app";
  loginCheck(loginDetails: login) {
    return this.httpClient.post(
      this.AuthenticationAppBeBaseUrl + "/login-check",
      loginDetails
    );
  }
}
