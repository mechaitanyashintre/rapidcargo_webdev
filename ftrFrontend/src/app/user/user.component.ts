import { Component, OnInit, ElementRef, Renderer2 } from '@angular/core';
import usersdb from '../usersdb.json';
import { LoginService } from 'src/app/login/login.service';

interface Student {
  id: number;
  name: string;
  email: string;
  gender: string;
}

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  loginElement!: ElementRef;
  welcomeElement!: ElementRef;
  welcomeVal!: ElementRef;
  students: Student[] = usersdb;

  constructor(private loginService: LoginService, private renderer: Renderer2) {}

  ngOnInit(): void {}

  ngAfterViewInit() {
    this.loginElement = this.loginService.loginElement;
    this.welcomeElement = this.loginService.welcomeElement;

    this.renderer.setProperty(this.loginElement.nativeElement, 'innerHTML', 'Logout');
    this.renderer.setProperty(this.welcomeElement.nativeElement, 'innerHTML', this.loginService.userName);
    this.renderer.setStyle(this.welcomeElement.nativeElement, 'display', '');
    this.renderer.setStyle(this.welcomeElement.nativeElement, 'color', '#ff0080');
  }
}
