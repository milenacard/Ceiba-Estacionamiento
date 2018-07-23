import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { RegistroEntity } from '../model/registroEntity.model';
import { Observable } from '../../../node_modules/rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  constructor(private http: HttpClient ) { }

  public getRegisters(): Observable<RegistroEntity[]> {
    return this.http.get<RegistroEntity[]>('http://localhost:8090/registro/listar');
  }
}
