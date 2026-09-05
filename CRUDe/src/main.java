

public class main {
     Validacao validacao = new Validacao();

 public static void main(){
    produtosController produtos = new produtosController();

    produtos.coletaDados();
    produtos.listaProdutos();
    produtos.deletaProduto();
    produtos.listaProdutos();
    
    }
}
