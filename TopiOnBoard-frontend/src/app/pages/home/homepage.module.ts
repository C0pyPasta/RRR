import { NgModule } from '@angular/core';
import { HomePageComponent } from './homepage.component';

import { FtButtonModule } from '@fortytwo/ui';
import { FtIconModule } from '@fortytwo/ui/components/icons';
import { RouterModule, Routes } from '@angular/router';

export const HomeRoutes: Routes = [{ path: '', component: HomePageComponent }];

@NgModule({
  declarations: [HomePageComponent],
  imports: [RouterModule.forChild(HomeRoutes), FtIconModule, FtButtonModule],
  exports: [],
  providers: [],
})
export class HomePageModule {}
