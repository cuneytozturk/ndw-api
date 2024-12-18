import { bootstrapApplication } from '@angular/platform-browser';
import { MapComponent } from './app/map/map.component';
import { provideHttpClient } from '@angular/common/http';

bootstrapApplication(MapComponent, {
  providers: [provideHttpClient()],
}).catch((err) => console.error(err));
