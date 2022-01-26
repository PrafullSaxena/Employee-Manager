import { HttpErrorResponse, HttpStatusCode } from '@angular/common/http';
import { Container } from '@angular/compiler/src/i18n/i18n_ast';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Employee } from './employee';
import { EmployeeService } from './employee.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  public employees: Employee[] = [];
  public editEmployee: Employee | undefined;
  public searchString: string | undefined;
  public deleteEmployee: any;

  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.getEmployee();
  }

  public getEmployee(): void {
    this.employeeService.getEmployees().subscribe(
      (response: Employee[]) => {
        this.employees = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onCallModel(employee: any, mode: string): void {

    const container: any = document.getElementById("models");
    const button = document.createElement('button');

    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-bs-toggle', 'modal');

    if (mode === 'add') {
      button.setAttribute('data-bs-target', '#addModel');
      // alert("you click add employee");
    } else if (mode === 'edit') {
      button.setAttribute('data-bs-target', '#editModel');
      this.editEmployee = employee;
      // alert("you click edit employee");
    } else if (mode === 'delete') {
      this.deleteEmployee = employee;
      button.setAttribute('data-bs-target', '#deleteModel');
      // alert("you click delete employee");
    }

    container.appendChild(button);
    button.click();
  }

  public addEmployee(addForm: NgForm): void {

    document.getElementById("add-form-close")?.click();
    this.employeeService.addEmployees(addForm.value).subscribe(
      (response: Employee) => {
        console.log(response);
        this.getEmployee();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }


  public onUpdateEmployee(employee: Employee): void {

    document.getElementById("update-form-close")?.click();


    this.employeeService.updateEmployees(employee).subscribe(
      (response: Employee) => {
        console.log(response);
        this.getEmployee();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteCall(empId: number): void {

    document.getElementById("del-close")?.click();
    this.employeeService.deleteEmployees(empId).subscribe(
      (response: void) => {
        console.log(response);
        this.getEmployee();
      },
      (error: HttpErrorResponse) => {
        alert("Error in Delelting Employee ID - " + empId + "\n\n" + error.message);
      }
    );
  }
  public seachForEmplopyee(key: string): void {
    const results: Employee[] = [];

    for (const employee of this.employees) {

      if (key === "") {
        this.getEmployee();
      }

      if ((employee.email.toLowerCase().indexOf(key.toLowerCase()) !== -1) || (employee.jobTitle.toLowerCase().indexOf(key.toLowerCase()) !== -1) || (employee.name.toLowerCase().indexOf(key.toLowerCase()) !== -1)) {

        results.push(employee);

      }

      this.employees = results;

    }

  }

  public onCallRestView() : void {
    this.getEmployee();
  }

  public testClick(): void {
    alert("working");
  }



}
