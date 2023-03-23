import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ApiCompanyUploadService {
  private baseUrl = 'http://localhost:8080/api/v1/companies';

  constructor(private http: HttpClient) { }

  upload(file: File, register_number: any, companie_name: any, 
    companie_email: any, companie_field: any, companie_regime: any,
    companie_location:any,companie_size:any,annual_revenue:any,
    web_site:any,acccount_state:any,companie_phone:any): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();

    formData.append('companie_logo', file);
    formData.append('register_number', register_number);
    formData.append('companie_name', companie_name);
    formData.append('companie_email', companie_email);
    formData.append('companie_field', companie_field);
    formData.append('companie_regime', companie_regime);
    formData.append('companie_location', companie_location);
    formData.append('companie_size', companie_size);
    formData.append('annual_revenue', annual_revenue);
    formData.append('web_site', web_site);
    formData.append('acccount_state', acccount_state);
    formData.append('companie_phone', companie_phone);

    const req = new HttpRequest('POST', `${this.baseUrl}`, formData, {
      reportProgress: true,
      responseType: 'json'
    });

    return this.http.request(req);
  }


}