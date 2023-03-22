import { Injectable } from '@angular/core';
import { Company } from '../../models/Company';
import { ApiRequestService } from './api-request.service';
@Injectable({
  providedIn: 'root'
})
export class ApiCompanyService {
  constructor(private apiRequestService: ApiRequestService) { }

  create(company: any) {
    this.apiRequestService.setApiType("multipart");
    return this.apiRequestService.post({endpoint: '/companies', data: company});
  }

  update(company: Company) {
    return this.apiRequestService.put({endpoint: '/companies', data: company});
  }

  findAll() {
    return this.apiRequestService.get("/companies");
  }
  findAllbyUser(id: number) {
    return this.apiRequestService.get(`/companies/user/${id}`);
  }

  UpdateAccount(id: number) {
    return this.apiRequestService.putChange(`/companies/activeAccount/${id}`);
  }

  findByCompanyId(id: number) {
    return this.apiRequestService.get(`/companies/${id}`);
  }

  delete(id: string) {
    return this.apiRequestService.delete(`/companies/${id}`);
  }


}




/* 
private baseUrl = 'http://localhost:8080/api/v1/companies';

  constructor(private http: HttpClient) { }

  upload(file: File): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();

    formData.append('companie_logo', file);
    formData.append('register_number', "YTREERF");
    formData.append('companie_name', "YTREERF");
    formData.append('companie_email', "YTREERF");
    formData.append('companie_field', "YTREERF");
    formData.append('companie_regime', "YTREERF");
    formData.append('companie_location', "YTREERF");
    formData.append('companie_size', "12");
    formData.append('annual_revenue', "12");
    formData.append('web_site', "dgddgdd");
    formData.append('acccount_state', "UT");
    formData.append('companie_phone', "UT");

    const req = new HttpRequest('POST', `${this.baseUrl}`, formData, {
      reportProgress: true,
      responseType: 'json'
    });

    return this.http.request(req);
  }

  getFiles(): Observable<any> {
    return this.http.get(`${this.baseUrl}/files`);
  } */
