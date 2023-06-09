import { Component, OnInit } from '@angular/core';
import { ApiCompanyService } from 'src/app/core/services/api/api-company.service';
import { HttpErrorResponse } from "@angular/common/http";
import swal from 'sweetalert2';
import { Company } from '../../../../core/models/Company';
import { ActivatedRoute } from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';
@Component({
  selector: 'app-detail-company',
  templateUrl: './detail-company.component.html',
  styleUrls: ['./detail-company.component.css']
})
export class DetailCompanyComponent implements OnInit {

  data_companies: any;
  dtOptions: any = {};
  id: any

  IsmodelClose = false;

  apiErrorThrown: boolean = false;
  errorResponseServer: any;
  thumbnail: any;

  constructor(private api: ApiCompanyService, private _ActivatedRoute:ActivatedRoute,private sanitizer: DomSanitizer) { }


  ngOnInit() {
    this.id=this._ActivatedRoute.snapshot.paramMap.get('id');
    this.id=parseInt(this.id);

    this.api.findByCompanyId(this.id).subscribe((response: any) => {
      this.data_companies = response.data;
      let objectURL= 'data:image/jpeg;base64,' + this.data_companies.companie_logo;
         this.thumbnail = this.sanitizer.bypassSecurityTrustUrl(objectURL);
      console.log("OK",this.data_companies)
    });


  }


}

