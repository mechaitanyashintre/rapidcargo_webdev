import { Component, OnInit } from '@angular/core';
import { WorkItemService } from '../work-item.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-work-item',
  templateUrl: './work-item.component.html',
  styleUrls: ['./work-item.component.css']
})
export class WorkItemComponent implements OnInit {
  title = 'Work Item Dashboard';
  workItemDetails: any = [];
  workItemToUpdate: any = {
    userId: '',
    workItemId: '',
    itemName: '',
    itemType: '',
    itemDescription: '',
    messagetoRecipient: '',
    quantity: '',
    collectionCountry: '',
    destinationCountry: '',
    originHarborLocation: '',
    selectedHarborLocations: '',
    shippingDate: '',
    amount: ''
  };

  userId: string = '';
  workItemId: string = '';
  itemName: string = '';
  itemType: string = '';
  itemDescription: string = '';
  messagetoRecipient: string = '';
  quantity: string = '';
  collectionCountry: string = '';
  destinationCountry: string = '';
  originHarborLocation: string = '';
  selectedHarborLocations: string = '';
  shippingDate: string = '';
  amount: string = '';

  constructor(private workItemService: WorkItemService) {}

  ngOnInit() {
    this.getWorkItemDetails();
  }

  register(registerForm: NgForm) {
    this.workItemService.registerWorkItem(registerForm.value).subscribe(
      (resp) => {
        console.log(resp);
        registerForm.resetForm();
        this.getWorkItemDetails();
      },
      (err) => {
        console.log(err);
      }
    );
  }

  getWorkItemDetails() {
    this.workItemService.getWorkItem().subscribe(
      (resp) => {
        console.log(resp);
        this.workItemDetails = resp;
      },
      (err) => {
        console.log(err);
      }
    );
  }

  deleteWorkItem(workItem: any) {
    this.workItemService.deleteWorkItem(workItem.workItemId).subscribe(
      (resp) => {
        console.log(resp);
        this.getWorkItemDetails();
      },
      (err) => {
        console.log(err);
      }
    );
  }

  edit(workItem: any) {
    this.workItemToUpdate = { ...workItem };
  }

  updateWorkItem() {
    this.workItemService.updateWorkItem(this.workItemToUpdate).subscribe(
      (resp) => {
        console.log(resp);
        this.getWorkItemDetails();
      },
      (err) => {
        console.log(err);
      }
    );
  }
}
