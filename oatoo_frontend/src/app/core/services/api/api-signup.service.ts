import { Injectable } from '@angular/core';
import {ApiRequestService} from "./api-request.service";
import { Signup } from '../../models/Signup';
@Injectable({
  providedIn: 'root'
})
export class ApiSignupService {

  constructor(private apiRequestService: ApiRequestService) { }

 /*  create(program: Program) {
    return this.apiRequestService.post({endpoint: '/programs', data: program});
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
 */

}
