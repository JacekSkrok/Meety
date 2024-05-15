import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-meet-page',
  templateUrl: './meet-page.component.html',
  styleUrls: ['./meet-page.component.css']
})
export class MeetPageComponent {
  constructor( private route: ActivatedRoute) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      const id = params['id'];
      console.log('Meeting ID:', id);
    });
  }
}
