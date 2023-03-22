import { Component } from '@angular/core';
import {HttpErrorResponse} from "@angular/common/http";
import swal from 'sweetalert2';
import { Program } from '../../../../core/models/Program';
import { ApiProgramService } from '../../../../core/services/api/api-program.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-add-program',
  templateUrl: './add-program.component.html',
  styleUrls: ['./add-program.component.css']
})
export class AddProgramComponent {

  programs!: Program;
  data_programs:any;

 


  apiErrorThrown: boolean = false;
  errorResponseServer: any;
  constructor(private api: ApiProgramService, private route:Router){
    this.programs = new Program(null!,null!,null!,null!,null!,null!,"L",null!,null!,1);
  }

  addprogram(programForm: any) {
    console.log(programForm);
    console.log(this.programs);
    if (programForm.valid) {
      this.api.create(this.programs).subscribe({
        next: (response) => {
            swal.fire({
              title:'succès',
              text:'Programme enregistré avec succès',
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
            programForm.reset();
            this.route.navigate(['/user/program/list'])
          
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

