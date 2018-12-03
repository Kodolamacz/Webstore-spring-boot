import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product, Category, ProductDTO } from '../models';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  private api: string = "/api";

  getAllProducts():Observable<ProductDTO[]>{
    return this.http.get<ProductDTO[]>(this.api+'/product/getAllProducts');
  }

  getProductsByCategory(category: Category):Observable<Product[]>{
    return this.http.get<Product[]>(this.api+'/product/getByCategory/'+category.id);

  }

  addProduct(product: Product, files:File[], category: Category){
    const formData: FormData = new FormData();
    for(let file of files){
      console.log(file);

    formData.append('image', file, file.name);
    }
    formData.append('product', new Blob([JSON.stringify(product)], {type: "application/json"})) ;
    formData.append('category', new Blob([JSON.stringify(category)], {type: "application/json"})) ;
    console.log("FORM "+ formData);


    return this.http.post(this.api+'/product/addProduct',formData );

  }
  deleteProduct(id: number){
    this.http.delete(this.api+'/product/deleteProduct/'+id);
  }


}


