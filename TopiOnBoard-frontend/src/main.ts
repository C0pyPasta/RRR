import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';
import { APP_CONFIG, AppConfiguration } from './app/config/app.configuration';


fetch('assets/app.config.json')
	.then((config) => config.json())
	.then((appConf: AppConfiguration) => {
		platformBrowserDynamic([{ provide: APP_CONFIG, useValue: appConf }])
			.bootstrapModule(AppModule)
			.catch((err) => {});
	});
