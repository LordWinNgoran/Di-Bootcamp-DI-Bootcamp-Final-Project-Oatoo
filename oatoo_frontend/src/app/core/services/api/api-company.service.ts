import { Injectable } from '@angular/core';
import {ApiRequestService} from "./api-request.service";
import { Company } from '../../models/Company';
@Injectable({
  providedIn: 'root'
})
export class ApiCompanyService {
  constructor(private apiRequestService: ApiRequestService) { }

  create(company: Company) {
    return this.apiRequestService.post({endpoint: '/companies', data: company});
  }

  update(company: Company) {
    return this.apiRequestService.put({endpoint: '/companies', data: company});
  }

  findAll() {
    return this.apiRequestService.get("/companies");
  }

  delete(id: string) {
    return this.apiRequestService.delete(`/companies/${id}`);
  }


}