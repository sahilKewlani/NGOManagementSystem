import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/Services/auth.service';
import { TokenStorageService } from 'src/app/Services/token-storage.service';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-add-event',
  templateUrl: './add-event.component.html',
  styleUrls: ['./add-event.component.css']
})
export class AddEventComponent implements OnInit {

  form: any = {};
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private authService: AuthService, private tokenStorage: TokenStorageService, private router: Router, private userService : UserService) { 
    
  }

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      
      var roles = this.tokenStorage.getUser().roles;
      if(roles.indexOf("ROLE_ADMIN")<0)
            this.router.navigate(['/']);
    }
    
  }

  onSubmit() {
    this.userService.addEvent(this.form).subscribe(
      data => {
        console.log(data);
        this.router.navigate(["/admin-board"]);
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
  }

}
