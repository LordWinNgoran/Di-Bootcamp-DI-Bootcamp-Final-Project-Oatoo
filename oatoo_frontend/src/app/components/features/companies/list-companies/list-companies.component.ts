import { Component, OnInit } from '@angular/core';
import { ApiCompanyService } from 'src/app/core/services/api/api-company.service';
import { HttpErrorResponse } from "@angular/common/http";
import swal from 'sweetalert2';
import { Company } from '../../../../core/models/Company';
@Component({
  selector: 'app-list-companies',
  templateUrl: './list-companies.component.html',
  styleUrls: ['./list-companies.component.css']
})
export class ListCompaniesComponent implements OnInit {

  data_companies: any;
  dtOptions: any = {};


  IsmodelClose = false;

  apiErrorThrown: boolean = false;
  errorResponseServer: any;


  constructor(private api: ApiCompanyService) { }


  ngOnInit() {
    this.api.findAll().subscribe((response: any) => {
      this.data_companies = response.data;
      setTimeout(() => {
        $('#datatableexample').DataTable({
          pagingType: 'full_numbers',
          pageLength: 5,
          processing: true,
          lengthMenu: [5, 10, 25],
          order: [[1, "desc"]]
        });
      }, 1);
    });


  }


}

