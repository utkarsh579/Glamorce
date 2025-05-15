import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

const httpOptions = {
  headers: new HttpHeaders({ "Content-Type": "application/json" }),
};
@Injectable({
  providedIn: "root",
})
export class CartServiceService {
  cartBaseUrl = "https://Glamore.stackroute.io/cart/cart";

  constructor(private http: HttpClient) {}

  addToCart(cartObj: any): Observable<any> {
    return this.http.post(this.cartBaseUrl + "/add", cartObj);
  }
  // emailId:String="amit@gmail.com";
  getCartByEmailId(emailId: String) {
    return this.http.get(this.cartBaseUrl + "/get/" + emailId);
  }
  // cartId:number=3;
  // deleteByCartId(cartId:any){
  //   console.log(cartId);
  //   // return this.http.delete(this.cartBaseUrl+"remove/"+cartId);
  //   return this.http.delete("http://localhost:8082/cart/remove/2");
  // }
  deleteByCartId(id?: number) {
    console.log(id);
    let did = `/${id}`;
    return this.http.delete(this.cartBaseUrl + "/remove" + did);
  }
 
  deleteAll(){
    return this.http.delete(this.cartBaseUrl+"/remove-all-by-emailId/"+localStorage.getItem("emailId"));
  }
}
