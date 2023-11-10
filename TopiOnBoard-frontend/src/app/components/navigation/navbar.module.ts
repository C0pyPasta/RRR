import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { NavBarComponent } from './navbar.component';

@NgModule({
  declarations: [NavBarComponent],
  imports: [CommonModule],
  providers: [],
  bootstrap: [NavBarComponent],
})
export class NavBarModule {}
