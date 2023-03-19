import { Injectable } from '@angular/core';
import {ApiRequestService} from "./api-request.service";
import { Login } from '../../models/Login';
@Injectable({
  providedIn: 'root'
})
export class ApiLoginService {

  constructor(private apiRequestService: ApiRequestService) { }


  //methode de creation d'inscription en passant le modèle Program en paramètre
  create(login: Login) {
    return this.apiRequestService.post({endpoint: '/auth/signin', data: login});
  }



}