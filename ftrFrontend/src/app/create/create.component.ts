import { Component, OnInit } from '@angular/core';
import { StudentService } from '../student.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  title = 'Work Item DashBoard';
  studentDetails: any[] = [];
  studentToUpdate: any = {
    rollNumber: '',
    name: '',
    address: '',
    percentage: ''
  };

  constructor(private studentService: StudentService) {}

  ngOnInit(): void {
    this.getStudentsDetails();
  }

  register(registerForm: NgForm) {
    this.studentService.registerStudent(registerForm.value).subscribe(
      resp => {
        console.log(resp);
        registerForm.reset();
        this.getStudentsDetails();
      },
      err => console.log(err)
    );
  }

  getStudentsDetails() {
    this.studentService.getStudents().subscribe(
      resp => {
        console.log(resp);
        this.studentDetails = resp as any[];
      },
      err => console.log(err)
    );
  }

  deleteStudent(student: any) {
    this.studentService.deleteStudent(student.rollNumber).subscribe(
      resp => {
        console.log(resp);
        this.getStudentsDetails();
      },
      err => console.log(err)
    );
  }

  edit(student: any) {
    this.studentToUpdate = { ...student };
  }

  updateStudent() {
    this.studentService.updateStudents(this.studentToUpdate).subscribe(
      resp => console.log(resp),
      err => console.log(err)
    );
  }
}
