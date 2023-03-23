import { Component } from '@angular/core';
import { ApiTypeCardService } from 'src/app/core/services/api/api-type-card.service'; 
import {HttpErrorResponse} from "@angular/common/http";
import { Type_card } from '../../../../core/models/Type_card';
import swal from 'sweetalert2';
@Component({
  selector: 'app-type-piece',
  templateUrl: './type-piece.component.html',
  styleUrls: ['./type-piece.component.css']
})
export class TypePieceComponent {

  type_cards!: Type_card;
  data_type_cards : any;
  columns  : any ;
  p: number = 1;

  form: any = {
    desc_card_type: null,
  };

  IsmodelClose=false;

  apiErrorThrown: boolean = false;
  errorResponseServer: any;
  

  constructor(private api: ApiTypeCardService,){
    this.type_cards = new Type_card(null!,null!,null!);
  }

 
  ngOnInit(){
    this.getAlltypecards()
  }


  getAlltypecards() {
    this.api.findAll().subscribe((response : any) => {
      this.data_type_cards = response.data ;
      console.log(this.data_type_cards);
    });
  }

  addTypeCard(cardForm: any) {
    console.log(cardForm);
    console.log(this.type_cards);
    if (cardForm.valid) {
      this.api.create(this.type_cards).subscribe({
        next: (response) => {
            swal.fire({
              title:'succès',
              text:'Type de pièce enregistré avec succès',
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
    
            cardForm.reset();
          this.apiErrorThrown = false;
          this.IsmodelClose=true;
          this.getAlltypecards();
          
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

