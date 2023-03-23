import { Injectable } from '@angular/core';
import {ApiRequestService} from "./api-request.service";
import { Program } from '../../models/Program';
@Injectable({
  providedIn: 'root'
})
export class ApiProgramService {

  constructor(private apiRequestService: ApiRequestService) { }

  create(company: any) {
    this.apiRequestService.setApiType("multipart");
    return this.apiRequestService.post({endpoint: '/programs', data: company});
  }
  
  update(program: Program) {
    return this.apiRequestService.put({endpoint: '/programs', data: program});
  }

  findAll() {
    return this.apiRequestService.get("/programs");
  }

  delete(id: string) {
    return this.apiRequestService.delete(`/programs/${id}`);
  }


}