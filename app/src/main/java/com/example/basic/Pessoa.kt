package com.example.basic

import java.io.Serializable


//java.io.Serializable é uma forma mais simples de fazer a passagem de objetos entre activities
class Pessoa (var nome: String, var idade: Int) : Serializable {
}