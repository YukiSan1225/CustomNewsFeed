import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { User } from '../model/user.model';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.scss']
})
export class ContactComponent implements OnInit {

  users: User[];

  constructor(private route : Router, private service : UserService) { }

  ngOnInit() {
    this.service.getUsers()
    .subscribe(data => {
      this.users = data;
    });  
  }
}
