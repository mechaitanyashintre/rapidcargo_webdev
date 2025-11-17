import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Login } from './login.model';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [LoginService]
})
export class LoginComponent implements OnInit {
  login = new Login();
  users: Login[] = [];
  valid = true;
  isLoggedIn = 'false';
  loginForm: FormGroup = new FormGroup({});
  @ViewChild('uname') userNameElement!: ElementRef;

  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private loginService: LoginService
  ) {}

  ngOnInit(): void {
    this.loginService.getUsers().subscribe(users => (this.users = users));
    this.loginForm = this.formBuilder.group({
      userName: [this.login.userName, Validators.required],
      password: [this.login.password, Validators.required]
    });
  }

  onSubmit() {
    this.valid = true;
    this.login = this.loginForm.getRawValue();
    const { userName, password } = this.login;

    const user = this.users.find(u => u.userName === userName && u.password === password);
    const adminUser = this.users.find(u => u.userName === 'admin' && u.password === 'admin');

    if (user) {
      this.isLoggedIn = 'true';
      sessionStorage.setItem('isLoggedIn', this.isLoggedIn);
      this.router.navigate(['/user']);
    } else if (adminUser) {
      this.isLoggedIn = 'true';
      sessionStorage.setItem('isLoggedIn', this.isLoggedIn);
      this.router.navigate(['/admin']);
    } else {
      this.isLoggedIn = 'false';
      sessionStorage.setItem('isLoggedIn', this.isLoggedIn);
      this.valid = false;
    }
  }
}
