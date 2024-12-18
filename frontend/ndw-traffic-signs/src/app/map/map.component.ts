import { Component, OnInit, AfterViewInit } from '@angular/core';
import { TrafficSignsComponent } from '../traffic-signs/traffic-signs.component';
import { TrafficSignsService } from '../traffic-signs.service';
import * as L from 'leaflet';

@Component({
  selector: 'map',
  templateUrl: './map.component.html',
  imports: [TrafficSignsComponent],
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit, AfterViewInit {
  private map!: L.Map
  markers: L.Marker[] = [
  ];
  trafficSigns: any[] = [];  


  constructor(private trafficSignsService: TrafficSignsService) { }

  ngOnInit() {
    
  }

  ngAfterViewInit() {
    this.initializeMap();
    this.addTrafficSigns();

  }


  private initializeMap() {
    const baseMapURl = 'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png'
    this.map = L.map('map').setView([52.574556780879,5.5322484346456], 15);
    L.tileLayer(baseMapURl).addTo(this.map);

  }

  private addTrafficSigns(): void {
    this.trafficSignsService.getTrafficSigns().subscribe(
      (data) => {
        this.trafficSigns = data.features;
  
        this.trafficSigns.forEach((sign) => {
          const coordinates : L.LatLngTuple = [
            sign.geometry.coordinates[1], 
            sign.geometry.coordinates[0], 
          ];
          const marker = L.marker(coordinates).addTo(this.map);
          marker.bindPopup(
            `<b>RVV Code:</b> ${sign.properties.rvvCode}<br><b>Road Name:</b> ${sign.properties.roadName}`
          );
          this.markers.push(marker);
          console.log(`Marker added at: ${coordinates}`);

          
        });
      },
      (error) => {
        console.error('Error fetching traffic signs data', error);
      }
    );
  }
  
  
}