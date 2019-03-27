import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
<<<<<<< HEAD
import { SendqueryComponent } from './sendquery/sendquery.component';
import { NavbarComponent } from './navbar/navbar.component';

=======
import { DashboardComponent } from './dashboard/dashboard.component';
import { HomeComponent } from './home/home.component';
import { SigninComponent } from './signin/signin.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
>>>>>>> 74b4a6f5659fdf172e802848bb678e82efa59ea0

@NgModule({
  declarations: [
    AppComponent,
<<<<<<< HEAD
    SendqueryComponent,
    NavbarComponent,
=======
    DashboardComponent,
    HomeComponent,
    SigninComponent,
    LoginComponent
>>>>>>> 74b4a6f5659fdf172e802848bb678e82efa59ea0
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
<<<<<<< HEAD
    FormsModule
=======
    FormsModule,
    HttpClientModule,
>>>>>>> 74b4a6f5659fdf172e802848bb678e82efa59ea0
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
