import { Component, OnInit } from '@angular/core';
import { ApiCompanyService } from 'src/app/core/services/api/api-company.service';
import {HttpErrorResponse} from "@angular/common/http";
import swal from 'sweetalert2';
import { Company } from '../../../../core/models/Company';
@Component({
  selector: 'app-list-companies',
  templateUrl: './list-companies.component.html',
  styleUrls: ['./list-companies.component.css']
})
export class ListCompaniesComponent implements OnInit{

  data_companies:any;
  columns  : any ;
  p: number = 1;


  IsmodelClose=false;

  apiErrorThrown: boolean = false;
  errorResponseServer: any;
  constructor(private api: ApiCompanyService){}

 
  ngOnInit(){
    this.getAllyears()
  }


  getAllyears() {
    this.api.findAll().subscribe((response : any) => {
      this.data_companies = response.data ;
      console.log(this.data_companies);
    });
  }




  
}

