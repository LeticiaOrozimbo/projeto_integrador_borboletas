import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { Produto } from '../model/Produto';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  constructor(
    private http: HttpClient,

  ) { }

  token = {headers: new HttpHeaders().set('Authorization', environment.token) } 

  buscarTodosProdutos(): Observable<Produto[]>{
    return this.http.get<Produto[]>('https://borboletas.herokuapp.com/produto', this.token)
  }

  bucarPorId(id: number): Observable<Produto>{
    return this.http.get<Produto>(`https://borboletas.herokuapp.com/produto/${id}`, this.token)
  }

  buscarPorNome(nome: string): Observable<Produto[]>{
    return this.http.get<Produto[]>(`https://borboletas.herokuapp.com/produto/nome/${nome}`, this.token)
  }

  criandoProduto(produto: Produto) : Observable<Produto>{
    return this.http.post<Produto>('https://borboletas.herokuapp.com/produto/criar', produto, this.token)
  }

  atualizarProduto(produto: Produto): Observable<Produto>{
    return this.http.put<Produto>('https://borboletas.herokuapp.com/produto/atualizar', produto, this.token)
  }

  deletarPorId(id: number){
    return this.http.delete(`https://borboletas.herokuapp.com/produto/${id}`, this.token)
  }

}