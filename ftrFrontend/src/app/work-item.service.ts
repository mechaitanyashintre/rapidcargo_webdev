import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class WorkItemService {
  constructor(private http: HttpClient) {}
  API = 'http://localhost:9090';

  public registerWorkItem(workItem: any) {
    return this.http.post(this.API + '/registerWorkItem', workItem);
  }

  public getWorkItem() {
    return this.http.get(this.API + '/getWorkItems');
  }

  public deleteWorkItem(id: any) {
    return this.http.delete(this.API + '/deleteWorkItem?id=' + id);
  }

  public updateWorkItem(workItem: any) {
    return this.http.put(this.API + '/updateWorkItems', workItem);
  }
}
