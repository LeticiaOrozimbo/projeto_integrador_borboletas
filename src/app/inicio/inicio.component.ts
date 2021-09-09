import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Categoria } from '../model/Categoria';
import { Produto } from '../model/Produto';
import { Usuario } from '../model/Usuario';
import { AuthService } from '../service/auth.service';
import { CategoriaService } from '../service/categoria.service';
import { ProdutoService } from '../service/produto.service';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit {

  produto: Produto = new Produto()
  listaProduto: Produto[]
  nomeProduto: string

  categoria: Categoria = new Categoria()
  listaCategoria: Categoria[]
  idCategoria: number
  nomeCategoria: string

  usuario: Usuario = new Usuario()
  idUsuario = environment.id

  key = 'data'
  reverse = true

  constructor(
    private router: Router,
    private produtoService: ProdutoService,
    private categoriaService: CategoriaService,
    public authService: AuthService,
    //private alertas: AlertasService
  ) { }


  ngOnInit() {
    window.scroll(0, 0)

    if (environment.token == '') {
      this.router.navigate(['/entrar'])
    }

    this.buscarTodos()
    this.buscarTodosProdutos()

  }

  buscarTodos() {
    this.categoriaService.buscarTodos().subscribe((resp: Categoria[]) => {
      this.listaCategoria = resp
    })
  }

  // findByIdTema(){
  //   this.categoriaService.getByIdTema(this.idTema).subscribe((resp: Tema) =>{
  //     this.tema = resp
  //   })
  // }

  // findByNomeTema(){
  //   if(this.nomeTema == ''){
  //     this.getAllTemas()
  //   } else {
  //     this.temaService.getByNomeTema(this.nomeTema).subscribe((resp: Tema[]) => {
  //       this.listaTemas = resp
  //     })
  //   }
  // }

  // findByIdUser(){
  //   this.authService.getByIdUser(this.idUser).subscribe((resp: User) => {
  //     this.user = resp
  //   })


  buscarTodosProdutos() {
    this.produtoService.buscarTodos().subscribe((resp: Produto[]) => {
      this.listaProduto = resp
    })
  }

  cadastrar() {
    this.categoria.id = this.idCategoria
    this.produto.categoria = this.categoria

    this.usuario.id = this.idUsuario
    this.produto.criador = this.usuario

    this.produtoService.criandoProduto(this.produto).subscribe((resp: Produto) => {
      this.produto = resp
      this.produto = new Produto()
      this.buscarTodos()
    })
  }

  bucarPorId() {
    if (this.nomeProduto == '') {
      this.buscarTodos()
    } else {
      this.produtoService.buscarPorNome(this.nomeProduto).subscribe((resp: Produto[]) => {
        this.listaProduto = resp
      })
    }
  }

}