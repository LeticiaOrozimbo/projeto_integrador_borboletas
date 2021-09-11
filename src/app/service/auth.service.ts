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
    return this.http.put<UsuarioDTO>('https://borboletas.herokuapp.com/api/v1/usuario/autenticar', usuario)
  }
  cadastrar(cadastrar: Usuario):Observable<Usuario> {
    return this.http.post<Usuario>('https://borboletas.herokuapp.com/api/v1/usuario/cadastrar', cadastrar)

  }
}
