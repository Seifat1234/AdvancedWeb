import { Injectable } from '@angular/core';
import{ HttpClient } from'@angular/common/http';
import { Router } from '@angular/router';
import { Customer } from './Customer';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private baseURL = "http://localhost:8080/api/customer/";


  constructor(private httpClient:HttpClient) { }

  getEmployeesList(): Observable<Customer[]>{
    return this.httpClient.get<Customer[]>(`${this.baseURL}`);
  }

  createCustomer(customer: Customer): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`,customer);
  }


deleteCustomer(id: number): Observable<Object>{
  return this.httpClient.delete(`${this.baseURL}${id}`);
}
}
