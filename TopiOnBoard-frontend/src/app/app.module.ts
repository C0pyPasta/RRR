import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { NavBarModule } from './components/navigation/navbar.module';
import { AuthGuard } from './auth-guard.service';
import { AuthService } from './auth.service';

@NgModule({
  declarations: [AppComponent],
  imports: [CommonModule, BrowserModule, AppRoutingModule, NavBarModule],
  providers: [AuthGuard, AuthService],
  bootstrap: [AppComponent],
})
export class AppModule {}
