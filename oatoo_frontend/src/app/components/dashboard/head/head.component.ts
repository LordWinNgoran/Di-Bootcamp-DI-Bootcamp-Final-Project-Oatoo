import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from 'src/app/core/services/api/token-storage.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-head',
  templateUrl: './head.component.html',
  styleUrls: ['./head.component.css']
})
export class HeadComponent implements OnInit{
  /**
   * @author:N'GORAN KOUADIO JEAN CYRILLE
   * @Date: 20 Mars 2023
   * 
   */

  // user pour recuperer les infos du user stocké dans le localstorage
  user:any

  constructor(private token :TokenStorageService, private route :Router){}

  ngOnInit() {
   this.user = this.token.getUser()
}

  logout(){
    window.localStorage.clear();
    this.route.navigate(['/'])
  }
  
}
