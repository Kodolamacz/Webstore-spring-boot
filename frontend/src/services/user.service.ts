import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../models';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  private api: string = '/api';

  saveUser(user: User):Observable<User>{
    return this.http.post<User>(this.api+'/user/saveUser',user);
  }
}
