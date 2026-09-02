import java.util.Scanner;

public class validacao{

  Scanner scanner = new
  Scanner(System.in);
 
  public String validarString(String texto) {

    while (true){ 
       
       System.out.println(texto);
       String resposta = scanner.nextLine().trim();

       if (!resposta.isEmpty()) {
        return resposta;

      } else { System.out.println("Entrada invalida. por Favor, digite novamente.");
    }
  }
 }


  public int ValidarInt(String resposta) {

    while (true) {

       try {

       System.out.println(resposta);
       int numero = scanner.nextInt();

         if(numero > 0){

         return numero;
        
          } else { System.out.println(" Digite o número inteiro Positivo ");
         
        }
      }

         catch (Exception e) {

         System.out.println(" Entrada inválida , por favor , digite novamente ");
         
         scanner.nextLine();

        }

    }

  }
    
}