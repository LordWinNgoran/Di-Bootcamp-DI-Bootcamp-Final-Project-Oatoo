import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { from } from 'rxjs';
import { PageNotFoundComponent } from './components/landing/page-not-found/page-not-found.component';
import { HomeComponent } from './components/landing/home/home.component';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { MainComponent } from './components/dashboard/main/main.component';
import { AddProgramComponent } from './components/features/programs/add-program/add-program.component';
import { ListProgramsComponent } from './components/features/programs/list-programs/list-programs.component';
import { ListParticipantsProgramsComponent } from './components/features/programs/list-participants-programs/list-participants-programs.component';

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
    path: 'oatoo',
    component : MainComponent,
  },
  {
    path: 'add-program',
    component : AddProgramComponent,
  },
  {
    path: 'list-programs',
    component : ListProgramsComponent,
  },
  {
    path: 'programs-participants',
    component : ListParticipantsProgramsComponent,
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
