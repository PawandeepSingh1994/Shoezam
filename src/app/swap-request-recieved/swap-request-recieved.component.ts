import { Component, OnInit } from '@angular/core';
import { Shoe } from '../shoe';
import { ShoeService } from '../shoe.service';
import { Request } from '../request';
import { SwapRequestServiceService } from '../swap-request-service.service';
 
@Component({
  selector: 'app-swap-request-recieved',
  templateUrl: './swap-request-recieved.component.html',
  styleUrls: ['./swap-request-recieved.component.css']
})
export class SwapRequestRecievedComponent implements OnInit {

  item = JSON.parse(localStorage.getItem("user"));
  requests: Request[];
  result: string;

  constructor(private swapService:SwapRequestServiceService) { }

  getRequests(id: number): void{
    console.log(id);
    this.swapService.getRequestsToUser(id).subscribe(request => this.requests = request);
  }

  ngOnInit() {
    this.getRequests(this.item.id);
    //console.log(this.request);
  }

  denyRequest(request: Request): void{
    this.swapService.denyRequest(request).subscribe(result => this.result = result);
    window.location.reload();
  }

  approveRequest(request: Request): void{
    this.swapService.approveRequest(request).subscribe(result => this.result = result);
    window.location.reload();
  }

}
