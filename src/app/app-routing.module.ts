import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddEventComponent } from './Components/add-event/add-event.component';
import { AdminLoginComponent } from './Components/admin-login/admin-login.component';
import { AdminRegisterComponent } from './Components/admin-register/admin-register.component';
import { BoardAdminComponent } from './Components/board-admin/board-admin.component';
import { BoardDonorComponent } from './Components/board-donor/board-donor.component';
import { BoardVolunteerComponent } from './Components/board-volunteer/board-volunteer.component';
import { HomeComponent } from './Components/home/home.component';
import { LoginComponent } from './Components/login/login.component';
import { ProfileComponent } from './Components/profile/profile.component';
import { RegisterComponent } from './Components/register/register.component';


const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path:'admin-register', component: AdminRegisterComponent},
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'user', component: BoardVolunteerComponent },
  { path: 'admin', component: AdminLoginComponent },
  { path: 'admin-board', component: BoardAdminComponent },
  { path: 'volunteer-board', component: BoardVolunteerComponent },
  { path: 'donor-board', component: BoardDonorComponent},
  { path: 'add-event', component: AddEventComponent}
  
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
