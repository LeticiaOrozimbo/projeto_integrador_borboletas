import { Component, OnInit } from '@angular/core';
import { Produto } from '../model/Produto';
import { ProdutoService } from '../service/produto.service';

@Component({
  selector: 'app-todos-produtos',
  templateUrl: './todos-produtos.component.html',
  styleUrls: ['./todos-produtos.component.css']
})
export class TodosProdutosComponent implements OnInit {

  listaProduto: Produto[]
  nomePost: string
  
  constructor(
    private produtoService: ProdutoService,
  ) { }

  ngOnInit(): void {
    this.buscarTodosProdutos();
  }

   buscarTodosProdutos() {
    this.produtoService.buscarTodosProdutos().subscribe((resp: Produto[]) => {
      this.listaProduto = resp
       console.log("lista produto" + this.listaProduto)
     })
   }
  findByNome(){
    if(this.nomePost == ''){
      this.buscarTodosProdutos()
    } else {
      this.produtoService.buscarPorNome(this.nomePost).subscribe((resp: Produto[]) => {
        this.listaProduto = resp
      })
    }
  }



}
