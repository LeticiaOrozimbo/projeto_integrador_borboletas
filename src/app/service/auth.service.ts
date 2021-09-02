import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../model/Usuario';
import { UsuarioDTO } from '../model/UsuarioDTO';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  entrar(usuario: UsuarioDTO): Observable<UsuarioDTO> {
    return this.http.post<UsuarioDTO>('https://bloggenturma28.herokuapp.com/usuarios/logar', usuario)
  }
  cadastrar(cadastrar: Usuario):Observable<Usuario> {
    return this.http.post<Usuario>('https://bloggenturma28.herokuapp.com/usuarios/cadastrar', cadastrar)

  }
}
