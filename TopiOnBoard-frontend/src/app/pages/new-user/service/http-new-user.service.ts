import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { APP_CONFIG, AppConfiguration } from 'src/app/config/app.configuration';

@Injectable({
  providedIn: 'root',
})
export class HttpNewUserService {
  constructor(
    private http: HttpClient,
    @Inject(APP_CONFIG) private CONFIG: AppConfiguration
  ) {}

  login(form: { [key: string]: string | null | undefined }): any {
    return this.http.get(`${this.CONFIG.backend}/rest/users/test`, {
      observe: 'response',
    });
  }
}
