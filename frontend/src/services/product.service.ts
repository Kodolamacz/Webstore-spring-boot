import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product, Category } from '../models';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  private api: string = "/api";

  getAllProducts():Observable<Product[]>{
    return this.http.get<Product[]>(this.api+'/product/getAllProducts');
  }

  getProductsByCategory(category: Category):Observable<Product[]>{
    return this.http.get<Product[]>(this.api+'/product/getByCategory/'+category.id);

  }

  addCategory(product: Product): Observable<Product>{
    return this.http.post<Product>(this.api+'/product/addProduct',product);

  }
  deleteProduct(id: number){
    this.http.delete(this.api+'/product/deleteProduct/'+id);
  }


}


