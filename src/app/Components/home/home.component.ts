import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/Services/auth.service';
import { TokenStorageService } from 'src/app/Services/token-storage.service';
import { UserService } from '../../Services/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  content: string;

  constructor(private authService: AuthService, private tokenStorage: TokenStorageService, private router: Router, private userService : UserService) { }

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      
      var roles = this.tokenStorage.getUser().roles;
      if(roles.indexOf("ROLE_ADMIN")>=0)
            this.router.navigate(['/admin-board']);
      else if(roles.indexOf("ROLE_VOLUNTEER")>=0)
        this.router.navigate(['/volunteer-board']);
      else if(roles.indexOf("ROLE_DONOR")>=0)
      this.router.navigate(['/donor-board']);
      
    }
    
  }
}