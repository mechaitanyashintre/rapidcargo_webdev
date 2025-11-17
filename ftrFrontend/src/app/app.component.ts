import { AfterViewInit, Component, ElementRef, Renderer2, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from './login/login.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements AfterViewInit {
  pageTitle = 'mCart';
  loginTitle = 'Login';
  userName: string = '';

  @ViewChild('loginEl') loginVal!: ElementRef;
  @ViewChild('welcome') welcomeVal!: ElementRef;

  constructor(private loginService: LoginService, private router: Router, private renderer: Renderer2) {
    this.userName = sessionStorage.getItem('username') + '';
  }

  ngOnInit() {}

  ngAfterViewInit() {
    this.userName = this.loginService.userName;
    console.log("username:", this.userName);
    this.loginService.loginElement = this.loginVal;
    this.loginService.welcomeElement = this.welcomeVal;
  }

  login() {
    const value = this.loginVal.nativeElement.innerHTML;
    if (value === 'Login') {
      this.router.navigate(['/login']);
    } else if (value === 'Logout') {
      sessionStorage.clear();
      this.loginTitle = 'Login';
      console.log("title", this.loginTitle);
      this.renderer.setProperty(this.loginVal.nativeElement, 'innerHTML', 'Login');
      this.renderer.setStyle(this.welcomeVal.nativeElement, 'display', 'none');
      this.router.navigate(['/welcome']);
    }
  }
}
