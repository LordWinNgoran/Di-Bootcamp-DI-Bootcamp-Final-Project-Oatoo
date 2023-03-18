import { Injectable } from '@angular/core';
import {ApiRequestService} from "./api-request.service";
import { Inscription } from '../../models/Inscription';
@Injectable({
  providedIn: 'root'
})

/**
 * @Author: N'GORAN Kouadio Jean Cyrille
 * @Date: 16/03/2023
 * @Description: API consommation des ressources d'inscription
 * @params: Modèle ApiRequestService
 */

export class ApiInscriptionService {

  constructor(private apiRequestService: ApiRequestService) { }


  //methode de creation d'inscription en passant le modèle Program en paramètre
  create(inscription: Inscription) {
    return this.apiRequestService.post({endpoint: '/inscriptions', data: inscription});
  }

  //methode de modification d'inscription en passant le modèle Program en paramètre
  update(inscription: Inscription) {
    return this.apiRequestService.put({endpoint: '/inscriptions', data: inscription});
  }

  //methode de recuperation de toutes les inscriptions

  findAll() {
    return this.apiRequestService.get("/inscriptions");
  }


  //methode de suppression d'inscription en passant l'id en parametre
  delete(id: string) {
    return this.apiRequestService.delete(`/inscriptions/${id}`);
  }


}