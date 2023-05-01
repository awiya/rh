import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from 'src/app/employee';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit{
  
  employees: Employee[];

  constructor(private servcie:EmployeeService , private router: Router){

  }

  ngOnInit(): void {
    this.handlegetEmployeeList();
  }

  handlegetEmployeeList(){
      this.servcie.getEmployeeList().subscribe(data=>{
        this.employees = data;
      })
  }

  updateEmployee(id: number){
    this.router.navigate(['update-employee', id]);
  }

}
