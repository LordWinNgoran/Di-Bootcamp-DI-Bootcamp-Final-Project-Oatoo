import { NgDompurifySanitizer } from "@tinkoff/ng-dompurify";
import { TuiRootModule, TuiDialogModule, TuiAlertModule, TUI_SANITIZER } from "@taiga-ui/core";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/landing/home/home.component';
import { PageNotFoundComponent } from './components/landing/page-not-found/page-not-found.component';
import {TuiButtonModule} from '@taiga-ui/core';
import { LoginComponent } from './auth/login/login.component';
import { MainComponent } from './components/dashboard/main/main.component';
import { HeaderComponent } from './components/share/header/header.component';
import { TestComponent } from './components/dashboard/test/test.component';
import { HeadComponent } from './components/dashboard/head/head.component';
import { AddProgramComponent } from './components/features/programs/add-program/add-program.component';
import { FooterComponent } from './components/dashboard/footer/footer.component';
import { ListProgramsComponent } from './components/features/programs/list-programs/list-programs.component';
import { ListParticipantsProgramsComponent } from './components/features/programs/list-participants-programs/list-participants-programs.component';
import {NgxPaginationModule} from 'ngx-pagination';
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
import { HttpClientModule } from "@angular/common/http";
import { FormsModule } from "@angular/forms";
import {DataTablesModule} from 'angular-datatables';
import { CondtionUtilisationComponent } from './components/dashboard/condtion-utilisation/condtion-utilisation.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PageNotFoundComponent,
    LoginComponent,
    MainComponent,
    HeaderComponent,
    TestComponent,
    AddProgramComponent,
    HeadComponent,
    FooterComponent,
    ListProgramsComponent,
    ListParticipantsProgramsComponent,
    AddCompanyComponent,
    CompanyPibComponent,
    ListCompaniesComponent,
    ModCompanyComponent,
    AddInscriptionComponent,
    NoteFormationComponent,
    ListDemandesComponent,
    ListSubscribersComponent,
    ViewGradesComponent,
    BestSubscribersComponent,
    ApplicantInsertedComponent,
    AddContractComponent,
    ListContractsComponent,
    MyContractsComponent,
    AddApplicantComponent,
    ListApplicantsComponent,
    ViewProfileComponent,
    SeeProfileComponent,
    FeedbacksComponent,
    YearOperationComponent,
    TypeContractsComponent,
    TypePieceComponent,
    PibComponent,
    UsersComponent,
    ManageUserComponent,
    CondtionUtilisationComponent
  ],
  imports: [
  BrowserModule,
    AppRoutingModule,
      BrowserAnimationsModule,
      TuiRootModule,
      TuiDialogModule,
      TuiAlertModule,
      TuiButtonModule,
      NgxPaginationModule,
      HttpClientModule,
      FormsModule,
      DataTablesModule
],
  providers: [{provide: TUI_SANITIZER, useClass: NgDompurifySanitizer}],
  bootstrap: [AppComponent]
})
export class AppModule { }
