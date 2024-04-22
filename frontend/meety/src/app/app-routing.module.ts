import { NgModule } from '@angular/core';
import { MeetComponent } from './meet-page/meet-page/meet-page.component';
import { RouterModule, Routes, Route } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { HostComponent } from './host/host.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'host/:id',
    component: HostComponent
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
