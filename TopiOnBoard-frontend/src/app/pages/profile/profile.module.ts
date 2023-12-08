import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ProfileComponent } from './profile.component';
import { RouterModule, Routes } from '@angular/router';

export const ProfileRoutes: Routes = [
  { path: '', title: 'Profile', component: ProfileComponent },
];

@NgModule({
  declarations: [ProfileComponent],
  imports: [RouterModule.forChild(ProfileRoutes), CommonModule],
  providers: [],
  bootstrap: [ProfileComponent],
})
export class ProfileModule {}
