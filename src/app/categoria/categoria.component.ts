import { CategoriaService } from './../service/categoria.service';
import { Categoria } from './../model/Categoria';
import { Router } from '@angular/router';
import { environment } from './../../environments/environment.prod';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-categoria',
  templateUrl: './categoria.component.html',
  styleUrls: ['./categoria.component.css']
})
export class CategoriaComponent implements OnInit {

  categoria: Categoria = new Categoria()
  listaCategorias: Categoria[]

  constructor(
    private router: Router,
    private categoriaService: CategoriaService
  ) { }

  ngOnInit() {
    if(environment.token == ''){
      this.router.navigate(['/entrar'])
    }


    this. pesquisarTodos()
  }

  pesquisarTodos(){
    this.categoriaService.getAllCategoria().subscribe((resp: Categoria[]) => {
      this.listaCategorias = resp
      console.log("lista de categoria"+ JSON.stringify(this.listaCategorias))
    })
  }

  cadastrarCategoria(){
    console.log("cadastrar categoria"+ JSON.stringify(this.categoria))
     this.categoriaService.postCategoria(this.categoria).subscribe((resp: Categoria)=>{
       this.categoria = resp
       alert('Categoria cadastrada com sucesso!')
       this.pesquisarTodos()
       this.categoria = new Categoria()
     })
  }

}