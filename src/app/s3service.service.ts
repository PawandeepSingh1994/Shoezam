import { Injectable } from '@angular/core';
import { Shoe } from './shoe';
import { Observable , of} from'rxjs';
import { HttpClient } from '@angular/common/http';
import { User } from './User';

@Injectable({
  providedIn: 'root'
})
export class S3serviceService {

  constructor(private http: HttpClient) { }

  getCredentials(): Observable<User>{
    return this.http.get<User>("http://ec2-18-223-124-118.us-east-2.compute.amazonaws.com:8080/shoesappshoezam/s3_credentials");
  }

  uploadImage(endpoint: string, fd: FormData): Observable<Response>{
    return this.http.post<Response>(endpoint, fd);
  }
}
