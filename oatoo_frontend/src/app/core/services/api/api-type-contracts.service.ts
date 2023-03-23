import { Injectable } from '@angular/core';
import { Type_contracts } from '../../models/Type_contracts';
import {ApiRequestService} from "./api-request.service";
@Injectable({
  providedIn: 'root'
})
export class ApiTypeContractsService {

  constructor(private apiRequestService: ApiRequestService) { }

  create(typecontracts: Type_contracts) {
    return this.apiRequestService.post({endpoint: '/contract_types', data: typecontracts});
  }

  update(typecontracts: Type_contracts) {
    return this.apiRequestService.put({endpoint: '/contract_types', data: typecontracts});
  }

  findAll() {
    return this.apiRequestService.get("/contract_types");
  }

  delete(id: string) {
    return this.apiRequestService.delete(`/contract_types/${id}`);
  }


}