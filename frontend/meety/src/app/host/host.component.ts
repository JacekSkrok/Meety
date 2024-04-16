import { Component } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-host',
  templateUrl: './host.component.html',
  styleUrls: ['./host.component.css']
})
export class HostComponent {
  constructor(
    private router: Router
  ) {}

}
