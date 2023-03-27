package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel
import java.text.SimpleDateFormat

class Carro(identificador: String, var motor: Motor) : Veiculo(identificador), Ligavel {
    override fun toString(): String {
        return "Carro | ${this.identificador} | ${SimpleDateFormat("dd-MM-yyyy").format(this.dataDeAquisicao)} | Posicao | x:${this.posicao.x} | y:${this.posicao.y}"
    }
    override fun ligar() {
        motor.ligar()
    }
    override fun desligar() {
        motor.desligar()
    }
    override fun estaLigado(): Boolean {
        return motor.estaLigado()
    }

    override fun requerCarta(): Boolean {
        return true
    }
}