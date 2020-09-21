import { Component, OnInit } from '@angular/core';
import { RegistrationService } from '../registration.service';
import { Router } from '@angular/router';
import { Details } from '../details';
import { Observable } from "rxjs";

@Component({
  selector: 'app-loginsuccess',
  templateUrl: './loginsuccess.component.html',
  styleUrls: ['./loginsuccess.component.css']
})
export class LoginsuccessComponent implements OnInit {

  _detailslist : Observable<Details[]>;
  username:String;
  constructor(private _service:RegistrationService,private _route:Router) { }

  ngOnInit(): void {
    this.reloadData();
  }
  reloadData() {
    this._detailslist = this._service.getUserDetails();
  }
  getuserDetailsByUsername(){
    this._detailslist =this._service.getUserDetailsByUsername(this.username);
  }
}
