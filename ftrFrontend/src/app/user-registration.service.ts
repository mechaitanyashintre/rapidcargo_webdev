import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserRegistationService {
  constructor(private http: HttpClient) {}

  public doRegistration(user: User) {
    return this.http.post("http://localhost:9001/dept/d", user, { responseType: 'text' as 'json' });
  }

  public get(uid: number) {
    console.log(uid);
    return this.http.get("http://localhost:3000/userprofile/" + uid);
  }

  public updateUsers(id: number) {
    return this.http.post("http://localhost:9090/id", { responseType: 'text' as 'json' });
  }

  public deleteUsers(uid: number) {
    console.log(uid);
    return this.http.delete("http://localhost:9090/" + uid);
  }
}
