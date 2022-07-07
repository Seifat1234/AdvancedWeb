
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/Service/customer.service';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.scss']
})
export class CustomersComponent implements OnInit {
  CreateCustomer!: FormGroup

  constructor(private customerService: CustomerService,private router:Router) { }

  ngOnInit(): void {
  this.CreateCustomer = new FormGroup({
    id: new FormControl(''),
    name: new FormControl(''),
    email: new FormControl(''),
    medicine: new FormControl(''),
  });
}

public AddtoCustomer(){
  return this.customerService.createCustomer(this.CreateCustomer.value).subscribe(data=>{
    console.log(data)
    this.gotoCustomerlist();
  });
}

  public  gotoCustomerlist(){
    this.router.navigate(['customer']);
  }

  submit(){
    console.log(this.CreateCustomer.value)
    this.AddtoCustomer();
  }
  
}
