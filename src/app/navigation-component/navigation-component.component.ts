import { Component, OnInit } from '@angular/core';
import { User } from '../User';
import { UserService } from '../user.service';
import {Router} from "@angular/router"

@Component({
  selector: 'app-navigation-component',
  templateUrl: './navigation-component.component.html',
  styleUrls: ['./navigation-component.component.css']
})
export class NavigationComponentComponent implements OnInit {

  isUserLoggedIn: boolean;
  isUserManager: boolean;
  isUserUser: Boolean;
  SignUpUserInfo: User;
  userTempInfo: User;
  loggedInUser: User;
  addResult: boolean;

  constructor(
    private userService: UserService,
    private router: Router
  ) { }

  ngOnInit() {
    this.changeVals();
  }

  changeVals(): void{
    if(localStorage.length == 0){
      this.isUserLoggedIn = false;
      this.isUserUser = false;
      this.isUserManager = false;
    }
    else{
      let item = JSON.parse(localStorage.getItem("user"));
      if(item.isAdmin == true){
        this.isUserLoggedIn = true;
        this.isUserManager = true;
        this.isUserUser = false;
      }
      else{
        this.isUserLoggedIn = true;
        this.isUserManager = false;
        this.isUserUser = true;
      }
    }
  }

  login(username, password): void {
    console.log(username+" "+password);
    
    this.userTempInfo = {
        id: 1,
        firstName: null,
        lastName: null,
        email: username,
        pass: password,
        address: null,
        postalCode: null,
        country: null,
        phoneNumber: null,
        isAdmin: false,
        isBlocked: false
    }
    
    console.log(this.userTempInfo);
    //this.loggedInUser = this.userTempInfo;
    console.log(this.loggedInUser);
    
    this.userService.login(this.userTempInfo).subscribe(loggedUser => this.loggedInUser = loggedUser);
    
    console.log("hello");

    console.log(this.loggedInUser);
    if(this.loggedInUser != null && this.loggedInUser.isBlocked != true){
    localStorage.setItem("user", JSON.stringify(this.loggedInUser));
    console.log(this.loggedInUser);
    window.location.reload();
    this.router.navigate(['/home']);
    }
  }

  logout(): void{
    localStorage.removeItem("user");
    window.location.reload();
    this.router.navigate(['/home']);
  }

  userSignUp(fname:string, lname:string, e_mail:string, password:string, streetAdd:string, postal:number, user_country:string, phoneNumber:string){
    let result: boolean;
    this.SignUpUserInfo = {
      id: 0,
      firstName: fname,
      lastName: lname,
      email: e_mail,
      pass: password,
      address: streetAdd,
      postalCode: postal,
      country: user_country,
      phoneNumber: phoneNumber,
      isAdmin: false,
      isBlocked: false
    }
    console.log(this.SignUpUserInfo);
    this.userService.userSignUp(this.SignUpUserInfo).subscribe(addResult => this.addResult = addResult);
    console.log(this.addResult);
    
      window.location.reload();
    
    }

  

  

}
