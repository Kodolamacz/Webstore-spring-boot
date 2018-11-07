import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Category } from '../models';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http: HttpClient) { 
    
  }
  private api: string = '/api';


  getCategoryById(id:number): Observable<Category>{
    return this.http.get<Category>(this.api+'/category/getCategoryById/'+id);
  }

  getCategoryByName(name: string):Observable<Category>{
    return this.http.get<Category>(this.api+'/category/getCategoryByName/'+name);

  }

  addCategory(category: Category):Observable<Category>{
    return this.http.post<Category>(this.api+'/category/addCategory',category);
  }

}
