import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/Services/auth.service';
import { TokenStorageService } from 'src/app/Services/token-storage.service';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-board-donor',
  templateUrl: './board-donor.component.html',
  styleUrls: ['./board-donor.component.css']
})
export class BoardDonorComponent implements OnInit {

  content = '';
 roles;
 pastDonations=[];
 Donate=false;
 form:any={};
  errorMessage: any;
  constructor(private userService: UserService, private authService: AuthService, private tokenStorage: TokenStorageService, private router: Router) { }

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.roles = this.tokenStorage.getUser().roles;
      if(this.roles.indexOf("ROLE_DONOR")<0)
            this.router.navigate(['/']);
    }
    this.userService.getDonorDonations(this.tokenStorage.getUser()).subscribe(
      data => {
        this.pastDonations = JSON.parse(data);
        console.log(this.pastDonations);
      },
      err => {
        this.pastDonations = JSON.parse(err.error).message;
      }
    );
    
  }
  onSubmit(){
    console.log("in")
    console.log(this.form)
    this.userService.donate(this.tokenStorage.getUser(), this.form.amount).subscribe(
      data => {
        console.log(data);
        window.location.reload();
      },
      err => {
        this.errorMessage = err.error.message;
      }
    );
  }
  register(){
    this.Donate=!this.Donate;
  }
  

}
