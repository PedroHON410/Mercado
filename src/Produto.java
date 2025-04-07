public class Produto {
    String nome;
    double preco;
    int qntEstoque;

    public Produto(String nome, double preco, int qntEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.qntEstoque = qntEstoque;
    }

    public void addEstoque(int qnt) {
        qntEstoque += qnt;
    }

    public void vender(int qnt) {
        qntEstoque -= qnt;
    }
}
