public class Venda {
    int Quantidade;
    double Total;

    public void venda(Produto produto, int qnt) {
        Quantidade = qnt;
        Total = produto.preco * Quantidade;
        produto.vender(Quantidade);
    }
}