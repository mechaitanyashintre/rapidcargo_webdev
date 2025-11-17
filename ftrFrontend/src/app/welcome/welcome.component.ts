import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {
  constructor() { }

  ftrFacilities: string = "Fright transport region application helps to manage the overall operations in a harbour. Admin (employees of FTR) and User (Vendor) can avail this application.";
  adminServices: string = "FTR admin can manage the major details like managing terminals, loading and grounding operations etc.";
  customerServices: string = "Customer can register with FTR and request for fright transport, includes the various user specific configurations and it can be viewed using operational dashboard";

  ngOnInit(): void { }
}
