

public class Main {
     Validacao validacao = new Validacao();

 public static void main(){
    produtosController produtos = new produtosController();
    Banco  banco = new Banco();
    banco.lista();
    produtos.coletaDados();
    banco.lista();
 }
}