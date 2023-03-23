import { Injectable } from '@angular/core';
import {ApiRequestService} from "./api-request.service";
import { Signup } from '../../models/Signup';
@Injectable({
  providedIn: 'root'
})
export class ApiSignupService {

  constructor(private apiRequestService: ApiRequestService) { }

  create(signup: Signup) {
    return this.apiRequestService.post({endpoint: '/auth/signup', data: signup});
  }

}
