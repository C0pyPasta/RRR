import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth-guard.service';

const routes: Routes = [
  {
    path: 'login',
    title: 'Topi-OnBoard inloggen',
    loadChildren: () =>
      import('./pages/login/login.module').then((m) => m.LogInModule),
  },
  {
    path: 'new-user',
    title: 'Topi-OnBoard Add User',
    loadChildren: () =>
      import('./pages/new-user/new-user.module').then((m) => m.NewUserModule),
  },
  {
    path: 'home',
    title: 'Topi-OnBoard Home',
    canActivate: [AuthGuard],
    loadChildren: () =>
      import('./pages/home/homepage.module').then((m) => m.HomePageModule),
  },
  {
    path: 'profile',
    title: 'Topi-OnBoard Profile',
    canActivate: [AuthGuard],
    loadChildren: () =>
      import('./pages/profile/profile.module').then((m) => m.ProfileModule),
  },
  { path: '', title: 'Topi-OnBoard', pathMatch: 'full', redirectTo: 'login' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
