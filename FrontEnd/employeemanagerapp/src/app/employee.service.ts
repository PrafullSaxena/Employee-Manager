import { Injectable } from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import { Observable } from 'rxjs';
import { Employee } from './employee';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http : HttpClient) { }

  /* GET Request that returns all the employees  */
  public getEmployees() : Observable<Employee[]> {
    return this.http.get<Employee[]>(`${this.apiServerUrl}/employee/all`);
  }

  /* POST Request that adds a employee  */
  public addEmployees(employee: Employee): Observable<Employee>{
    return this.http.post<Employee>(`${this.apiServerUrl}/employee/add`, employee)
  }

  /* PUT Request that update the given employee  */
  public updateEmployees(employee: Employee): Observable<Employee>{
      return this.http.put<Employee>(`${this.apiServerUrl}/employee/update`, employee)
  }

  /* DELETE Request that delete the given employee with the ID  */
  public deleteEmployees(employeeId: number): Observable<void>{
      return this.http.delete<void>(`${this.apiServerUrl}/employee/delete/${employeeId}`)
  }

}
