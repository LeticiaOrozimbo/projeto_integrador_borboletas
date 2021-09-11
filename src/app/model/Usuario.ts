import { Produto } from "./Produto"

export class Usuario{
    public id: number
    public nome: string
    public senha: string
    public email: string
    public tipo: string
    public foto: string
    public produtos: Produto[]
    
}