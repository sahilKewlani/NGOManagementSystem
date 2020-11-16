import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/Services/auth.service';
import { TokenStorageService } from 'src/app/Services/token-storage.service';
import { UserService } from '../../Services/user.service';

@Component({
  selector: 'app-board-admin',
  templateUrl: './board-admin.component.html',
  styleUrls: ['./board-admin.component.css']
})
export class BoardAdminComponent implements OnInit {
  volunteers=[];
  donors=[] ;
 roles;
  donations=[];
  events=[];
  constructor(private userService: UserService, private authService: AuthService, private tokenStorage: TokenStorageService, private router: Router) { }

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.roles = this.tokenStorage.getUser().roles;
      if(this.roles.indexOf("ROLE_ADMIN")<0)
            this.router.navigate(['/']);
    }
    this.userService.getVolunteers().subscribe(
      data => {
        this.volunteers = JSON.parse(data);
      },
      err => {
        this.volunteers = JSON.parse(err.error).message;
      }
    );
    this.userService.getEvents().subscribe(
      data => {
        this.events = JSON.parse(data);
      },
      err => {
        this.volunteers = JSON.parse(err.error).message;
      }
    );
    this.userService.getDonations().subscribe(
      data => {
        this.donations = JSON.parse(data);
      },
      err => {
        this.volunteers = JSON.parse(err.error).message;
      }
    );
    this.userService.getDonors().subscribe(
      data => {
        this.donors = JSON.parse(data);
      },
      err => {
        this.donors = JSON.parse(err.error).message;
      }
    );
    this.donors.forEach(donor =>{
      console.log(donor)
    });
  }
}