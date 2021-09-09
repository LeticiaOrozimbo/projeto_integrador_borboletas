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

    this.findAllCategorias()  
  }

  // buscarTodos(){
  //   this.categoriaService.buscarTodos().subscribe((resp: Categoria[]) => {
  //     this.listaCategorias = resp
  //     console.log("lista de categoria"+ JSON.stringify(this.listaCategorias))
  //   })
  // }

  // salvarCategoria(){
  //   console.log("cadastrar categoria"+ JSON.stringify(this.categoria))
  //    this.categoriaService.salvarCategoria(this.categoria).subscribe((resp: Categoria)=>{
  //      this.categoria = resp
  //      alert('Categoria cadastrada com sucesso!')
  //      this.buscarTodos()
  //      this.categoria = new Categoria()
  //    })
  // }

  findAllCategorias(){
    this.categoriaService.getAllCategoria().subscribe((resp: Categoria[]) => {
      this.listaCategorias = resp
      console.log("lista de categoria"+ JSON.stringify(this.listaCategorias))
    })
  }

  cadastrar(){
    console.log("cadastrar categoria"+ JSON.stringify(this.categoria))
     this.categoriaService.postCategoria(this.categoria).subscribe((resp: Categoria)=>{
       this.categoria = resp
       alert('Categoria cadastrada com sucesso!')
       this.findAllCategorias()
       this.categoria = new Categoria()
     })
  }

}