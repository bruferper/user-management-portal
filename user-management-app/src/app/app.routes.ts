import { Routes } from '@angular/router';
import { RoleComponent } from './role/role.component';
import { UserComponent } from './user/user.component';

export const routes: Routes = [
    { path: 'roles', component: RoleComponent },
    { path: 'users', component: UserComponent },
];
