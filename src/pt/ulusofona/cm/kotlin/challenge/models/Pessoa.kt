package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import pt.ulusofona.cm.kotlin.challenge.pt.ulusofona.cm.kotlin.challenge.exceptions.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.pt.ulusofona.cm.kotlin.challenge.exceptions.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.pt.ulusofona.cm.kotlin.challenge.exceptions.exceptions.VeiculoNaoEncontradoException
import java.text.SimpleDateFormat
import java.util.Date
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Period

class Pessoa(var nome: String, var dataDeNascimento: Date) : Movimentavel {

    var veiculos : MutableList<Veiculo> = mutableListOf()
    var carta : Carta? = null
    var posicao : Posicao = Posicao(0,0)


    fun comprarVeiculo(veiculo: Veiculo) { veiculos.add(veiculo) }

    fun pesquisarVeiculo(identificador: String): Veiculo { return veiculos.find { it.identificador == identificador } ?: throw VeiculoNaoEncontradoException() }

    fun venderVeiculo(identificador: String, comprador: Pessoa): Veiculo {
        val data = Date()
        val veiculo = pesquisarVeiculo(identificador)
        veiculos.remove(veiculo)
        veiculo.dataDeAquisicao = data
        comprador.comprarVeiculo(veiculo)
        return veiculo
    }

    fun moverVeiculoPara(identificador: String, x: Int, y: Int) {
        if (carta == null) {
            throw PessoaSemCartaException("${this.nome} não tem carta para conduzir o veículo indicado")
        }
        for (veiculo in veiculos) {
            if (veiculo.identificador == identificador) {
                moverPara(x,y)
                veiculos[veiculos.indexOf(veiculo)].moverPara(x,y)
            }
        }
    }

    fun temCarta(): Boolean { return carta!= null }

    fun tirarCarta() {
        val idade = LocalDate.now().year - dataDeNascimento.year
        if (idade >= 18 && carta == null){
            carta = Carta()
            return
        }
        throw MenorDeIdadeException()
    }

    override fun moverPara(x: Int, y: Int) {
        posicao.x = x
        posicao.y = y
    }

    override fun toString(): String {
        return "Pessoa | ${this.nome} | ${SimpleDateFormat("dd-MM-yyyy").format(this.dataDeNascimento)} | Posicao | x:${this.posicao.x} | y:${this.posicao.y}"
    }

}