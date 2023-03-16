import { Injectable } from '@angular/core';
import { Year } from '../../models/Year';
import {ApiRequestService} from "./api-request.service";
@Injectable({
  providedIn: 'root'
})
export class ApiYearService {

  constructor(private apiRequestService: ApiRequestService) { }

  create(year: Year) {
    return this.apiRequestService.post({endpoint: '/year', data: year});
  }

  update(year: Year) {
    return this.apiRequestService.put({endpoint: '/year', data: year});
  }

  findAll() {
    return this.apiRequestService.get("/year");
  }

  delete(id: string) {
    return this.apiRequestService.delete(`/year/${id}`);
  }


}
