import { NgModule, Component } from '@angular/core';
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
import { AddCompanyComponent } from './components/features/companies/add-company/add-company.component';
import { CompanyPibComponent } from './components/features/companies/company-pib/company-pib.component';
import { ListCompaniesComponent } from './components/features/companies/list-companies/list-companies.component';
import { ModCompanyComponent } from './components/features/companies/mod-company/mod-company.component';
import { AddInscriptionComponent } from './components/features/inscriptions/add-inscription/add-inscription.component';
import { NoteFormationComponent } from './components/features/inscriptions/note-formation/note-formation.component';
import { ListDemandesComponent } from './components/features/inscriptions/list-demandes/list-demandes.component';
import { ListSubscribersComponent } from './components/features/inscriptions/list-subscribers/list-subscribers.component';
import { ViewGradesComponent } from './components/features/inscriptions/view-grades/view-grades.component';
import { BestSubscribersComponent } from './components/features/inscriptions/best-subscribers/best-subscribers.component';
import { ApplicantInsertedComponent } from './components/features/inscriptions/applicant-inserted/applicant-inserted.component';
import { AddContractComponent } from './components/features/contracts/add-contract/add-contract.component';
import { ListContractsComponent } from './components/features/contracts/list-contracts/list-contracts.component';
import { MyContractsComponent } from './components/features/contracts/my-contracts/my-contracts.component';
import { AddApplicantComponent } from './components/features/applicants/add-applicant/add-applicant.component';
import { ListApplicantsComponent } from './components/features/applicants/list-applicants/list-applicants.component';
import { ViewProfileComponent } from './components/features/applicants/view-profile/view-profile.component';
import { SeeProfileComponent } from './components/features/applicants/see-profile/see-profile.component';
import { FeedbacksComponent } from './components/features/applicants/feedbacks/feedbacks.component';
import { YearOperationComponent } from './components/features/setting/year-operation/year-operation.component';
import { TypeContractsComponent } from './components/features/setting/type-contracts/type-contracts.component';
import { TypePieceComponent } from './components/features/setting/type-piece/type-piece.component';
import { PibComponent } from './components/features/setting/pib/pib.component';
import { UsersComponent } from './components/features/setting/users/users.component';
import { ManageUserComponent } from './components/features/users/manage-user/manage-user.component';
import { HeadComponent } from './components/dashboard/head/head.component';

// Définition des routes

const routes: Routes = [

  // Début définition des routes du landing page connexion et login
  {
    path: 'accueil',
    component: HomeComponent,
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'register',
    component: RegisterComponent,
  },

  // fin définition des routes du landing page connexion et login











  //page d'acceuil après connexion



  // Début groupement des routes pour la fonctionnalité : programme
  {
    path: 'user',
    component: HeadComponent,
    children: [
      {
        path: 'oatoo',
        component: MainComponent,
      },
      {
        path: 'program',
        children: [
          {
            path: 'add',
            component: AddProgramComponent,
          },
          {
            path: 'list',
            component: ListProgramsComponent,
          },
          {
            path: 'participants',
            component: ListParticipantsProgramsComponent,
          },

        ]

      },
      // Début groupement des routes pour la fonctionnalité : entreprise


      {
        path: 'company',
        children: [
          {
            path: 'add',
            component: AddCompanyComponent,
          },
          {
            path: 'list',
            component: ListCompaniesComponent,
          },
          {
            path: 'pib',
            component: CompanyPibComponent,
          },
          {
            path: 'update',
            component: ModCompanyComponent,
          },

        ]

      },

      // fin groupement des routes pour la fonctionnalité : entreprise







      // Début groupement des routes pour la fonctionnalité : participation a un programme

      {
        path: 'inscription',
        children: [
          {
            path: 'add',
            component: AddInscriptionComponent,
          },
          {
            path: 'note-formation',
            component: NoteFormationComponent,
          },
          {
            path: 'list-demands',
            component: ListDemandesComponent,
          },
          {
            path: 'list-subscribers',
            component: ListSubscribersComponent,
          },

          {
            path: 'view-grades',
            component: ViewGradesComponent,
          },
          {
            path: 'best-subscribers',
            component: BestSubscribersComponent,
          },
          {
            path: 'applicants-inserted',
            component: ApplicantInsertedComponent,
          },
        ]
      },
      // fin groupement des routes pour la fonctionnalité : participation a un programme



      // Début groupement des routes pour la fonctionnalité :  Contrat

      {
        path: 'contract',
        children: [
          {
            path: 'add',
            component: AddContractComponent,
          },
          {
            path: 'list',
            component: ListContractsComponent,
          },
          {
            path: 'my-contract',
            component: MyContractsComponent,
          },
        ]
      },
      // fin groupement des routes pour la fonctionnalité :  Contrat




      // Début groupement des routes pour la fonctionnalité :  Demandeurs d'emploi

      {
        path: 'applicant',
        children: [
          {
            path: 'add',
            component: AddApplicantComponent,
          },
          {
            path: 'list',
            component: ListApplicantsComponent,
          },
          {
            path: 'view-myprofile',
            component: ViewProfileComponent,
          },


          {
            path: 'see-profile',
            component: SeeProfileComponent,
          },
          {
            path: 'feedbacks',
            component: FeedbacksComponent,
          },

        ]

      },

      // fin groupement des routes pour la fonctionnalité :  Demandeurs d'emploi




      // Début groupement des routes pour les configurations

      {
        path: 'year',
        component: YearOperationComponent,
      },
      {
        path: 'type-contracts',
        component: TypeContractsComponent,
      },
      {
        path: 'type-card',
        component: TypePieceComponent,
      },

      {
        path: 'pib',
        component: PibComponent,
      },
      {
        path: 'users',
        component: UsersComponent,
      },

      {
        path: 'user-manage',
        component: ManageUserComponent,
      },
      

    ]

  },

  /* {
    path: 'program',
    children :[
      {
        path: 'add',
        component : AddProgramComponent,
      },
      {
        path: 'list',
        component : ListProgramsComponent,
      },
      {
        path: 'participants',
        component : ListParticipantsProgramsComponent,
      },
      
    ]
    
  }, */
  // fin groupement des routes pour la fonctionnalité : programme





  // Début groupement des routes pour les configurations

  {
    path: '',
    redirectTo: 'accueil',
    pathMatch: 'full'
  },
  {
    path: '**',
    component: PageNotFoundComponent
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
