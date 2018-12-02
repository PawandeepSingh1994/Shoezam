import { Injectable } from '@angular/core';
import { User } from './User';
import { HttpClient } from '@angular/common/http'; 
import { Observable, of} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }

  allUsers: User[];
  url: string = 'http://ec2-18-223-124-118.us-east-2.compute.amazonaws.com:8080/shoesappshoezam/clients';

  getAllUsers(): Observable<User[]>{
    return this.httpClient.get<User[]>(this.url);
  }

  login(user: User): Observable<User> {
    return this.httpClient.post<User>(this.url+"/login", user);
  }

  userSignUp(newUser: User): Observable<boolean>{
    return this.httpClient.post<boolean>(this.url, newUser);
  }

  updateUserInfo(newInfo: User): Observable<User>{
    return this.httpClient.put<User>(this.url, newInfo);
  }

  updateUserPassword(newInfo: User): Observable<User>{
    return this.httpClient.put<User>(this.url, newInfo);
  }

  blockAccount(user: User): Observable<string>{
    return this.httpClient.put<string>(this.url+"/block", user);
  }

}
