import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  message: string = '';

  constructor() { }

  addMessage(message: string): void {
    this.message = message;
  }

  getMessage(): string {
    return this.message;
  }

  clearMessage(): void {
    this.message = '';
  }

}
