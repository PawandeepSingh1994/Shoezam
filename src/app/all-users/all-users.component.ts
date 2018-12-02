import { Component, OnInit } from '@angular/core';
import { User } from '../User';
import { HttpClient } from '@angular/common/http'; 
import { UserService } from '../user.service';

@Component({
  selector: 'app-all-users',
  templateUrl: './all-users.component.html',
  styleUrls: ['./all-users.component.css']
})
export class AllUsersComponent implements OnInit {

  constructor(private httpClient: HttpClient, private userService: UserService) { }
  result: string;
  allUsers: User[];
  user: User;

  getAllUsers(): void {
    this.userService.getAllUsers().subscribe(allUsers => this.allUsers = allUsers.filter(user => user.isAdmin == false));
  }

  ngOnInit() {
    this.getAllUsers();
  }

  blockAccount(user: User){
    console.log(user);
    this.userService.blockAccount(user).subscribe(result => this.result = result);
    window.location.reload();
  }

  

}
