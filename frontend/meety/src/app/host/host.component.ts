import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HostService } from '../host.service';
import { Host } from '../host';

@Component({
  selector: 'app-host',
  templateUrl: './host.component.html',
  styleUrls: ['./host.component.css']
})
export class HostComponent implements OnInit {
  host: Host;

  constructor(
    private route: ActivatedRoute,
    private hostService: HostService,
    private router: Router
  ) {}

  ngOnInit(): void{
    this.getHost();
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
}
