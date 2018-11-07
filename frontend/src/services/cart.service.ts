import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
import { Cart } from '../models';
@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private http: HttpClient) { 
    
  }
  private api: string = '/api';

  getCart(id: number): Observable<Cart>{
    return this.http.get<Cart>(this.api+'/cart/getCart/'+id)
  }
}
