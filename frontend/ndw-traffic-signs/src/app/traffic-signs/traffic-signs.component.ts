import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MapComponent } from '../map/map.component';
import { TrafficSignsService } from '../traffic-signs.service';

@Component({
  selector: 'app-traffic-signs',
  templateUrl: './traffic-signs.component.html',
  imports: [CommonModule, MapComponent],
  styleUrls: ['./traffic-signs.component.css']
})
export class TrafficSignsComponent implements OnInit {
  trafficSigns: any[] = [];  

  constructor(private trafficSignsService: TrafficSignsService) { }

  ngOnInit(): void {
    this.trafficSignsService.getTrafficSigns().subscribe(
      data => this.trafficSigns = data.features,
      error => console.error('Error fetching traffic signs data', error)
    );
  }
}
