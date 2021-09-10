import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { UsuarioDTO } from '../model/UsuarioDTO';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  usuarioDTO: UsuarioDTO = new UsuarioDTO()

  constructor(
    private auth: AuthService,
    private router: Router
  ) { }


  ngOnInit() {
    window.scroll(0, 0)

    // TESTE PARA FOTO (EXCLUIR) 
    // environment.foto = this.usuarioDTO.foto
    // console.log(environment.token)
    // console.log(environment.foto);
    // console.log(this.usuarioDTO.foto);

  }

  // TESTE PARA FOTO (EXCLUIR) 
  // entrar(){
  //   this.auth.entrar(this.usuarioDTO).subscribe((resp: UsuarioDTO)=> {
  //     this.usuarioDTO = resp

  //     environment.token = this.usuarioDTO.token

  //     environment.nome = this.usuarioDTO.nome

  //     environment.foto = this.usuarioDTO.foto

  //     environment.id = this.usuarioDTO.id

  //     console.log(environment.token)

  //     console.log(environment.nome)

  //     console.log(environment.foto)

  //     console.log(environment.id)

  //     this.router.navigate(['/inicio'])
  //   }, erro =>{
  //     if(erro.status == 500){
  //       alert('Usuário ou senha estão incorretos!')
  //     }
  //   })
  // }

}
