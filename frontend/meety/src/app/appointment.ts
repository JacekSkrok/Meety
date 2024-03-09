import { Time } from "@angular/common";

export interface Appointment {
  appointmentId: number;
  appointmentName: string;
  appointmentDate: Date;
  appointmentStartTime: string;
  appointmentDescription: string;
  appointmentLength: number;
}
