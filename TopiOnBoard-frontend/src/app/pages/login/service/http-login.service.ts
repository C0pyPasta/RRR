import { Inject, Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http"
import { APP_CONFIG, AppConfiguration } from "src/app/config/app.configuration";

@Injectable({
    providedIn: 'root'
})
export class HttpLogInService {
    constructor (private http: HttpClient, @Inject(APP_CONFIG) private CONFIG: AppConfiguration) {}

    login(form: {[key: string] : string|null|undefined}) : any {
        return this.http.get(`${this.CONFIG.backend}/users/test`, {
            observe: 'response'
        })
    }
}