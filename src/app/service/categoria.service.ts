import { Observable } from 'rxjs';
import { environment } from './../../environments/environment.prod';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Categoria } from '../model/Categoria';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

  constructor(private http: HttpClient) { }

  token = {
    headers: new HttpHeaders().set('Authorization', environment.token)
  }

  buscarTodos(): Observable<Categoria[]>{
    return this.http.get<Categoria[]>('https://appborboletas.herokuapp.com/categoria', this.token)
  }

  salvarCategoria(categoria: Categoria): Observable<Categoria>{
    return this.http.post<Categoria>('https://appborboletas.herokuapp.com/categoria/criar', categoria, this.token)
  }

}
