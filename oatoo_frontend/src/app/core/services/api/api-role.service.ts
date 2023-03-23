import { Injectable } from '@angular/core';
import {ApiRequestService} from "./api-request.service";
@Injectable({
  providedIn: 'root'
})
export class ApiRoleService {

  constructor(private apiRequestService: ApiRequestService) { }

  findAll() {
    return this.apiRequestService.get("/role");
  }



}