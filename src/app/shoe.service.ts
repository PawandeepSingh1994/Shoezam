import { Injectable } from '@angular/core';
import { Shoe } from './shoe';
import { Observable , of} from'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ShoeService {

  constructor(private httpClient: HttpClient) { }

  Shoes: Shoe[];
  getAllShoes: string = "http://ec2-18-223-124-118.us-east-2.compute.amazonaws.com:8080/shoesappshoezam/shoes";

  getShoes(): Observable<Shoe[]>{
    return this.httpClient.get<Shoe[]>(this.getAllShoes);
  }

  getShoesForLoggedInUser(id: number): Observable<Shoe[]>{
    return this.httpClient.get<Shoe[]>(this.getAllShoes+"/sale/client/"+id);
  }

  searchForShoesBrand(input: string): Observable<Shoe[]>{
    return this.httpClient.get<Shoe[]>(this.getAllShoes+"/brand/"+input);
  }

  searchForShoesColor(input: string): Observable<Shoe[]>{
    return this.httpClient.get<Shoe[]>(this.getAllShoes+"/color/"+input);
  }

  searchForShoesSize(min: number, max: number): Observable<Shoe[]>{
    return this.httpClient.get<Shoe[]>(this.getAllShoes+"/size/"+min+"/"+max);
  }

  searchForShoesPrice(min: number, max: number): Observable<Shoe[]>{
    return this.httpClient.get<Shoe[]>(this.getAllShoes+"/price/"+min+"/"+max);
  }

  getShoeRequestSentPerUser(): Observable<Shoe[]>{
    return this.httpClient.get<Shoe[]>(this.getAllShoes);
  }

  getShoeRequestRecievedPerUser(): Observable<Shoe[]>{
    return of(this.Shoes);
  }

  getAllShoesPerUser(id: number): Observable<Shoe[]>{
    return this.httpClient.get<Shoe[]>(this.getAllShoes+"/client/"+id);
  }

  addShoe(shoe: Shoe): Observable<Shoe>{
    return this.httpClient.post<Shoe>(this.getAllShoes, shoe);
  }

  removeShoeListing(id: number): Observable<Shoe>{
    console.log(id);
    return this.httpClient.get<Shoe>(this.getAllShoes+"/remove/"+id);

  }

}
