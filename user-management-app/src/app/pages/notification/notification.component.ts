import { Component } from '@angular/core';
import { NotificationService } from '../../service/notification.service';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-notification',
  standalone: true,
  imports: [NgIf],
  templateUrl: './notification.component.html',
  styleUrl: './notification.component.scss'
})
export class NotificationComponent {

  constructor(public notificationService: NotificationService) {}

}
