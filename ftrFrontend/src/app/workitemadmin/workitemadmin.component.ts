import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-workitemadmin',
  templateUrl: './workitemadmin.component.html',
  styleUrls: ['./workitemadmin.component.css']
})
export class WorkitemadminComponent implements OnInit {

  userId: number = 0;
  workItemId: string = '';
  itemName: string = '';
  itemType: string = '';
  itemDescription: string = '';
  mtr: number = 0;
  quant: string = '';
  srcC: string = '';
  descC: string = '';
  oHL: string = '';
  sHL: string = '';
  sd: string = '';
  amt: number = 0;

  workItemDetails: any[] = [];
  workItemToUpdate: any = {};

  constructor() { }

  ngOnInit(): void { }

  register(form: NgForm) {
    // Your register logic
  }

  edit(workItem: any) {
    this.workItemToUpdate = { ...workItem };
  }

  updateWorkItem() {
    // Your update logic
  }

  deleteworkItem(workItem: any) {
    // Your delete logic
  }
}
