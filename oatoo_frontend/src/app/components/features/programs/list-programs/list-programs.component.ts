import { Component } from '@angular/core';

@Component({
  selector: 'app-list-programs',
  templateUrl: './list-programs.component.html',
  styleUrls: ['./list-programs.component.css',

  '../../../../../assets/vendor/bootstrap/css/bootstrap.min.css',
  '../../../../../assets/vendor/bootstrap-icons/bootstrap-icons.css',
  '../../../../../assets/vendor/boxicons/css/boxicons.min.css',
  '../../../../../assets/vendor/quill/quill.snow.css',
  '../../../../../assets/vendor/quill/quill.bubble.css',
  '../../../../../assets/vendor/remixicon/remixicon.css',
  '../../../../../assets/vendor/simple-datatables/style.css',
  '../../../../../assets/css/style.css',]
})
export class ListProgramsComponent {

  p: number = 1;
  collection =[
    { "id": 0, "name": "Available" },
    { "id": 1, "name": "Ready" },
    { "id": 3, "name": "Started" },
    { "id": 4, "name": "Available" },
    { "id": 5, "name": "Ready" },
    { "id": 6, "name": "Started" },
    { "id": 7, "name": "Available" },
    { "id": 8, "name": "Ready" },
    { "id": 9, "name": "Started" },
    { "id": 10, "name": "Available" },
    { "id": 11, "name": "Ready" },
    { "id": 12, "name": "Started" },
    { "id": 13, "name": "Available" },
    { "id": 1, "name": "Ready" },
    { "id": 2, "name": "Started" },
    { "id": 0, "name": "Available" },
    { "id": 1, "name": "Ready" },
    { "id": 2, "name": "Started" },
    { "id": 0, "name": "Available" },
    { "id": 1, "name": "Ready" },
    { "id": 2, "name": "Started" },
    { "id": 0, "name": "Available" },
    { "id": 1, "name": "Ready" },
    { "id": 2, "name": "Started" },
    { "id": 0, "name": "Available" },
    { "id": 1, "name": "Ready" },
    { "id": 2, "name": "Started" },
    { "id": 0, "name": "Available" },
    { "id": 1, "name": "Ready" },
    { "id": 2, "name": "Started" },
    { "id": 0, "name": "Available" },
    { "id": 1, "name": "Ready" },
    { "id": 2, "name": "Started" },

];
}
