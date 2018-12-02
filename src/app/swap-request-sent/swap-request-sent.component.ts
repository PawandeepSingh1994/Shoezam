import { Component, OnInit } from '@angular/core';
import { Shoe } from '../shoe';
import { ShoeService } from '../shoe.service';
import { Request } from '../request';
import { SwapRequestServiceService } from '../swap-request-service.service';

@Component({
  selector: 'app-swap-request-sent',
  templateUrl: './swap-request-sent.component.html',
  styleUrls: ['./swap-request-sent.component.css']
})
export class SwapRequestSentComponent implements OnInit {

  item = JSON.parse(localStorage.getItem("user"));
  requests: Request[];

  constructor(private swapService:SwapRequestServiceService) { }


  getRequests(id: number): void{
    console.log(id);
    this.swapService.getRequestsByUser(id).subscribe(request => this.requests = request);
  }

  ngOnInit() {
    this.getRequests(this.item.id);
    //console.log(this.request);
  }

}
