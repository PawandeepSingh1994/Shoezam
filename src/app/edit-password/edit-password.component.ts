import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../User';
import {Router} from "@angular/router"


@Component({
  selector: 'app-edit-password',
  templateUrl: './edit-password.component.html',
  styleUrls: ['./edit-password.component.css']
})
export class EditPasswordComponent implements OnInit {

  newInfo: User;
  updatedInfo: User;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
  }

  updateUserPassword(oldPassword:string, newPassword:string){
      let item = JSON.parse(localStorage.getItem("user"));
      if(oldPassword == item.pass){ //if old password is same as in session!
        this.newInfo = {
          id: item.id, //will be fetched from session
          firstName: item.firstName, //will be fetched from session
          lastName: item.lastName, //will be fetched from session
          email: item.email, //will be fetched from session
          pass: newPassword,
          address: item.address, //will be fetched from session
          postalCode: item.postalCode, //will be fetched from session
          country: item.country, //will be fetched from session
          phoneNumber: item.phoneNumber, //will be fetched from session
          isAdmin: item.isAdmin, //will be fetched from session
          isBlocked: item.isBlocked //will be fetched from session
          }
        this.userService.updateUserPassword(this.newInfo).subscribe(updatedInfo => this.updatedInfo = updatedInfo);
        console.log(this.updatedInfo);
        if(this.newInfo!=null){
          localStorage.removeItem("user");
          localStorage.setItem("user", JSON.stringify(this.newInfo));
          this.router.navigate(['/home']);
          }
      }
      console.log(oldPassword + " " + newPassword);
  }

}
