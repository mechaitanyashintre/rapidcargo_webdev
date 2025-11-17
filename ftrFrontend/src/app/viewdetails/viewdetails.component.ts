import { Component, OnInit } from '@angular/core';
import { UserRegistationService } from '../user-registration.service';
import { User } from '../user';

@Component({
  selector: 'app-viewdetails',
  templateUrl: './viewdetails.component.html',
  styleUrls: ['./viewdetails.component.css']
})
export class ViewdetailsComponent implements OnInit {
  userDetails: any;
  message: any;
  user: User = new User();

  constructor(private usr: UserRegistationService) {}

  ngOnInit(): void {}

  public getD(uid: number) {
    this.usr.get(uid).subscribe((data) => (this.userDetails = data));
  }

  public deleteUser(uid: number) {
    this.usr.deleteUsers(uid).subscribe((resp) => (this.message = resp));
  }
}
