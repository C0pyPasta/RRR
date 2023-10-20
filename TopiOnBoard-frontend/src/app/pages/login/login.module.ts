import { NgModule } from "@angular/core";
import { LogInComponent } from "./login.component";
import { HttpClientModule } from "@angular/common/http";
import { ReactiveFormsModule } from "@angular/forms";
import { RouterModule, Routes } from "@angular/router";
import { HttpLogInService } from "./http-login.service";

export const logInRoutes: Routes = [
    { path: '', component: LogInComponent }
];

@NgModule({
    declarations: [
        LogInComponent
    ],
    imports: [
        RouterModule.forChild(logInRoutes),
        ReactiveFormsModule,
        HttpClientModule,
    ],
    exports: [
        RouterModule
    ],
    providers: [HttpLogInService]
})
export class LogInModule {}