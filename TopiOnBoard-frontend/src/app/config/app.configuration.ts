import { InjectionToken } from '@angular/core';

export const APP_CONFIG = new InjectionToken<AppConfiguration>('APP_CONFIG');

export interface AppConfiguration {
	backend: string;
	frontend: string;
	auth: {
		clientId: string;
		issuer: string;
		keyhubUrl: string;
		requireHTTPS: false;
		scope: string;
		resource: string;
	};
}
