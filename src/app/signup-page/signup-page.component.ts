import { Component, OnInit } from '@angular/core';
import { User } from '../User';
import { UserService } from '../user.service';
import {Router} from "@angular/router"

@Component({
  selector: 'app-signup-page',
  templateUrl: './signup-page.component.html',
  styleUrls: ['./signup-page.component.css']
})
export class SignupPageComponent implements OnInit {

  SignUpUserInfo: User;
  addResult: boolean;
  

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
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
    
    this.router.navigate(['/home']);
    
    }

}
