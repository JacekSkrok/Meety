import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment.development';
import { Observable, map } from 'rxjs';
import { Host } from './host';

@Injectable({
  providedIn: 'root'
})
export class HostService {
  private apiServerUrl = environment.apiBaseUrl

  constructor(private http: HttpClient) { }

  public getHostForAppointment(appointmentId: number): Observable<Host> {
    return this.http.get<Host[]>(`${this.apiServerUrl}/api/v1/appointments/${appointmentId}`).pipe(
      map((response: any) => response.speakers[0])
    );
  }
}
