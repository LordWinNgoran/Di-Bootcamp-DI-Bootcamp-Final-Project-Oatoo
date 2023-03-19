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
  data_roles!:any[];
  constructor(private apirole: ApiRoleService, private apisignup: ApiSignupService,private route: Router){}
  ngOnInit() {
    this.apirole.findAll().subscribe((response : any) => {
      this.data_roles = response;
      console.log(this.data_roles);
    });
    particlesJS.load('particles-js', 'assets/data/particles1.json');
   
}


}
