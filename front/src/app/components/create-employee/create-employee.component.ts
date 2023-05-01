import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from 'src/app/employee';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit{

  employee: Employee = new Employee();

  constructor(private service: EmployeeService, private router: Router){}

  ngOnInit(): void {
    
  }

  onSubmit(){
    this.service.createEmployee(this.employee).subscribe({
      next: (data) => {
        console.log(data);
      },
      error: (error) => {
        console.log(error);
      }
    });

  }

  
  goToEmployeeList(){
    this.router.navigate(['/employees'])
  }

}
