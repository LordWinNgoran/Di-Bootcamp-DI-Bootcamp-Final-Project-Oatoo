import { Injectable } from '@angular/core';
import { Type_card } from '../../models/Type_card';
import {ApiRequestService} from "./api-request.service";

@Injectable({
  providedIn: 'root'
})
export class ApiTypeCardService {

  constructor(private apiRequestService: ApiRequestService) { }

  create(type_card: Type_card) {
    return this.apiRequestService.post({endpoint: '/card_types', data: type_card});
  }

  update(type_card: Type_card) {
    return this.apiRequestService.put({endpoint: '/card_types', data: type_card});
  }

  findAll() {
    return this.apiRequestService.get("/card_types");
  }

  delete(id: string) {
    return this.apiRequestService.delete(`/card_types/${id}`);
  }


}