import { Component, OnInit } from '@angular/core';
import { Location } from '../locations';

@Component({
  selector: 'app-google-maps',
  templateUrl: './google-maps.component.html',
  styleUrls: ['./google-maps.component.css']
})
export class GoogleMapsComponent implements OnInit {

  allLocations: Location[];

  title: string = 'My first AGM project';
  lat: number = 38.837753;
  lng: number = -77.427265;
  lat1: number = 40.714932;
  lng1: number = -73.749324;

  constructor() { }

  ngOnInit() {
    console.log(this.lat +" " + this.lng);
    this.setLocations();
  }
  
  setLocations(): void{
    this.allLocations = [
      {latitude: 38.837753, longitude: -77.427265},{latitude: 39.308750, longitude: -76.641135},
      {latitude: 39.805181, longitude: -75.086290},{latitude: 40.714932, longitude: -73.749324},
      {latitude: 38.773980, longitude: -76.889968},{latitude: 37.550445, longitude: -77.342201},
      {latitude: 35.779795, longitude: -78.620395},{latitude: 40.647359, longitude: -73.956796},
      {latitude: 39.884549, longitude: -75.472406},{latitude: 30.324246, longitude: -81.671607},
      {latitude: 29.730621, longitude: -95.383995},{latitude: 29.366067, longitude: -98.495147},
      {latitude: 33.965555, longitude: -118.150925},{latitude: 34.150885, longitude: -118.378713},
      {latitude: 34.923141, longitude: -120.433822},{latitude: 35.370276, longitude: -119.011335},
      {latitude: 37.819741, longitude: -122.276458},{latitude: 37.973218, longitude: -122.021010},
      {latitude: 38.539324, longitude: -121.436468},{latitude: 45.436935, longitude: -122.567947},
      {latitude: 39.731528, longitude: -104.973527},{latitude: 39.082864, longitude: -94.597029},
      {latitude: 41.917326, longitude: -88.007146},{latitude: 39.085734, longitude: -77.160730}
    ] 
  }

}
