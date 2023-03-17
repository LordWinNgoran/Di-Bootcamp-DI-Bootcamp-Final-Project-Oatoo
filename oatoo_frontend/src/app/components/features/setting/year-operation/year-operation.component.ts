import { Component, OnInit } from '@angular/core';
import { ApiYearService } from 'src/app/core/services/api/api-year.service';
import {HttpErrorResponse} from "@angular/common/http";
import { Year } from '../../../../core/models/Year';
import swal from 'sweetalert2';
@Component({
  selector: 'app-year-operation',
  templateUrl: './year-operation.component.html',
  styleUrls: ['./year-operation.component.css']
})
export class YearOperationComponent implements OnInit{


  years!: Year;
  data_years:any;
  columns  : any ;
  p: number = 1;

  form: any = {
    year: null,
  };

  IsmodelClose=false;

  apiErrorThrown: boolean = false;
  errorResponseServer: any;
  constructor(private api: ApiYearService){
    this.years = new Year(null!,null!,null!);
  }

 
  ngOnInit(){
    this.getAllyears()
  }


  getAllyears() {
    this.api.findAll().subscribe((response : any) => {
      this.data_years = response.data ;
      console.log(this.data_years);
    });
  }


  deleteYearById(id:any) {
    this.api.delete(id).subscribe((response : any) => {
      
      swal.fire({
        title:'succès',
        text:'Année supprimé avec succès',
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
    });
  }


  addYear(yearForm: any) {
    console.log(yearForm);
    console.log(this.years);
    if (yearForm.valid) {
      this.api.create(this.years).subscribe({
        next: (response) => {
            swal.fire({
              title:'succès',
              text:'Année enregistrée avec succès',
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
    
          yearForm.reset();
          this.apiErrorThrown = false;
          this.IsmodelClose=true;
          this.getAllyears();
          
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
