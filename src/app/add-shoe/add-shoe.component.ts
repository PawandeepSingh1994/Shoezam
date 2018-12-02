import { Component, OnInit } from '@angular/core';
import { Shoe } from '../shoe';
import { ShoeService } from '../shoe.service';
import {Router} from "@angular/router";
import { User } from '../User';
import { S3serviceService } from '../s3service.service'; 


@Component({
  selector: 'app-add-shoe',
  templateUrl: './add-shoe.component.html',
  styleUrls: ['./add-shoe.component.css']
})
export class AddShoeComponent implements OnInit {

  selectedFile: File = null;
  shoeToAdd: Shoe = null;
  result: Shoe;
  credentials: User;
  shoeReturned: Shoe;
  fd: FormData = new FormData;
  s3Response: Response;

  constructor(private shoeService: ShoeService, private router: Router, private s3Service: S3serviceService) { }

  ngOnInit() {
  }

  onFileSelected(event){
    console.log(event);
    this.selectedFile = <File>event.target.files[0];
  }

  addShoe(name: string, brand: string, color: string, size: number, price: number): void{

    let user = JSON.parse(localStorage.getItem("user"));
    this.shoeToAdd = new Shoe();

    this.shoeToAdd.id = 0;
    this.shoeToAdd.client = user;
    this.shoeToAdd.title = name;
    this.shoeToAdd.brand = brand;
    this.shoeToAdd.color = color;
    this.shoeToAdd.shoeSize = size;
    this.shoeToAdd.price = price;
    this.shoeToAdd.shoeStatus = 0;
    this.shoeToAdd.uploadedFile = null;
    this.shoeToAdd.imageUrl = null;


    this.shoeService.addShoe(this.shoeToAdd).subscribe(shoeReturned => {
      console.log(shoeReturned);
      this.shoeReturned = shoeReturned;
      this.assignData(this.shoeReturned);
      this.uploadImage();
      });

    //console.log(this.shoeReturned);
    
    // Send to s
    //console.log(this.shoeToAdd);

    
    
    //console.log(this.selectedFile);

    //this.shoeService.addShoe(this.shoeToAdd).subscribe(result => this.result = result);
    //console.log(this.shoeToAdd);
    this.router.navigate(['/inventoryPage']);
    window.location.reload();
  }

  assignData(shoe: Shoe){
    this.fd.append('key', `shoe-id-${shoe.id}`);
    this.fd.append('acl', 'bucket-owner-full-control');
    this.fd.append('Content-Type', this.selectedFile.type);
    this.fd.append('file', this.selectedFile);
    }

  uploadImage(){
    this.s3Service.getCredentials().subscribe(credentials => {
      const s3Url = credentials.email;
      const bucketName = credentials.pass;
      const accessKey = credentials.firstName;
      const secretKey = credentials.lastName;
      this.s3Service.uploadImage(s3Url, this.fd).subscribe(s3Response => {
        console.log(s3Response);
        this.s3Response = s3Response
      });
      this.credentials = credentials});
  }

}
