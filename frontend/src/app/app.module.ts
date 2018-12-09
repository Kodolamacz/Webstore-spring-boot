import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule }   from '@angular/forms';
import { AppComponent } from './app.component';
import { ProductsComponent } from './products/products.component';
import { HttpClientModule } from '@angular/common/http';
import { AddCategoryComponent } from './add-category/add-category.component';
import { AppRoutingModule } from './/app-routing.module';
import { RouterModule, Routes, Router } from '@angular/router';
import { WelcomePageComponent } from './welcome-page/welcome-page.component';
import { AllProductsComponent } from './all-products/all-products.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import { LoginComponent } from './login/login.component';


@NgModule({
  declarations: [
    AppComponent,
    ProductsComponent,
    AddCategoryComponent,
    WelcomePageComponent,
    AllProductsComponent,
    UserRegistrationComponent,
    LoginComponent
  ],
  imports: [

    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
