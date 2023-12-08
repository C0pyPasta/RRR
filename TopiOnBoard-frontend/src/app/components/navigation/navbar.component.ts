import { AfterViewInit, Component, ElementRef, ViewChild } from '@angular/core';
import { AuthService } from 'src/app/auth.service';

@Component({
  selector: 'navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavBarComponent {
  constructor(private authService: AuthService) {}

  logout() {
    this.authService.logout();
  }
}
