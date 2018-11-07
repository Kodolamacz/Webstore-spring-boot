import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ShoppingHistory } from '../models';

@Injectable({
  providedIn: 'root'
})
export class ShoppinghistoryService {

  constructor(private http: HttpClient) { }

  private api: string = '/api';

  getShoppingHistory(userId: number):Observable<ShoppingHistory>{
    return this.http.get<ShoppingHistory>(this.api+'/shoppingHistory/getUserHistory/'+userId);
  }
}
