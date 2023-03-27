package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel
import pt.ulusofona.cm.kotlin.challenge.pt.ulusofona.cm.kotlin.challenge.exceptions.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.pt.ulusofona.cm.kotlin.challenge.exceptions.exceptions.VeiculoLigadoException

class Motor(val cavalos: Int, val cilindrada: Int): Ligavel {

    var ligado : Boolean = false

    override fun toString(): String {
        return "Motor | ${this.cavalos} | ${this.cilindrada}"
    }

    override fun ligar() {
        if (ligado) {
            throw VeiculoLigadoException()
        }
        this.ligado = true
    }

    override fun desligar() {
        if (ligado) {
            throw VeiculoDesligadoException()
        }
        this.ligado = false
    }

    override fun estaLigado(): Boolean {
        return ligado
    }

}