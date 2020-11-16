import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './Components/register/register.component';
import { HomeComponent } from './Components/home/home.component';
import { ProfileComponent } from './Components/profile/profile.component';
import { BoardAdminComponent } from './Components/board-admin/board-admin.component';
import { BoardVolunteerComponent } from './Components/board-volunteer/board-volunteer.component';
import {APP_BASE_HREF} from '@angular/common';
import { authInterceptorProviders } from './_helpers/auth.interceptor';
import { LoginComponent } from './Components/login/login.component';
import { AdminLoginComponent } from './Components/admin-login/admin-login.component';
import { AdminRegisterComponent } from './Components/admin-register/admin-register.component';
import {MatSelectModule} from '@angular/material/select';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BoardDonorComponent } from './Components/board-donor/board-donor.component';
import { AddEventComponent } from './Components/add-event/add-event.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ProfileComponent,
    BoardAdminComponent,
    BoardVolunteerComponent,
    AdminLoginComponent,
    AdminRegisterComponent,
    BoardDonorComponent,
    AddEventComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    MatSelectModule,
    BrowserAnimationsModule
  ],
  providers: [authInterceptorProviders,  {provide: APP_BASE_HREF, useValue: '/'}],
  bootstrap: [AppComponent]
})
export class AppModule { }
