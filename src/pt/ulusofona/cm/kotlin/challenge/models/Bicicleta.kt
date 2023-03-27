package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.text.SimpleDateFormat

class Bicicleta(identificador: String) : Veiculo(identificador), Movimentavel {
    override fun moverPara(x: Int, y: Int) {
        posicao.x = x
        posicao.y = y
    }
    override fun toString(): String {
        return "Bicicleta | ${this.identificador} | ${SimpleDateFormat("dd-MM-yyyy").format(this.dataDeAquisicao)} | Posicao | x:${this.posicao.x} | y:${this.posicao.y}"
    }

    override fun requerCarta(): Boolean {
        return false
    }
}