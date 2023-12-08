import { Component } from '@angular/core';
import { FtIconRegistry, iconFtUser } from '@fortytwo/ui';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title = 'TopiOnBoard-frontend';

  userIcon = iconFtUser;

  constructor(registry: FtIconRegistry) {
    registry.registerIcons([iconFtUser]);
  }
}
