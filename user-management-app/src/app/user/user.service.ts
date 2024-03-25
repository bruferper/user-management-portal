import { Injectable } from '@angular/core';
import { GenericService } from '../service/generic.service';
import { IUser } from './user.model';
import { NotificationService } from '../service/notification.service';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class UserService extends GenericService<IUser> {

  constructor(
    protected override notificationService: NotificationService,
    protected override http: HttpClient
    ) {
    super(notificationService, http, `${environment.HOST}/api/v1/users`);
  }

}
