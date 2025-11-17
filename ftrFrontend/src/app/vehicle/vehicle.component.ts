import { Component } from '@angular/core';
import { VehicleService } from '../vehicle.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-vehicle',
  templateUrl: './vehicle.component.html',
  styleUrls: ['./vehicle.component.css']
})
export class VehicleComponent {
  title = 'Work Item DashBoard';
  vehicleDetails: any = [];
  vehicleToUpdate = {
    vehicleNumber: '',
    vehicleName: '',
    capacity: '',
    maxLiftingCapacity: '',
    retireDate: '',
    vehicleStatus: '',
    harborLocation: '',
    country: ''
  };

  constructor(private vehicleService: VehicleService) {
    this.getVehicleDetails();
  }

  register(registerForm: NgForm) {
    this.vehicleService.registerVehicle(registerForm.value).subscribe(
      (resp) => {
        console.log(resp);
        registerForm.reset();
        this.getVehicleDetails();
      },
      (err) => console.log(err)
    );
  }

  getVehicleDetails() {
    this.vehicleService.getVehicle().subscribe(
      (resp) => (this.vehicleDetails = resp),
      (err) => console.log(err)
    );
  }

  deleteVehicle(vehicle: any) {
    this.vehicleService.deleteVehicle(vehicle.vehicleNumber).subscribe(
      () => this.getVehicleDetails(),
      (err) => console.log(err)
    );
  }

  edit(vehicle: any) {
    this.vehicleToUpdate = { ...vehicle };
  }

  updateVehicle() {
    this.vehicleService.updateVehicle(this.vehicleToUpdate).subscribe(
      (resp) => console.log(resp),
      (err) => console.log(err)
    );
  }
}
