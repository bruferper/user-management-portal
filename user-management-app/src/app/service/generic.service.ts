import { Inject, Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { ApiResponse } from '../model/api-response.model';
import { catchError, retry, throwError } from 'rxjs';
import { environment } from '../../environments/environment.development';
import { NotificationService } from './notification.service';

@Injectable({
  providedIn: 'root'
})
export class GenericService<T> {

  constructor(
    protected notificationService: NotificationService,
    protected http: HttpClient,
    @Inject("url") protected url: string,
  ) { }

  findAll() {
    return this.http.get<ApiResponse<T[]>>(this.url)
      .pipe(
        retry(environment.RETRY),
        catchError(this.handleError)
      );
  }

  findById(id: number) {
    return this.http.get<ApiResponse<T>>(`${this.url}/${id}`)
      .pipe(
        retry(environment.RETRY),
        catchError(this.handleError)
      );
  }

  create(t: T) {
    return this.http.post<ApiResponse<T>>(this.url, t)
      .pipe(
        catchError(this.handleError)
      );
  }

  update(id: number, t: T) {
    return this.http.put<ApiResponse<T>>(`${this.url}/${id}`, t)
      .pipe(
        catchError(this.handleError)
      );
  }

  deleteById(id: number) {
    return this.http.delete<ApiResponse<T>>(`${this.url}/${id}`)
      .pipe(
        catchError(this.handleError)
      );
  }

  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${error.status}, body was: `, error.error);
    }
    // Return an observable with a user-facing error message.
    this.notificationService.addMessage('Something went wrong, please try again later.');
    return throwError(() => new Error('Something bad happened; please try again later.'));
  }

}
