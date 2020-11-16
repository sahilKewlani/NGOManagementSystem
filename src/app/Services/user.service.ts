import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const API_URL = 'http://localhost:8080/api/test/';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }


  getDonations(): Observable<any> {
    return this.http.get(API_URL + 'allDonations', { responseType: 'text' });
  }
  getEvents(): Observable<any> {
    return this.http.get(API_URL + 'allEvents', { responseType: 'text' });
  }
  getVolunteers(): Observable<any> {
    return this.http.get(API_URL + 'allVolunteers', { responseType: 'text' });
  }
  getDonors(): Observable<any> {
    return this.http.get(API_URL + 'allDonors', { responseType: 'text' });
  }
  addEvent(event): Observable<any> {

      return this.http.post(API_URL + 'addEvent', {
        name: event.name,
        description: event.description,
        venue: event.venue,
        date: event.date,
      }, httpOptions);
    
  }
  getVolunteerEvents(volunteer): Observable<any> {

    return this.http.get(API_URL + 'getEvents/'+volunteer.id, {
      responseType: 'text'});
  
}
getDonorDonations(donor): Observable<any> {

  return this.http.get(API_URL + 'getDonations/'+donor.id, {
    responseType: 'text'});

}
registerForEvent(volunteer, event): Observable<any>{
  return this.http.post(API_URL + volunteer.id+'/registerFor/'+event, {
  }, httpOptions);

}

donate(donor, amount): Observable<any>{
  return this.http.post(API_URL + 'donate/'+donor.id, {
    amount: amount
  }, httpOptions);
}

}