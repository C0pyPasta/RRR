import { Component } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { HttpLogInService } from "./http-login.service";


@Component({
    selector: 'top-log-in',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss']
})
export class LogInComponent {
    constructor(private service: HttpLogInService) {}


    inlogForm = new FormGroup({
        usernameField: new FormControl('', [Validators.required]),
        passwordField: new FormControl('', [Validators.required]),
    });


    submit() {
        this.service.login();
    }
}