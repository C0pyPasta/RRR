import { Component } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { HttpNewUserService } from "./service/http-new-user.service";

@Component({
    selector: 'new-user',
    templateUrl: './new-user.component.html',
    styleUrls: ['./new-user.component.scss']
})
export class NewUserComponent {
    constructor(private service: HttpNewUserService) {}

    newUserForm = new FormGroup({
        usernameField: new FormControl('', [Validators.required]),
        emailField: new FormControl('', [Validators.required]),
        passwordField: new FormControl('', [Validators.required]),
    });

    submit() {
        this.service.login({
            username: this.newUserForm.value.usernameField,
            email: this.newUserForm.value.emailField,
            password: this.newUserForm.value.passwordField
        }).subscribe();
    }
}