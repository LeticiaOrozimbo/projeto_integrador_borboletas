import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Produto } from '../model/Produto';
import { ProdutoService } from '../service/produto.service';

@Component({
  selector: 'app-comprar',
  templateUrl: './comprar.component.html',
  styleUrls: ['./comprar.component.css']
})
export class ComprarComponent implements OnInit {

  // listaProduto: Produto[]
  produto: Produto = new Produto()
  idProduto: number

  constructor(
    private produtoService: ProdutoService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {

    if (environment.token == '') {
      this.router.navigate(['/entrar'])
    }

    this.idProduto = this.route.snapshot.params['id']
    this.findByIdCategoria(this.idProduto)

  }


  findByIdCategoria(id: number) {
    this.produtoService.bucarPorId(id).subscribe((resp: Produto) => {
      this.produto = resp
    })
  }

}
