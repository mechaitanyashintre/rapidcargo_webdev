import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { AboutUsComponent } from './about-us/about-us.component';
import { LoginComponent } from './login/login.component';
import { AppDirective } from './app.directive';
import { WeclomeComponent } from './weclome/weclome.component';
import { RegisterComponent } from './register/register.component';
import { UserRegistationService } from './user-registration.service';
import { UserComponent } from './user/user.component';
import { CreateComponent } from './create/create.component';
import { AdminComponent } from './admin/admin.component';
import { WorkItemComponent } from './work-item/work-item.component';
import { TerminalComponent } from './terminal/terminal.component';
import { VehicleComponent } from './vehicle/vehicle.component';
import { WorkitemadminComponent } from './workitemadmin/workitemadmin.component';
import { ViewdetailsComponent } from './viewdetails/viewdetails.component';
import { WelcomeComponent } from './welcome/welcome.component';

@NgModule({
  imports: [BrowserModule, HttpClientModule, ReactiveFormsModule, AppRoutingModule, FormsModule],
  declarations: [
    AppComponent,
    AboutUsComponent,
    LoginComponent,
    AppDirective,
    WeclomeComponent,
    RegisterComponent,
    UserComponent,
    CreateComponent,
    AdminComponent,
    WorkItemComponent,
    TerminalComponent,
    VehicleComponent,
    WorkitemadminComponent,
    ViewdetailsComponent,
    WelcomeComponent
  ],
  providers: [UserRegistationService],
  bootstrap: [AppComponent]
})
export class AppModule {}
