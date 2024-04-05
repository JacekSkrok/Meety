import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { MeetComponent } from './meet-page/meet-page/meet-page.component';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    component: AppComponent
  },
  {
    path: 'meeting/:id',
    component: MeetComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
