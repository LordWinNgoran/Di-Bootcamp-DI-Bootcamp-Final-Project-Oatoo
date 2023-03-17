import { Component } from '@angular/core';
import {HttpErrorResponse} from "@angular/common/http";
import swal from 'sweetalert2';
import { ApiProgramService } from '../../../../core/services/api/api-program.service';

@Component({
  selector: 'app-list-programs',
  templateUrl: './list-programs.component.html',
  styleUrls: ['./list-programs.component.css']
})
export class ListProgramsComponent {

  data_programs: any;
  dtOptions: any = {};


  apiErrorThrown: boolean = false;
  errorResponseServer: any;


  constructor(private api: ApiProgramService) { }


  ngOnInit() {
    this.api.findAll().subscribe((response: any) => {
      this.data_programs = response.data;
      setTimeout(() => {
        $('#datatableexample').DataTable({
          pagingType: 'full_numbers',
          pageLength: 5,
          responsive:true,
          processing: true,
          lengthMenu: [5, 10, 25],
          order: [[1, "desc"]]
        });
      }, 1);
    });


  }


}

