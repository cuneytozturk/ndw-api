import { Component, OnInit, AfterViewInit } from '@angular/core';
import * as L from 'leaflet';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit, AfterViewInit {
  private map!: L.Map
  markers: L.Marker[] = [
    L.marker([31.9539, 35.9106]), // Amman
    L.marker([32.5568, 35.8469]) // Irbid
  ];

  constructor() { }

  ngOnInit() {
  }

  ngAfterViewInit() {
    this.initializeMap();
    this.addMarkers();
  }


  private initializeMap() {
    const baseMapURl = 'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png'
    this.map = L.map('map').setView([52.5746, 5.5323], 15); // Center of the map

    L.tileLayer(baseMapURl).addTo(this.map);

  }


  private addMarkers() {
    // Add your markers to the map
    this.markers.forEach(marker => marker.addTo(this.map));
  }

  
}