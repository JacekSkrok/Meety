import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HostService } from '../host.service';
import { AppointmentService } from '../appointment.service';
import { Host } from '../host';
import { Appointment } from '../appointment';

@Component({
  selector: 'app-host',
  templateUrl: './host.component.html',
  styleUrls: ['./host.component.css']
})
export class HostComponent implements OnInit {
  host: Host;
  public appointments: Appointment[];

  constructor(
    private route: ActivatedRoute,
    private hostService: HostService,
    private appointmentService: AppointmentService,
    private router: Router
  ) {}

  ngOnInit(): void{
    this.getHost();
    this.getHostsAppointments();
  }

  public getHost(): void{
    this.route.params.subscribe(params => {
      const hostId = +params['id'];
      this.hostService.getHost(hostId).subscribe(
        (host: Host) => {
          this.host = host;
        },
        error => {
          console.error('Error fetching gost:', error);
        }
      );
    });
  }

  public getHostsAppointments(): void{
    this.route.params.subscribe(params => {
      const hostId = +params['id'];
      this.appointmentService.getAllHostsAppointments(hostId).subscribe(
        (appointments: Appointment[]) => {
          this.appointments = appointments;
          console.log(appointments)
        },
        error => {
          console.error('Error fetching appointments:', error);
        }
      );
    });
  }
}
