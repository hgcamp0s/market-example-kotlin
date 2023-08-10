import dominio.Cliente
import dominio.NotaFiscal
import dominio.pedido.ItemPedido
import dominio.pedido.Pedido
import dominio.ProdutoFactory
import dominio.cartao.Bandeira
import dominio.cartao.Cartao
import dominio.pedido.Pagamento
import impressao.Epson
import impressao.Hp
import operadora.Cielo
import operadora.Rede

fun main(args: Array<String>) {
    val arroz = ProdutoFactory.create(nome = "Arroz", preco = 25.0)
    val leite = ProdutoFactory.create(nome = "Leite", preco = "4.0")
    val farinha = ProdutoFactory.create(nome = "farinha", preco = 4)
    val feijao = ProdutoFactory.create(nome = "Feijão", preco = 7.0)
    val joao = Cliente(nome = "João", cpf = "111.222.333-4")
    val pedido = Pedido(joao)

    val itemPedido_arroz = ItemPedido(arroz, 1)
    val itemPedido_feijao = ItemPedido(feijao, 2)

    pedido.adicionaProduto(itemPedido_arroz)
    pedido.adicionaProduto((itemPedido_feijao))

    val cartao = Cartao(
        nomeTitular = "Aurora Ribeiro da Costa",
        numero = "123123456789",
        bandeira = Bandeira.MASTERCARD
    )

    val operadora = Cielo()
    val impressora = Epson()

    val pagamento = Pagamento(operadora, impressora)


    pagamento.fechaPedido(pedido, cartao, 1234)
    impressora.imprime(NotaFiscal(pedido))


    // impressora.imprime(pedido)

    // pedido.itens.forEach {item -> println(item.produto.nome)}
    // println(cartao)
}