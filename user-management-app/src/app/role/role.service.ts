import { Injectable } from '@angular/core';
import { GenericService } from '../service/generic.service';
import { IRole } from './role.model';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment.development';
import { NotificationService } from '../service/notification.service';

@Injectable({
  providedIn: 'root'
})
export class RoleService extends GenericService<IRole> {

  constructor(
    protected override notificationService: NotificationService,
    protected override http: HttpClient
    ) {
    super(notificationService, http, `${environment.HOST}/api/v1/roles`);
  }

}
