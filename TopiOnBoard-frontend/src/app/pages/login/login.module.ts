import { NgModule } from "@angular/core";
import { LogInComponent } from "./login.component";
import { HttpClientModule } from "@angular/common/http";
import { ReactiveFormsModule } from "@angular/forms";
import { RouterModule, Routes } from "@angular/router";
import { HttpLogInService } from "./service/http-login.service";

import { FtFormFieldModule } from '@fortytwo/ui/forms/form-field';
import { FtButtonModule } from "@fortytwo/ui";

export const logInRoutes: Routes = [
    { path: '', component: LogInComponent },
    { path: 'home', title: 'Topi-OnBoard Homepagina', loadChildren: () => import('../home/homepage.module').then(m => m.HomePageModule) },
];

@NgModule({
    declarations: [
        LogInComponent
    ],
    imports: [
        RouterModule.forChild(logInRoutes),
        ReactiveFormsModule,
        HttpClientModule,
        FtFormFieldModule,
        FtButtonModule
    ],
    exports: [
        RouterModule
    ],
    providers: [HttpLogInService]
})
export class LogInModule {}