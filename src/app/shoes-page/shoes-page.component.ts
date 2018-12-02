import { Component, OnInit } from '@angular/core';
import { Shoe } from '../shoe';
import { ShoeService } from '../shoe.service';
import { Request } from '../request';
import { SwapRequestServiceService } from '../swap-request-service.service';
import {Router} from "@angular/router"


@Component({
  selector: 'app-shoes-page',
  templateUrl: './shoes-page.component.html',
  styleUrls: ['./shoes-page.component.css']
})
export class ShoesPageComponent implements OnInit {

  isUser: boolean;
  isManager: boolean;
  resultRequest: Request;
  request: Request = {
    shoe_req_id: 0,
    client_requester: null,
    client_owner: null,
    shoe_requested: null,
    shoe_to_trade: null,
    status: null,
    info: null
  }

  constructor(private shoeService: ShoeService, private RequestService: SwapRequestServiceService,
              private router: Router) { }

  Shoes: Shoe[];
  shoesForThisUser: Shoe[];
  shoe: Shoe;
  removeResult: Shoe;

  item = JSON.parse(localStorage.getItem("user"));
  
  getShoes(): void{
  this.shoeService.getShoes().subscribe(Shoes => this.Shoes = Shoes.filter(shoe => shoe.shoeStatus == 0 ||  shoe.shoeStatus == null));
  }

  getShoesForThisUser(id: number): void{
    this.shoeService.getAllShoesPerUser(id).subscribe(shoesForThisUser => this.shoesForThisUser = shoesForThisUser.filter(shoe => shoe.shoeStatus == 0 ||  shoe.shoeStatus == null));
  }

  //get shoes from everyone except the user logged in.so that he cant request himself
  getShoesForLoggedInUser(id: number): void{
    this.shoeService.getShoesForLoggedInUser(id).subscribe(Shoes => this.Shoes = Shoes.filter(shoe => shoe.shoeStatus == 0 ||  shoe.shoeStatus == null));
    }

    setRequestInfo(shoeToRequest: Shoe){
    this.request.client_requester = this.item;
    this.request.client_owner = shoeToRequest.client;
    this.request.shoe_requested = shoeToRequest;
    //console.log(this.request);
  }

  setShoeToTrade(shoeToTrade: Shoe, message: string){
    this.request.shoe_to_trade = shoeToTrade;
    this.request.info = message;
    console.log(this.request);
    this.RequestService.addNewRequest(this.request).subscribe(resultRequest => this.resultRequest = resultRequest);
    this.router.navigate(['/requestsSent']);
    window.location.reload();
  }

  ngOnInit() {
    this.setVals();
    if(this.item == null){
    this.getShoes();
    }
    else{
      this.getShoesForLoggedInUser(this.item.id);
      this.getShoesForThisUser(this.item.id);
    }
  }

  setVals(): void{
    if(localStorage.length==0){
      this.isUser = false;
      this.isManager = false;
    }
    else{
      let item = JSON.parse(localStorage.getItem("user"));
      if(item.isAdmin == true){
        this.isUser = false;
        this.isManager = true;
      }
      else{
        this.isUser = true;
        this.isManager = false;
      }
    }
  }

  searchForShoes(type: string, input: string, min: number, max: number){
    console.log(type + " " + input);
    if(type=="Brand"){
      this.shoeService.searchForShoesBrand(input).subscribe(Shoes => this.Shoes = Shoes.filter(shoe => shoe.shoeStatus == 0 ||  shoe.shoeStatus == null));
    }
    else if(type=="Color"){
      this.shoeService.searchForShoesColor(input).subscribe(Shoes => this.Shoes = Shoes.filter(shoe => shoe.shoeStatus == 0 ||  shoe.shoeStatus == null));
    }
    else if(type=="Size"){
      this.shoeService.searchForShoesSize(min, max).subscribe(Shoes => this.Shoes = Shoes.filter(shoe => shoe.shoeStatus == 0 ||  shoe.shoeStatus == null));
    }
    else if(type=="Price"){
      this.shoeService.searchForShoesPrice(min, max).subscribe(Shoes => this.Shoes = Shoes.filter(shoe => shoe.shoeStatus == 0 ||  shoe.shoeStatus == null));
    }
    else if(type=="All"){
      this.shoeService.getShoes().subscribe(Shoes => this.Shoes = Shoes.filter(shoe => shoe.shoeStatus == 0 ||  shoe.shoeStatus == null));
    }
    
  }

  removeListing(shoe: Shoe){
    this.shoeService.removeShoeListing(shoe.id).subscribe(removeResult => this.removeResult = removeResult);
    window.location.reload();
  }

}
