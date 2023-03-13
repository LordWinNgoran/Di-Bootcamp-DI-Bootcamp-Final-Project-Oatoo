import { Component, OnInit } from '@angular/core';
import swal from 'sweetalert2';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css',
              '../../../../assets/css/carousel.css',
              '../../../../assets/cover.css',
              
            ]
})
export class HomeComponent implements OnInit{
     
  ngOnInit() {
    // Sweet Alert permettant d'afficher la notification de bienvenue
    swal.fire({
      title:'Oatoo',
      text:"Akwaba ! Soyez la bienvenue",
      icon:'info',
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
}
