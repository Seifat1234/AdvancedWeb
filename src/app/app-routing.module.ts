import {Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NavigationComponent } from './component/navigation/navigation.component';
import { LoginComponent} from './component/login/login.component';
import { HomeComponent} from './component/home/home.component';
import { CustomerComponent} from './component/customer/customer.component';
import { ContactComponent} from './component/contact/contact.component';
import { CustomersComponent } from './component/customers/customers.component';
import { search-emailComponent } from './component/search-email/search-email.Component';





const routes: Routes = [
  {path:'',component:LoginComponent},
  {path:'navigation',component:NavigationComponent,children:[
  {path:'home',component:HomeComponent},
  {path:'customers',component:CustomersComponent},
  {path:'customer',component:CustomerComponent},
  {path:'contact',component:ContactComponent},
  {path:'search-email',component:search-emailComponent},
  ]} 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
