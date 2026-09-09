import controller.Controller;
import repositoty.Banco;
import validacao.Validacao;

public class Main {
     Validacao validacao = new Validacao();

 public static void main(String[] args){
    Controller produtos = new Controller();
    Banco banco = new Banco();
    banco.lista();
    produtos.coletaDados();
    banco.lista();
 }
}