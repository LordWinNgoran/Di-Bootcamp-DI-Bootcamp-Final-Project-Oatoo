import { Component, OnInit } from '@angular/core';
import {HttpErrorResponse} from "@angular/common/http";
import swal from 'sweetalert2';
import { Login } from '../../core/models/Login';
import { ApiLoginService } from '../../core/services/api/api-login.service';
import { Router } from '@angular/router';
import { TokenStorageService } from 'src/app/core/services/api/token-storage.service';
declare var particlesJS: any; 
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  login!: Login;

  authStatus!:boolean;
  isAuth=false;

  apiErrorThrown: boolean = false;
  errorResponseServer: any;
  constructor(private api: ApiLoginService,private route: Router, private tokenStorage: TokenStorageService){
    window.localStorage.clear();
    this.login = new Login(null!,null!);
  }
        ngOnInit() {
          // https://vincentgarreau.com/particles.js/
          particlesJS.load('particles-js', 'assets/data/particles.json', function() { console.log('callback - particles.js config loaded'); });
      }

      signin(loginForm: any) {
        console.log(loginForm);
        console.log(this.login);
        if (loginForm.valid) {
          this.api.create(this.login).subscribe({
            next: (response) => {

             
              this.tokenStorage.saveToken(response.accessToken.id);
              this.tokenStorage.saveUser(response);
              console.log(response.accessToken.id);
                swal.fire({
                  title:'succès',
                  text:'Vous étes connecté à Oatoo',
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
                loginForm.reset();
                this.route.navigate(['/user/oatoo'])
            },
            error: error => {
              swal.fire({
                title:'Erreur',
                text:'E-mail ou Mot de passe incorrect !',
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
