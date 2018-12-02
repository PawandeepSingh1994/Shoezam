import { Component, OnInit } from '@angular/core';
import { User } from '../User';
import { UserService } from '../user.service';
import { Shoe } from '../shoe'; 
import { ShoeService } from '../shoe.service';
import { isNgTemplate } from '@angular/compiler';
import { map, tap, filter } from 'rxjs/operators';
import { Observable, from, of } from 'rxjs';

@Component({
  selector: 'app-inventory-page',
  templateUrl: './inventory-page.component.html',
  styleUrls: ['./inventory-page.component.css']
})
export class InventoryPageComponent implements OnInit {

  Shoes: Shoe[] = [];
  ShoesForThisUser: Shoe[];
  item = JSON.parse(localStorage.getItem("user"));
  userId: number;
  result: Shoe;

  constructor(private shoeService: ShoeService) { }

  ngOnInit() {
    this.userId = this.item.id;
    this.getShoes(this.userId);
    //this.filterShoes();
    
  }

  getShoes(id: number): void{
    this.shoeService.getAllShoesPerUser(id).subscribe(Shoes => this.Shoes = Shoes.filter(shoe => shoe.shoeStatus == 0 ||  shoe.shoeStatus == null));
  }

  getFilteredShoes(id: number): void{
   // return this.getShoes(id).map(Shoes => Shoes.filter(shoe => shoe.shoeStatus == 0))
  }

  removeListing(id: number): void{
    console.log(id);
    this.shoeService.removeShoeListing(id).subscribe(result => this.result = result);
    window.location.reload();
  }
  
  }



