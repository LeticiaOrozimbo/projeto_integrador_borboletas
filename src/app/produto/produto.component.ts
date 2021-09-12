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
  selector: 'app-produto',
  templateUrl: './produto.component.html',
  styleUrls: ['./produto.component.css']
})
export class ProdutoComponent implements OnInit {

  produto: Produto = new Produto()
  listaProduto: Produto[]
  

  nomeProduto: string
  // descricaoProduto: string
  precoProduto: number
  quantidadeProduto: number
  fotoProduto: string
  descricaoProduto: string

  idCategoria: number
  
  categoria: Categoria = new Categoria()
  listaCategoria: Categoria[]
  nomeCategoria: string

  usuario: Usuario = new Usuario()
  idUsuario:number;

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
    this.idUsuario = environment.id
    this.buscarTodosProdutos()
    this.buscarTodosCategoria()

    if (environment.token == '') {
      this.router.navigate(['/entrar'])
    }
  }

  /**
   * Metodo para buscar todos os produtos
   */
  buscarTodosProdutos() {
    this.produtoService.buscarTodosProdutos().subscribe((resp: Produto[]) => {
      this.listaProduto = resp
    })
  }

  bucarPorId() {
    if (this.nomeProduto == '') {
   
    } else {
      this.produtoService.buscarPorNome(this.nomeProduto).subscribe((resp: Produto[]) => {
        this.listaProduto = resp
      })
    }
  }

  /**
   * Metodo para buscar todas as categorias
   */
  buscarTodosCategoria() {
    this.categoriaService.getAllCategoria().subscribe((resp: Categoria[]) => {
      this.listaCategoria = resp
    })
  }

  findByIdCategoria(){
    this.categoriaService.getByIdCategoria(this.idCategoria).subscribe((resp: Categoria) =>{
      this.categoria = resp
      console.log("tema por id"+ JSON.stringify(this.categoria))
    })
  }

  criandoProduto() {
    this.categoria.id = this.idCategoria
    this.produto.categoria = this.categoria

    this.usuario.id = this.idUsuario;
    this.produto.criador = this.usuario

console.log("this.idCategoria "+this.idCategoria)
    console.log("produto "+JSON.stringify(this.produto))
    this.produtoService.criandoProduto(this.produto).subscribe((resp: Produto) => {
      this.produto = resp
      alert('produto atualizada com sucesso!')
      this.router.navigate(['/produto'])
      this.produto = new Produto()
      this.buscarTodosProdutos()
    })
  }

}