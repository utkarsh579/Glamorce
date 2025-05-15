import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RecommendationService {
  
  private url = "https://Glamore.stackroute.io/category/services";

  constructor(private httpClient:HttpClient) { }

  getAllServices(){
    return this.httpClient.get(`${this.url}`);
  }
}
