import { Component } from '@angular/core';
import {HttpErrorResponse} from "@angular/common/http";
import swal from 'sweetalert2';
import { Company } from '../../../../core/models/Company';
import { ApiCompanyService } from '../../../../core/services/api/api-company.service';
@Component({
  selector: 'app-add-company',
  templateUrl: './add-company.component.html',
  styleUrls: ['./add-company.component.css']
})
export class AddCompanyComponent {

  companies!: Company;
  data_companies:any;

  apiErrorThrown: boolean = false;
  errorResponseServer: any;
  constructor(private api: ApiCompanyService){
    this.companies = new Company(null!,null!,null!,null!,null!,null!,null!,null!,null!,null!,null!,null!,null!,"Vérification");
  }

  addCompany(companyForm: any) {
    console.log(companyForm);
    console.log(this.companies);
    if (companyForm.valid) {
      this.api.create(this.companies).subscribe({
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
            companyForm.reset();
    
          
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
