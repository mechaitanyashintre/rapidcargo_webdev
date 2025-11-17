import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TerminalService {
  constructor(private http: HttpClient) {}
  API = 'http://localhost:9090';

  public registerTerminal(term: any) {
    return this.http.post(this.API + '/registerTerminal', term);
  }

  public getTerminal() {
    return this.http.get(this.API + '/getTerminals');
  }

  public deleteTerminal(id: any) {
    return this.http.delete(this.API + '/deleteTerminal?id=' + id);
  }

  public updateTerminal(terminal: any) {
    return this.http.put(this.API + '/updateTerminals', terminal);
  }
}
