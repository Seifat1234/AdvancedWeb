import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import { HomeComponent } from './component/home/home.component';
import { NavigationComponent } from './component/navigation/navigation.component';
import { CustomerComponent } from './component/customer/customer.component';
import { ContactComponent } from './component/contact/contact.component';
import { CustomersComponent } from './component/customers/customers.component';
import { SearchEmailComponent } from './component/search-email/search-email.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    NavigationComponent,
    CustomerComponent,
    ContactComponent,
    CustomersComponent,
    SearchEmailComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
