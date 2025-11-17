import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {
  constructor(private http: HttpClient) {}
  API = 'http://localhost:9090';

  public registerVehicle(veh: any) {
    return this.http.post(this.API + '/registerVehicle', veh);
  }

  public getVehicle() {
    return this.http.get(this.API + '/getVehicles');
  }

  public deleteVehicle(id: any) {
    return this.http.delete(this.API + '/deleteVehicle?id=' + id);
  }

  public updateVehicle(veh: any) {
    return this.http.put(this.API + '/updateVehicles', veh);
  }
}
