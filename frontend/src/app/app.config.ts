import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { providePrimeNG } from 'primeng/config';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import Aura from '@primeng/themes/aura';
import {authHttpInterceptorFn, provideAuth0} from '@auth0/auth0-angular';
import {provideHttpClient, withInterceptors} from '@angular/common/http';
import {environment} from '../environments/environment';

export const appConfig: ApplicationConfig = {
  providers: [
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    provideAnimationsAsync(),
    providePrimeNG({
      ripple: true,
      theme: {
        preset: Aura,
      }
    }),
    provideAuth0({
      domain: environment.auth0.domain,
      clientId: environment.auth0.clientId,
      authorizationParams: {
        redirect_uri: window.location.origin,
        /*audience: 'https://api.sctools.swiss-commerce.io',*/
      },

      // Specify configuration for the interceptor
      httpInterceptor: {
        allowedList: [
          {
            uri: environment.api.serverUrl + '/api/*'
          }
        ]
      }
    }),
    provideHttpClient(withInterceptors([authHttpInterceptorFn])),
  ]
};
