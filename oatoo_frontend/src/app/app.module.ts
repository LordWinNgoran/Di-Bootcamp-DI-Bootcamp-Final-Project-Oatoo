import { NgDompurifySanitizer } from "@tinkoff/ng-dompurify";
import { TuiRootModule, TuiDialogModule, TuiAlertModule, TUI_SANITIZER } from "@taiga-ui/core";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './landing/home/home.component';
import { PageNotFoundComponent } from './landing/page-not-found/page-not-found.component';
import {TuiButtonModule} from '@taiga-ui/core';
import { LoginComponent } from './auth/login/login.component';
import { MainComponent } from './dashboard/main/main.component';
import { HeaderComponent } from './share/header/header.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PageNotFoundComponent,
    LoginComponent,
    MainComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
      BrowserAnimationsModule,
      TuiRootModule,
      TuiDialogModule,
      TuiAlertModule,
      TuiButtonModule
],
  providers: [{provide: TUI_SANITIZER, useClass: NgDompurifySanitizer}],
  bootstrap: [AppComponent]
})
export class AppModule { }
