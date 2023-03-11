import { Component, OnInit } from '@angular/core';
declare var particlesJS: any; 
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

        ngOnInit() {
          // https://vincentgarreau.com/particles.js/
          particlesJS.load('particles-js', 'assets/data/particles.json', function() { console.log('callback - particles.js config loaded'); });
      }
}
