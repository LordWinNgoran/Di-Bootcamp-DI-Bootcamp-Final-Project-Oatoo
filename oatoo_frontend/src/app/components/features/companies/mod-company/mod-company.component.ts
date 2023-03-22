import { Component, OnInit } from '@angular/core';
import { ApiCompanyService } from 'src/app/core/services/api/api-company.service';
import { HttpErrorResponse } from "@angular/common/http";
import swal from 'sweetalert2';
import { Company } from '../../../../core/models/Company';
import { TokenStorageService } from 'src/app/core/services/api/token-storage.service';
@Component({
  selector: 'app-mod-company',
  templateUrl: './mod-company.component.html',
  styleUrls: ['./mod-company.component.css']
})
export class ModCompanyComponent implements OnInit {

  data_companies: any;
  dtOptions: any = {};


  IsmodelClose = false;

  apiErrorThrown: boolean = false;
  errorResponseServer: any;
  user:any

  constructor(private api: ApiCompanyService,private token: TokenStorageService) { }


  ngOnInit() {
    this.user = this.token.getUser()
    this.api.findAllbyUser(this.user.id).subscribe((response: any) => {
      this.data_companies = response.data;
      console.log(this.data_companies)
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


