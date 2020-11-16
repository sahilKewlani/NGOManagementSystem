import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/Services/auth.service';
import { TokenStorageService } from 'src/app/Services/token-storage.service';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-board-volunteer',
  templateUrl: './board-volunteer.component.html',
  styleUrls: ['./board-volunteer.component.css']
})
export class BoardVolunteerComponent implements OnInit {
  form:any={}
  content = '';
  registerEvent=false;
  registeredEvents=[];
  allEvents=[];
 roles;
  isSuccessful: boolean;
  isSignUpFailed: boolean;
  errorMessage: any;
  constructor(private userService: UserService, private authService: AuthService, private tokenStorage: TokenStorageService, private router: Router) { 
  }

  ngOnInit() {
    this.form.amount=0;
    if (this.tokenStorage.getToken()) {
      
      this.roles = this.tokenStorage.getUser().roles;
      console.log(this.tokenStorage.getUser())
      if(this.roles.indexOf("ROLE_VOLUNTEER")<0)
            this.router.navigate(['/']);
            this.userService.getVolunteerEvents(this.tokenStorage.getUser()).subscribe(
              data => {
                this.registeredEvents = JSON.parse(data);
                console.log(this.registeredEvents);
                this.userService.getEvents().subscribe(
              data => {
                var events = JSON.parse(data);
                events.forEach(event=> { 
                  if(this.registeredEvents=== null || this.registeredEvents=== undefined|| this.registeredEvents.length === 0)
                  {
                    console.log(event);
                    this.allEvents.push(event);
                  }
                  else if(this.registeredEvents.find(x=>x.id === event.id) == undefined)
                  {
                    console.log(event);
                    this.allEvents.push(event);
                  }
                });
              },
              err => {
                this.allEvents = JSON.parse(err.error).message;
              }
            );
              },
              err => {
                this.registeredEvents = JSON.parse(err.error).message;
              }
            );
          }
    
    
    
    
    
  }
  
  Register()
  {
this.registerEvent=!this.registerEvent;
  }
  onSubmit() {
    console.log(this.form)
    this.userService.registerForEvent(this.tokenStorage.getUser(),this.form.events).subscribe(
      data => {
        console.log(data);
        window.location.reload();
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
  }

}

