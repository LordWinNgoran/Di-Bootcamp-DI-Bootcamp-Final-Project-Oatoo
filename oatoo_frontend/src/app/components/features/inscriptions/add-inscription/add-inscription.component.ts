import { Component } from '@angular/core';
import {HttpErrorResponse} from "@angular/common/http";
import swal from 'sweetalert2';
import { ApiInscriptionService } from '../../../../core/services/api/api-inscription.service';
import { Inscription } from '../../../../core/models/Inscription';
@Component({
  selector: 'app-add-inscription',
  templateUrl: './add-inscription.component.html',
  styleUrls: ['./add-inscription.component.css']
})
export class AddInscriptionComponent {

  inscriptions!: Inscription;
  data_inscription:any;

  apiErrorThrown: boolean = false;
  errorResponseServer: any;
  constructor(private api: ApiInscriptionService){
    this.inscriptions = new Inscription(1,1,null!,"Analyse",null!,false);
  }

  addInscription(inscriptionForm: any) {
    console.log(inscriptionForm);
    console.log(this.inscriptions);
    if (inscriptionForm.valid) {
      this.api.create(this.inscriptions).subscribe({
        next: (response) => {
            swal.fire({
              title:'succès',
              text:'Votre demande a été enregistré avec succès mais une vérification sera effectuée dans le plus bref delai',
              icon:'success',
              confirmButtonText:'OK',
              timer:8000,
              toast: true,
              position: 'top-end',
              showConfirmButton: false,
              timerProgressBar: true,
              didOpen: (toast) => {
                toast.addEventListener('mouseenter', swal.stopTimer)
                toast.addEventListener('mouseleave', swal.resumeTimer)
              }
            });
            inscriptionForm.reset();
    
        },
        error: error => {
          swal.fire({
            title:'Erreur',
            text:'Erreur lors de la sauvegarde des informations !',
            icon:'error',
            confirmButtonText:'OK',
            timer:4000,
            toast: true,
            position: 'top-end',
            showConfirmButton: false,
            timerProgressBar: true,
            didOpen: (toast) => {
              toast.addEventListener('mouseenter', swal.stopTimer)
              toast.addEventListener('mouseleave', swal.resumeTimer)
            }
          });
        

        }
      })
    }

  }



  
}
