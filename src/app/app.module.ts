import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { InventoryPageComponent } from './inventory-page/inventory-page.component';
import { NavigationComponentComponent } from './navigation-component/navigation-component.component';
import { ShoesPageComponent } from './shoes-page/shoes-page.component';
import { ShowProfileComponent } from './show-profile/show-profile.component';
import { EditProfileComponent } from './edit-profile/edit-profile.component';
import { EditPasswordComponent } from './edit-password/edit-password.component';
import { SwapRequestSentComponent } from './swap-request-sent/swap-request-sent.component';
import { SwapRequestRecievedComponent } from './swap-request-recieved/swap-request-recieved.component';
import { AddShoeComponent } from './add-shoe/add-shoe.component';
import { RemoveShoesComponent } from './remove-shoes/remove-shoes.component';
import { AllUsersComponent } from './all-users/all-users.component';
import { HttpClientModule } from '@angular/common/http';
import { GoogleMapsComponent } from './google-maps/google-maps.component';
import { AgmCoreModule } from '@agm/core';
import { SignupPageComponent } from './signup-page/signup-page.component';


const routes: Routes = [
  { path: 'home', component: HomePageComponent},
  { path: 'inventoryPage', component: InventoryPageComponent},
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'shoesPage', component: ShoesPageComponent},
  { path: 'showProfile', component: ShowProfileComponent},
  { path: 'editProfile', component: EditProfileComponent},
  { path: 'editPassword', component: EditPasswordComponent},
  { path: 'requestsSent', component: SwapRequestSentComponent},
  { path: 'requestsRecieved', component: SwapRequestRecievedComponent},
  { path: 'addShoe', component: AddShoeComponent},
  { path: 'removeShoes', component: RemoveShoesComponent}, 
  { path: 'allUsers', component: AllUsersComponent},
  { path: 'locations', component: GoogleMapsComponent},
  { path: 'signup', component: SignupPageComponent}]

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    InventoryPageComponent,
    NavigationComponentComponent,
    ShoesPageComponent,
    ShowProfileComponent,
    EditProfileComponent,
    EditPasswordComponent,
    SwapRequestSentComponent,
    SwapRequestRecievedComponent,
    AddShoeComponent,
    RemoveShoesComponent,
    AllUsersComponent,
    GoogleMapsComponent,
    SignupPageComponent
  ],


  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyC_pN9RJdBarHW556WQ5V-xmNru-tFF8B8'
    })
  ],


  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
