import { Component, OnInit } from '@angular/core';
import {HttpErrorResponse} from "@angular/common/http";
import swal from 'sweetalert2';
import { Company } from '../../../../core/models/Company';
import { ApiCompanyService } from '../../../../core/services/api/api-company.service';
import { Router } from '@angular/router';
import { TokenStorageService } from 'src/app/core/services/api/token-storage.service';
@Component({
  selector: 'app-add-company',
  templateUrl: './add-company.component.html',
  styleUrls: ['./add-company.component.css']
})
export class AddCompanyComponent  implements OnInit{
  
  selectedFiles?: FileList;
  currentFile?: File;
  

  user:any
  companies!: any;
  
  apiErrorThrown: boolean = false;
  errorResponseServer: any;
  constructor(private api: ApiCompanyService, private token :TokenStorageService, private route :Router){
     this.companies = new Company(null!,null!,null!,null!,null!,null!,null!,null!,null!,null!); 
  }

  ngOnInit() {
    this.user = this.token.getUser()
 }


  selectFile(event: any): void {
    this.selectedFiles = event.target.files;
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
    form_data.append("user_fk",this.user.id)
    form_data.append("companie_logo",this.currentFile)
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
            this.route.navigate(['/user/company/update']);
          
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
