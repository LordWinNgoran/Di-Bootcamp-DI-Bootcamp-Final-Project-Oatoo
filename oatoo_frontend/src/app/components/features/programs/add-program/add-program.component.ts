import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from "@angular/common/http";
import swal from 'sweetalert2';
import { Program } from '../../../../core/models/Program';
import { ApiProgramService } from '../../../../core/services/api/api-program.service';
import { Router } from '@angular/router';
import { ApiCompanyService } from 'src/app/core/services/api/api-company.service';
@Component({
  selector: 'app-add-program',
  templateUrl: './add-program.component.html',
  styleUrls: ['./add-program.component.css']
})
export class AddProgramComponent implements OnInit {


  programs!: any;
  data_companies: any;


  selectedFiles?: FileList;
  currentFile?: File;

  apiErrorThrown: boolean = false;
  errorResponseServer: any;
  constructor(private api: ApiProgramService, private route: Router, private apiSecond: ApiCompanyService) {
    this.programs = new Program(null!, null!, null!, null!, null!, "L", null!);
  }

  ngOnInit() {
    this.apiSecond.findAllCompanyActive().subscribe({
      next: (response) => {
        this.data_companies = response
        console.log(this.data_companies)
      },

    })
  }


  selectFile(event: any): void {
    this.selectedFiles = event.target.files;
  }





  addprogram(programForm: any) {
    console.log(programForm);
    console.log(this.programs);

    if (this.selectedFiles) {
      const file: File | null = this.selectedFiles.item(0);

      if (file) {
        this.currentFile = file;

        if (programForm.valid) {
          const form_data = new FormData();

          for (var key in this.programs) {
            form_data.append(key, this.programs[key]);
          }
          form_data.append("photo_program", this.currentFile)
          this.api.create(form_data).subscribe({
            next: (response) => {
              swal.fire({
                title: 'succès',
                text: 'Programme enregistré avec succès',
                icon: 'success',
                confirmButtonText: 'OK',
                timer: 4000,
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
              this.route.navigate(['/user/program/list']);

            },
            error: error => {
              swal.fire({
                title: 'Erreur',
                text: 'Erreur lors de la sauvegarde des informations !',
                icon: 'error',
                confirmButtonText: 'OK',
                timer: 4000,
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

