import { Component, OnInit } from '@angular/core';
import { TerminalService } from '../terminal-service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-terminal',
  templateUrl: './terminal.component.html',
  styleUrls: ['./terminal.component.css']
})
export class TerminalComponent implements OnInit {

  title = 'Work Item Dashboard';
  terminalDetails: any;

  terminalToUpdate: any = {
    TerminalId: "",
    TerminalName: "",
    Country: "",
    ItemType: "",
    TerminalDescription: "",
    Capacity: "",
    Status: "",
    HarbourLocation: "",
    AvailableCapacity: ""
  };

  constructor(private terminalService: TerminalService) {}

  ngOnInit(): void {
    this.getTerminalDetails();
  }

  register(registerForm: NgForm) {
    this.terminalService.registerTerminal(registerForm.value).subscribe(
      (resp) => {
        console.log(resp);
        registerForm.reset();
        this.getTerminalDetails();
      },
      (err) => {
        console.log(err);
      }
    );
  }

  getTerminalDetails() {
    this.terminalService.getTerminal().subscribe(
      (resp) => {
        console.log(resp);
        this.terminalDetails = resp;
      },
      (err) => {
        console.log(err);
      }
    );
  }

  deleteTerminal(terminal: any) {
    this.terminalService.deleteTerminal(terminal.TerminalId).subscribe(
      (resp) => {
        console.log(resp);
        this.getTerminalDetails();
      },
      (err) => {
        console.log(err);
      }
    );
  }

  edit(terminal: any) {
    this.terminalToUpdate = { ...terminal };
  }

  updateTerminal() {
    this.terminalService.updateTerminal(this.terminalToUpdate).subscribe(
      (resp) => {
        console.log(resp);
        this.getTerminalDetails();
      },
      (err) => {
        console.log(err);
      }
    );
  }
}