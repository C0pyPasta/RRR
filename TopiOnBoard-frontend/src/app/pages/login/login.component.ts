import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { HttpLogInService } from './service/http-login.service';
import { AuthService } from 'src/app/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'log-in',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LogInComponent {
  constructor(
    private service: HttpLogInService,
    private authService: AuthService,
    private router: Router
  ) {}

  inlogForm = new FormGroup({
    usernameField: new FormControl('', [Validators.required]),
    passwordField: new FormControl('', [Validators.required]),
  });

  submit() {
    this.service
      .login({
        username: this.inlogForm.value.usernameField,
        password: this.inlogForm.value.passwordField,
      })
      .subscribe();
  }

  Inloggen() {
    this.authService.login();

    this.router.navigate(['/home']);
  }
}
