import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private baseUrl : String = "http://localhost:8080";
  constructor(private http: HttpClient) { }

  doPost(url, data): Observable<Object> {
    let actualUri: string = this.baseUrl.concat(url);
    return this.http.post<Object> (actualUri, data);
  }

  login(username, password):  Observable<Object> {
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password)});
    let actualUri: string = this.baseUrl.concat("/logging");
    return this.http.get<Object> (actualUri, {headers});
  }

  doPostInventory(url, data): Observable<Object>{
    let actualUri: string =this.baseUrl.concat(url)
    return this.http.post<Object> (actualUri,data)

  }


}


