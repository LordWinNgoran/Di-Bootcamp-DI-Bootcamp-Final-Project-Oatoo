import { Component, OnInit } from '@angular/core';
import {HttpErrorResponse} from "@angular/common/http";
import swal from 'sweetalert2';
import { ApiRoleService } from '../../core/services/api/api-role.service';
import { Router } from '@angular/router';
import { Signup } from 'src/app/core/models/Signup';
import { ApiSignupService } from 'src/app/core/services/api/api-signup.service';
declare var particlesJS: any; 
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit{
  data_roles!:any;
  signup!: Signup;
  apiErrorThrown: boolean = false;
  errorResponseServer: any;
  constructor(private apirole: ApiRoleService, private apisignup: ApiSignupService,private route: Router){
    this.signup = new Signup(null!,null!,null!,null!,null!,4,null!)
  }
  ngOnInit() {
    particlesJS.load('particles-js', 'assets/data/particles1.json');
    /* this.apirole.findAll().subscribe((response : any) => {
      this.data_roles = response;
      console.log(this.data_roles);
    }); */
  }


  addUser(userForm: any) {
    console.log(userForm);
    console.log(this.signup);
    if (userForm.valid) {
      this.apisignup.create(this.signup).subscribe({
        next: (response) => {
            swal.fire({
              title:'succès',
              text:'Votre inscription a été enregistré avec succès',
              icon:'success',
              confirmButtonText:'OK',
              timer:9000,
              toast: true,
              position: 'top-end',
              showConfirmButton: false,
              timerProgressBar: true,
              didOpen: (toast) => {
                toast.addEventListener('mouseenter', swal.stopTimer)
                toast.addEventListener('mouseleave', swal.resumeTimer)
              }
            });
    
            userForm.reset();
          this.apiErrorThrown = false;
          this.route.navigate(['/login']);
          
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
