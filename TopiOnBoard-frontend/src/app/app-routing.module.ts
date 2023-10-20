import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './pages/home/homepage.component';

const routes: Routes = [
  { path: '', title: 'Topi-OnBoard',  pathMatch: 'full', redirectTo: 'login'},
  { path: 'login', title: 'Topi-OnBoard inloggen', loadChildren: () => import('./pages/login/login.module').then(m => m.LogInModule) },
  { path: 'home', title: 'Topi-OnBoard Homepagina', component: HomePageComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
