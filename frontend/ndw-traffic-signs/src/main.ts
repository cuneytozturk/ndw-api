import { bootstrapApplication } from '@angular/platform-browser';
import { TrafficSignsComponent } from './app/traffic-signs/traffic-signs.component';
import { provideHttpClient } from '@angular/common/http';

bootstrapApplication(TrafficSignsComponent, {
  providers: [provideHttpClient()],
}).catch((err) => console.error(err));
