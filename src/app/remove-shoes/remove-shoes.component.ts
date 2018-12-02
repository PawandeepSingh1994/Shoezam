import { Component, OnInit } from '@angular/core';
import { Shoe } from '../shoe';
import { ShoeService } from '../shoe.service';

@Component({
  selector: 'app-remove-shoes',
  templateUrl: './remove-shoes.component.html',
  styleUrls: ['./remove-shoes.component.css']
})
export class RemoveShoesComponent implements OnInit {

  Shoes: Shoe[];

  constructor(private shoeService:ShoeService) { }

  getHeroes(): void{
    this.shoeService.getShoes().subscribe(Shoes => this.Shoes = Shoes);
    }
  
  ngOnInit() {
      this.getHeroes();
    }



}
