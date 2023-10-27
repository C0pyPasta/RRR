import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', title: 'Topi-OnBoard',  pathMatch: 'full', redirectTo: 'login'},
  { path: 'login', title: 'Topi-OnBoard inloggen', loadChildren: () => import('./pages/login/login.module').then(m => m.LogInModule) },
  { path: 'home', title: 'Topi-OnBoard Homepagina', loadChildren: () => import('./pages/home/homepage.module').then(m => m.HomePageModule) },
  { path: 'new-user', title: 'Topi-OnBoard Add User', loadChildren: () => import ('./pages/new-user/new-user.module').then(m => m.NewUserModule) }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
