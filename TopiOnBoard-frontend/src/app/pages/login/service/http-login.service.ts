import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http"

@Injectable({
    providedIn: 'root'
})
export class HttpLogInService {
    constructor (private http: HttpClient) {}

    login() : any {
        return this.http.get('http.localhost:4200/hier moet een algemeen URL komen', {
            observe: 'response'
        })
    }
}