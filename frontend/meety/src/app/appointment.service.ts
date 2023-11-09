import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Appointment } from './appointment';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {
  private apiServerUrl = environment.apiBaseUrl

  constructor(private http: HttpClient) { }

  public getAppointments() : Observable<Appointment[]> {

    return this.http.get<Appointment[]>(`${this.apiServerUrl}/api/v1/appointments`);
  }
}
