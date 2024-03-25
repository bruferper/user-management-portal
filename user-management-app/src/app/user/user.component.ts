import { Component, OnInit } from '@angular/core';
import { UserService } from './user.service';
import { IUser } from './user.model';
import { NgIf, NgFor } from '@angular/common';
import { RolesNamePipe } from '../role/role.pipe';
import { ContentComponent } from '../layout/content/content.component';

@Component({
  selector: 'app-user',
  standalone: true,
  imports: [NgIf, NgFor, RolesNamePipe, ContentComponent],
  templateUrl: './user.component.html',
  styleUrl: './user.component.scss'
})
export class UserComponent implements OnInit {

  users: IUser[] = [];

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers(): void {
    this.userService.findAll().subscribe(data => {
      this.users = data.body;
    });
  }

}
