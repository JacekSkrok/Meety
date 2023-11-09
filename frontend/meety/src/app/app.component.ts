import { Component, OnInit } from '@angular/core';
import { Appointment } from './appointment';
import { AppointmentService } from './appointment.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public appointments: Appointment[];
  title = 'meety';

  constructor( private appointmentService: AppointmentService ) {}

  ngOnInit(): void{
    this.getAppointments();
  }

  public getAppointments(): void{
    this.appointmentService.getAppointments().subscribe(
      (response: Appointment[]) => {
        this.appointments = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
