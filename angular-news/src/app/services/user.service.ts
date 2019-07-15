import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { User } from '../model/user.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class UserService {
  
  constructor(private http: HttpClient) { }

  public getUsers(){
    return this.http.get<User[]>("http://localhost:8080/v1/login/getInformation")
  }
}
