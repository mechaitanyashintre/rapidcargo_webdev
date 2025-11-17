import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-about-us',
  templateUrl: './about-us.component.html',
  styleUrls: ['./about-us.component.css']
})
export class AboutUsComponent implements OnInit {
  aboutUsDetail = `Port transport is one of the major sources in International trade,
transferring large volumes of commodities and connecting countries across continents.
Efficient management of port has a direct impact on the Shipping capability of a country.
Time management, quality, safety is some of the basic parameters in the industry.`;

  constructor() {}

  ngOnInit(): void {}
}
