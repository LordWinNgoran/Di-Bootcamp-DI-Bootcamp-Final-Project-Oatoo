import { Component, OnInit } from '@angular/core';
declare var particlesJS: any; 
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit{
  ngOnInit() {
    // https://vincentgarreau.com/particles.js/
    particlesJS.load('particles-js', 'assets/data/particles1.json', function() { console.log('callback - particles.js config loaded'); });
}
}
