import { Component, OnInit } from '@angular/core';
import { User } from '../User';
import { UserService } from '../user.service';
import {Router} from "@angular/router"
@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {
  existingInfo: User;
  userInfo: User;
  updatedInfo: User;

  constructor(
    private userService: UserService,
    private router: Router
  ) { }

  ngOnInit() {
    this.autoFillFields();
  }

  autoFillFields(): void{
    let item = JSON.parse(localStorage.getItem("user"));
    this.existingInfo = item;
  }

  editUserProfile(fname:string, lname:string, userAdd:string, userZip:number, userCountry:string, userPh:string){
    
    let item = JSON.parse(localStorage.getItem("user"));
    //console.log(item);
    this.userInfo = {
    id: item.id, //will be fetched from session
    firstName: fname,
    lastName: lname,
    email: item.email, //will be fetched from session
    pass: item.pass, //will be fetched from session
    address: userAdd,
    postalCode: userZip,
    country: userCountry,
    phoneNumber: userPh,
    isAdmin: item.isAdmin, //will be fetched from session
    isBlocked: item.isBlocked //will be fetched from session
    }
    console.log(this.userInfo);
    this.userService.updateUserInfo(this.userInfo).subscribe(updatedInfo => this.updatedInfo = updatedInfo);
    console.log(this.updatedInfo);
    if(this.userInfo!=null){
    localStorage.removeItem("user");
    localStorage.setItem("user", JSON.stringify(this.userInfo));
    this.router.navigate(['/home']);
    }
  }
}


