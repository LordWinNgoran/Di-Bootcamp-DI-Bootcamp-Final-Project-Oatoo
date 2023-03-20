import { HTTP_INTERCEPTORS, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpHandler, HttpRequest } from '@angular/common/http';
import { TokenStorageService } from '../api/token-storage.service';
import { Observable } from 'rxjs';
const TOKEN_HEADER_KEY = 'Authorization';       // for Spring Boot back-end
@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(private token: TokenStorageService) { }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let authReq = req;
    const token = this.token.getToken();/* 
    console.log("James isok",token);
   let indexdebut=token?.indexOf('id":"');
   let last=token?.slice(indexdebut);
   let indexdebut1=last?.indexOf(':"');
   let last1=last?.slice(indexdebut1);
   let last2=last1?.slice(2);
   let indexdebut2=last2?.indexOf('"}}');
   let last3=last2?.slice(0,indexdebut2); */
    console.log(token);
    if (token != null) {
      authReq = req.clone({ headers: req.headers.set(TOKEN_HEADER_KEY, 'Bearer ' + token) });
    }
    return next.handle(authReq);
  }
}
export const authInterceptorProviders = [
  { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }
];
