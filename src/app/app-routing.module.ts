import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastrarComponent } from './cadastrar/cadastrar.component';
import { CategoriaComponent } from './categoria/categoria.component';
import { CategoriaDeleteComponent } from './delete/categoria-delete/categoria-delete.component';
import { ProdutoDeleteComponent } from './delete/produto-delete/produto-delete.component';
import { CategoriaEditComponent } from './edit/categoria-edit/categoria-edit.component';
import { ProdutoEditComponent } from './edit/produto-edit/produto-edit.component';
import { EntrarComponent } from './entrar/entrar.component';
import { InicioComponent } from './inicio/inicio.component';
import { ProdutoComponent } from './produto/produto.component';

const routes: Routes = [
  {path: '', redirectTo: 'inicio', pathMatch: 'full'},

  { path: 'entrar', component: EntrarComponent},
  { path: 'cadastrar', component: CadastrarComponent},
  { path: 'inicio', component: InicioComponent},
  { path: 'categorias', component: CategoriaComponent},
  { path: 'categoria-edit/:id', component: CategoriaEditComponent},
  { path: 'categoria-delete/:id', component: CategoriaDeleteComponent},
  { path: 'produto', component: ProdutoComponent },
  { path: 'produto-edit/:id', component: ProdutoEditComponent},
  { path: 'produto-delete/:id', component: ProdutoDeleteComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
