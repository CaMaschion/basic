package com.example.basic

import android.os.Parcel
import android.os.Parcelable

//passando objetos em Intents: para passar objetos entre activities, a classe do objeto que queremos
//passar via intent deve implementar a interface android.os.Parcelable que contem os métodos:

class Cliente(var codigo: Int, var nome: String): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!
    ) {
    }
//para serializar(transformar em butes) os atributos da classe
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(codigo)
        parcel.writeString(nome)
    }
//servirá de identificador único dessa classe
    override fun describeContents(): Int {
        return 0
    }
//responsável por criar o objeto a partir de um Parcel para deserializá-lo
    //em Kotlin os atributos e métodos de classe (static Java) devem ser declarados
    //dentro de um bloco chamado companion object
    companion object CREATOR : Parcelable.Creator<Cliente> {
        override fun createFromParcel(parcel: Parcel): Cliente {
            return Cliente(parcel)
        }

        override fun newArray(size: Int): Array<Cliente?> {
            return arrayOfNulls(size)
        }
    }
}