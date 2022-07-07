import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { VirtualTimeScheduler } from 'rxjs';
import { Customer } from 'src/app/Service/Customer';
import { CustomerService } from 'src/app/Service/customer.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.scss']
})
export class CustomerComponent implements OnInit {

  customer!: Customer[]

  constructor(private customerService: CustomerService,private router:Router) { }
  ngOnInit(): void {
    this.getCustomer();
  }

  
  public getCustomer(){
    this.customerService.getEmployeesList().subscribe(data=>{
      console.log(data);
      this.customer=data;
    });
  }

  public deleteCustomer(id: number){
    return this.customerService.deleteCustomer(id).subscribe(data=>{
      console.log(data);
      this.getCustomer();
    })
  }

}
