import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';


import {AppComponent} from './component/app/app.component';
import {AppRouting} from "./app.routing";
import {LoginComponent} from './component/login/login.component';
import { HomeComponent } from './component/home/home.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './component/header/header.component';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRouting
  ],
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    FooterComponent,
    HeaderComponent,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
