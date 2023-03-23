import { Component } from '@angular/core';
import { ApiTypeContractsService } from 'src/app/core/services/api/api-type-contracts.service';
import {HttpErrorResponse} from "@angular/common/http";
import { Type_contracts } from 'src/app/core/models/Type_contracts'; 
import swal from 'sweetalert2';
@Component({
  selector: 'app-type-contracts',
  templateUrl: './type-contracts.component.html',
  styleUrls: ['./type-contracts.component.css']
})
export class TypeContractsComponent {


  contracts!: Type_contracts;
  data_contracts : any;
  columns  : any ;
  p: number = 1;

  form: any = {
    desc_contract_type: null,
  };

  IsmodelClose=false;

  apiErrorThrown: boolean = false;
  errorResponseServer: any;




  constructor(private api: ApiTypeContractsService,){
    this.contracts = new Type_contracts(null!,null!,null!);
  }

 
  ngOnInit(){
    this.getAlltypecontacts()
  }


  getAlltypecontacts() {
    this.api.findAll().subscribe((response : any) => {
      this.data_contracts = response.data ;
      console.log(this.data_contracts);
    });
  }

  addTypeContract(contractForm: any) {
    console.log(contractForm);
    console.log(this.contracts);
    if (contractForm.valid) {
      this.api.create(this.contracts).subscribe({
        next: (response) => {
            swal.fire({
              title:'succès',
              text:'Type de contrat enregistré avec succès',
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
    
            contractForm.reset();
          this.apiErrorThrown = false;
          this.IsmodelClose=true;
          this.getAlltypecontacts();
          
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

