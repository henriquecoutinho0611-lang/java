import java.util.Scanner;

public class Validacao {

    private Scanner scanner = new Scanner(System.in);

    public String validarString(String texto) {
        while (true) {
            System.out.println(texto);
            String resposta = scanner.nextLine().trim();

            if (!resposta.isEmpty()) {
                return resposta;
            } else {
                System.out.println("Entrada inválida. Por favor, digite novamente.");
            }
        }
    }

    public int validarInt(String texto) {
        while (true) {
            try {
                System.out.println(texto);
                int numero = scanner.nextInt();
                scanner.nextLine(); // Limpar buffer

                if (numero > 0) {
                    return numero;
                } else {
                    System.out.println("Digite um número inteiro positivo");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida, por favor, digite novamente");
                scanner.nextLine();
            }
        }
    }

    public void close() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
