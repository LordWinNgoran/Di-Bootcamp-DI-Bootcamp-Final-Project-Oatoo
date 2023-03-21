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
  
  selectedFiles?: FileList;
  currentFile?: File;
  progress = 0;
  message = '';

  companies!: any;
  data_companies:any;

  apiErrorThrown: boolean = false;
  errorResponseServer: any;
  constructor(private api: ApiCompanyService){
     this.companies = new Company(null!,null!,null!,null!,null!,null!,null!,null!,null!,null!,null!,null!,"compagnie_logo"); 
  }



  selectFile(event: any): void {
    this.selectedFiles = event.target.files;
  }

  upload(): void {
    this.progress = 0;

   
  }



  addCompany(companyForm: any) {
    console.log(companyForm);
    console.log(this.companies);

    if (this.selectedFiles) {
      const file: File | null = this.selectedFiles.item(0);

      if (file) {
        this.currentFile = file;

       
      
    
    if (companyForm.valid) {
      const form_data = new FormData();

    for ( var key in this.companies ) {
    form_data.append(key, this.companies[key]);
    }
    form_data.append("compagnie_logo",this.currentFile)
    console.log(form_data.get)
      this.api.create(form_data).subscribe({
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

  this.selectedFiles = undefined;
}

  }

  

  
}
