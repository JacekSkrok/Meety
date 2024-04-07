import { Component, OnInit } from '@angular/core';
import { Appointment } from './appointment';
import { AppointmentService } from './appointment.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Host } from './host';
import { HostService } from './host.service';
import { Router } from '@angular/router'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public appointments: Appointment[];
  public hostsMap: Map<number, Host> = new Map<number, Host>();
  title = 'meety';

  constructor(
    private appointmentService: AppointmentService,
    private hostService: HostService,
    private router: Router
  ) {}

  ngOnInit(): void{
    this.getAppointments();
  }


  public getAppointments(): void{
    this.appointmentService.getAppointments().subscribe(
      (response: Appointment[]) => {
        this.appointments = response;
        this.appointments.forEach(appointment => {
          this.fetchHostForAppointment(appointment.appointmentId);
        });
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public fetchHostForAppointment(appointmentId: number): void {
    this.hostService.getHostForAppointment(appointmentId).subscribe(
      (response: Host) => {
        this.hostsMap.set(appointmentId, response);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public navigateToMeetPage(id: number) {
    this.router.navigate(['/meeting', id])
  }
}
