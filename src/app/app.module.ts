import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { RodapeComponent } from './rodape/rodape.component';
import { InicioComponent } from './inicio/inicio.component';
import { ContatoComponent } from './contato/contato.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { EntrarComponent } from './entrar/entrar.component';
import { CadastrarComponent } from './cadastrar/cadastrar.component';
import { CategoriaComponent } from './categoria/categoria.component';
import { CategoriaEditComponent } from './edit/categoria-edit/categoria-edit.component';
import { CategoriaDeleteComponent } from './delete/categoria-delete/categoria-delete.component';
import { ProdutoComponent } from './produto/produto.component';
import { ProdutoDeleteComponent } from './delete/produto-delete/produto-delete.component';
import { ProdutoEditComponent } from './edit/produto-edit/produto-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    RodapeComponent,
    InicioComponent,
    ContatoComponent,
    EntrarComponent,
    CadastrarComponent,
    CategoriaComponent,
    CategoriaEditComponent,
    CategoriaEditComponent,
    CategoriaDeleteComponent,
    ProdutoComponent,
    ProdutoDeleteComponent,
    ProdutoEditComponent
    ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
