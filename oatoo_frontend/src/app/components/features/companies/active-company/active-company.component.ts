import { Component, OnInit } from '@angular/core';
import { ApiCompanyService } from 'src/app/core/services/api/api-company.service';
import { HttpErrorResponse } from "@angular/common/http";
import swal from 'sweetalert2';
import { Company } from '../../../../core/models/Company';
import { ActivatedRoute } from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';
@Component({
  selector: 'app-active-company',
  templateUrl: './active-company.component.html',
  styleUrls: ['./active-company.component.css']
})
export class ActiveCompanyComponent {
  data_companies: any;
  dtOptions: any = {};
  id: any
  isButtonVisible = true
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


    UpdateAccount(id:number){
      this.api.UpdateAccount(id).subscribe((response: any) => {
        swal.fire({
          title:'Activation de compte',
          text:'Entreprise activé avec succès vous pouvez ajouter des programmes',
          icon:'info',
          confirmButtonText:'OK',
          timer:5000,
          toast: true,
          position: 'top-end',
          showConfirmButton: false,
          timerProgressBar: true,
          didOpen: (toast) => {
            toast.addEventListener('mouseenter', swal.stopTimer)
            toast.addEventListener('mouseleave', swal.resumeTimer)
          }
        });
        this.isButtonVisible = false;
      });
    }

}

