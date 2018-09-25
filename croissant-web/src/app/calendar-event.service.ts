import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { environment } from '../environments/environment';
import { CalendarEvent } from 'angular-calendar';

@Injectable()
export class CalendarEventService {

  constructor(private http: HttpClient) { }

  list():Observable<Array<CalendarEvent>>{
    return this.http.get<Array<CalendarEvent>>(`${environment.baseUrl}/event/list`);
  }

  create(calendarEvent):Observable<any>{
    console.log(calendarEvent);
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.post(`${environment.baseUrl}/event/create`,calendarEvent,{headers});
  }

  update(calendarEvent):Observable<any>{
    return this.http.post(`${environment.baseUrl}/event/update`,calendarEvent);
  }

  delete(calendarEvent):Observable<any>{
    return this.http.post(`${environment.baseUrl}/event/delete`,calendarEvent);
  }
}
