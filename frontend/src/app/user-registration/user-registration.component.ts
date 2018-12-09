import { Component, OnInit } from '@angular/core';
import { User } from 'src/models';
import { UserService } from 'src/services/user.service';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {

  user: User = new User();
  constructor(private userService: UserService) { }

  ngOnInit() {
  }
  addUser(){

    this.userService.saveUser(this.user).subscribe(data => {
      alert('dodano');
    });
  }
}
