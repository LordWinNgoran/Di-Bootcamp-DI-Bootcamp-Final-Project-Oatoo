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
    ListParticipantsProgramsComponent
  ],
  imports: [
  BrowserModule,
    AppRoutingModule,
      BrowserAnimationsModule,
      TuiRootModule,
      TuiDialogModule,
      TuiAlertModule,
      TuiButtonModule,
      NgxPaginationModule
],
  providers: [{provide: TUI_SANITIZER, useClass: NgDompurifySanitizer}],
  bootstrap: [AppComponent]
})
export class AppModule { }
