import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { ProductsComponent } from './products/products.component';
import { AddCategoryComponent } from './add-category/add-category.component';
import { AllProductsComponent } from './all-products/all-products.component';
import { WelcomePageComponent } from './welcome-page/welcome-page.component';

const routes = [
  {path: 'addProduct', component: ProductsComponent},
  {path: 'home', component: WelcomePageComponent},
  {path: 'addCategory', component: AddCategoryComponent},
  {path: 'allProducts', component: AllProductsComponent},
  {path:'**', component: WelcomePageComponent}
];
@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports:[
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
