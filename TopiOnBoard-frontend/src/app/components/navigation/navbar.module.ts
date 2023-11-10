import { NgModule } from '@angular/core';
import { NavBarComponent } from './navbar.component';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [NavBarComponent],
  imports: [CommonModule],
  exports: [NavBarComponent],
  providers: [],
})
export class NavBarModule {}
