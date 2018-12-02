import { Component, OnInit } from '@angular/core'; 
import { User } from '../User';


@Component({
  selector: 'app-show-profile',
  templateUrl: './show-profile.component.html',
  styleUrls: ['./show-profile.component.css']
})
export class ShowProfileComponent implements OnInit {

  userInfo: User; 

  constructor() { 
    
  }

  ngOnInit() {
    this.setUserInfo();
  }

  setUserInfo(): void{
    this.userInfo = JSON.parse(localStorage.getItem("user"));
    console.log(this.userInfo);
  }

  

}
