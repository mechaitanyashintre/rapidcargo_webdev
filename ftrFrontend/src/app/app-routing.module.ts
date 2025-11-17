import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutUsComponent } from './about-us/about-us.component';
import { LoginComponent } from './login/login.component';
import { WeclomeComponent } from './weclome/weclome.component';
import { RegisterComponent } from './register/register.component';
import { UserComponent } from './user/user.component';
import { AdminComponent } from './admin/admin.component';
import { CreateComponent } from './create/create.component';
import { WorkItemComponent } from './work-item/work-item.component';
import { TerminalComponent } from './terminal/terminal.component';
import { VehicleComponent } from './vehicle/vehicle.component';
import { ViewdetailsComponent } from './viewdetails/viewdetails.component';
import { WorkitemadminComponent } from './workitemadmin/workitemadmin.component';

const appRoutes: Routes = [
  { path: 'about-us', component: AboutUsComponent },
  { path: 'admin', component: AdminComponent },
  { path: 'create', component: CreateComponent },
  { path: 'work-item', component: WorkItemComponent },
  { path: 'viewdetails', component: ViewdetailsComponent },
  { path: 'welcome', component: WeclomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'user', component: UserComponent },
  { path: 'terminal', component: TerminalComponent },
  { path: 'vehicle', component: VehicleComponent },
  { path: 'workitemadmin', component: WorkitemadminComponent },
  { path: '', redirectTo: '/welcome', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
