import { Injectable } from '@angular/core';
import { Shoe } from './shoe';
import { User } from './User';
import { Request } from './request';
import { HttpClient } from '@angular/common/http'; 
import { Observable, of} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SwapRequestServiceService {

  getRequests: string = "http://localhost:8080/ShoesAppShoezam/swaps";

  constructor(private http: HttpClient) { }

  getRequestsByUser(id: number): Observable<Request[]>{
    return this.http.get<Request[]>(this.getRequests+"/from/client/"+id);
  }

  getRequestsToUser(id: number): Observable<Request[]>{
    return this.http.get<Request[]>(this.getRequests+"/to/client/"+id);
  }

  addNewRequest(request: Request): Observable<Request>{
    return this.http.post<Request>(this.getRequests, request);
  }

  denyRequest(request: Request): Observable<string>{
    return this.http.post<string>(this.getRequests+"/deny", request);
  }

  approveRequest(request: Request): Observable<string>{
    return this.http.post<string>(this.getRequests+"/resolve", request);
  }
}
