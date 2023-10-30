import { HttpClientModule } from "@angular/common/http";
import { NgModule } from "@angular/core";
import { ReactiveFormsModule } from "@angular/forms";
import { RouterModule, Routes } from "@angular/router";
import { FtButtonModule } from "@fortytwo/ui";
import { FtFormFieldModule } from "@fortytwo/ui/forms/form-field";
import { HttpNewUserService } from "./service/http-new-user.service";
import { NewUserComponent } from "./new-user.component";

export const NewUserRoutes: Routes = [
    { path: '', component: NewUserComponent }
];

@NgModule({
    declarations: [
        NewUserComponent
    ],
    imports: [
        RouterModule.forChild(NewUserRoutes),
        ReactiveFormsModule,
        HttpClientModule,
        FtFormFieldModule,
        FtButtonModule
    ],
    exports: [
        RouterModule
    ],
    providers: [HttpNewUserService]
})
export class NewUserModule {}