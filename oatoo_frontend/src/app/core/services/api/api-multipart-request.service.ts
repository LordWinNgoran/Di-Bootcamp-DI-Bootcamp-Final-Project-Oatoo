import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import { environment } from 'src/app/environment/environment';
@Injectable({
  providedIn: 'root'
})
export class ApiMultipartRequestService {
  constructor(private http: HttpClient) { }
  get(endpoint: string) {
    return this.http.get(`${environment.BASE_URL_API}${endpoint}`, {headers: this.httpHeader()});
  }

  post(parameter: Required<{ endpoint: string, data: any }>) {
    return this.http.post(`${environment.BASE_URL_API}${parameter.endpoint}`, parameter.data, {
      reportProgress: true,
      responseType: 'json'
    });
  }

  put(parameter: Required<{ endpoint: string, data: any }>) {
    return this.http.put(`${environment.BASE_URL_API}${parameter.endpoint}`, parameter.data, {headers: this.httpHeader()});
  }

  delete(endpoint: string) {
    return this.http.delete(`${environment.BASE_URL_API}${endpoint}`, {headers: this.httpHeader()});
  }

  httpHeader() {
    return new HttpHeaders({
      'Content-Type': 'multipart/form-data',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'POST, GET, OPTIONS, PUT, DELETE',
    });
  }
}