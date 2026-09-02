

public class main {

 public static void main(){
    validacao validacao = new validacao();

    String nome = validacao.validarString("qual e o seu nome?");
    System.out.println("seu nome e " + nome);

    int numero = validacao.ValidarInt(" Digite o número");
    System.out.println("o seu numero foi " + numero);

    }
}
