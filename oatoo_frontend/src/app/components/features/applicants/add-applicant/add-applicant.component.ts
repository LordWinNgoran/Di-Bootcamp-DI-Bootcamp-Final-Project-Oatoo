import { Component } from '@angular/core';
import {HttpErrorResponse} from "@angular/common/http";
import swal from 'sweetalert2';
import { ApiUnemployeeService } from '../../../../core/services/api/api-unemployee.service';
import { Unemployees } from '../../../../core/models/Unemployees';
@Component({
  selector: 'app-add-applicant',
  templateUrl: './add-applicant.component.html',
  styleUrls: ['./add-applicant.component.css']
})
export class AddApplicantComponent {

  unemployees!: Unemployees;
  data_companies:any;

  apiErrorThrown: boolean = false;
  errorResponseServer: any;
  constructor(private api: ApiUnemployeeService){
    this.unemployees = new Unemployees(null!,null!,null!,null!,null!,null!,null!,null!,null!,null!,null!,null!,null!,null!,null!,null!);
  }

  addUnemployees(unemplyeesForm: any) {
    console.log(unemplyeesForm);
    console.log(this.unemployees);
    if (unemplyeesForm.valid) {
      this.api.create(this.unemployees).subscribe({
        next: (response) => {
            swal.fire({
              title:'succès',
              text:'Entreprise enregistré avec succès en attente de vérification',
              icon:'success',
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
            unemplyeesForm.reset();
    
          
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
