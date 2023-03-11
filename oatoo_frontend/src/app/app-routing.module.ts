import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { from } from 'rxjs';
import { PageNotFoundComponent } from './landing/page-not-found/page-not-found.component';
import { HomeComponent } from './landing/home/home.component';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { MainComponent } from './dashboard/main/main.component';
const routes: Routes = [
  {
    path: 'accueil',
    component : HomeComponent,
  },
  {
    path: 'login',
    component : LoginComponent,
  },
  {
    path: 'register',
    component : RegisterComponent,
  },
  {
    path: 'dashboard',
    component : MainComponent,
  },
  /* {
    path: 'login',
    component : LoginComponent
  },
  {
    path: 'admin',
    loadChildren : ()=> import('./modules/admin.layout.module').then(m => m.AdminLayoutModule),
    canActivate : [IsConnectedGuard]
  },
  {
    path: 'register',
    component : RegisterComponent
  }, */
  {
    path : '',
    redirectTo : 'accueil',
    pathMatch : 'full'
  },
  {
    path : '**',
    component : PageNotFoundComponent
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
exports: [RouterModule]
})
export class AppRoutingModule { }
