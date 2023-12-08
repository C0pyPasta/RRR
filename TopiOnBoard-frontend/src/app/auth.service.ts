export class AuthService {
  // hier zou logic moeten komen met backend, om te kijken of je bent ingelogd (zie ook de http-login.service)
  loggedIn = false;

  isAuthenticated() {
    const promise = new Promise((resolve) => {
      resolve(this.loggedIn);
    });
    return promise;
  }

  login() {
    this.loggedIn = true;
  }

  logout() {
    this.loggedIn = false;
  }
}
