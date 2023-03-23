import { Injectable } from '@angular/core';
import {ApiRequestService} from "./api-request.service";
import { Unemployees } from '../../models/Unemployees';
@Injectable({
  providedIn: 'root'
})
export class ApiUnemployeeService {

  constructor(private apiRequestService: ApiRequestService) { }

  create(unemployees: Unemployees) {
    return this.apiRequestService.post({endpoint: '/unemployees', data: unemployees});
  }

  update(unemployees: Unemployees) {
    return this.apiRequestService.put({endpoint: '/unemployees', data: unemployees})
  }

  findAll() {
    return this.apiRequestService.get("/unemployees");
  }

  delete(id: string) {
    return this.apiRequestService.delete(`/unemployees/${id}`);
  }


}
