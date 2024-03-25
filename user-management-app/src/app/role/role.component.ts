import { Component, OnInit } from '@angular/core';
import { CommonModule, NgIf, NgFor } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, Validator, Validators } from '@angular/forms';
import { IRole } from './role.model';
import { NotificationService } from '../service/notification.service';
import { RoleService } from './role.service';
import { ContentComponent } from '../layout/content/content.component';
import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';

@Component({
  selector: 'app-role',
  standalone: true,
  imports: [ReactiveFormsModule, NgFor, NgIf, ContentComponent, TableModule, ButtonModule, InputTextModule],
  templateUrl: './role.component.html',
  styleUrl: './role.component.scss'
})
export class RoleComponent implements OnInit {

  roleForm = this.formBuilder.group({
    id: [0],
    name: ['', [Validators.required, Validators.minLength(3)]]
  });

  isEdit: boolean = false;

  roles: IRole[] = [];

  constructor(
    private notificationService: NotificationService,
    private roleService: RoleService,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.getRoles();
  }

  onSave() {
    if(this.roleForm.valid) {
      if(this.isEdit) {
        this.roleService.update(this.roleForm.value.id, { id: 0, name: this.roleForm.value.name }).subscribe(data => {          
          this.notificationService.addMessage(data.message);
          this.getRoles();
          this.roleForm.reset();
        });
      } else {
        this.roleService.create({ id: 0, name: this.roleForm.value.name }).subscribe(data => {
          this.notificationService.addMessage(data.message);
          this.getRoles();
          this.roleForm.reset();
        });
      }
    }
  }

  onEdit(id: number) {
    const role: IRole = this.roles.find(role => role.id === id);
    this.roleForm.setValue({
      id: role.id,
      name: role.name
    });
    this.isEdit = true;
  }

  onDelete(id: number) {
    this.roleService.deleteById(id).subscribe(data => {
      this.notificationService.addMessage(data.message);
      this.getRoles();
    });
  }

  getRoles(): void {
    this.roleService.findAll().subscribe(data => {
      this.roles = data.body;
    });
    this.isEdit = false;
  }
  
  // Getters
  get name() {
    return this.roleForm.get('name');
  }

}
