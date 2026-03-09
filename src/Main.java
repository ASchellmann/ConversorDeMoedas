import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(
                "Exemplos de cógidos de moedas:\nARS - Peso argentino\nBOB - Boliviano boliviano\nBRL - Real brasileiro\nCLP - Peso chileno\nCOP - Peso colombiano\nUSD - Dólar americano\n");
        System.out.print("Caso conheça outro código além dos exemplos, pode testar, mas não há garantias de funcionar.\n");
        System.out.print("Digite o código da moeda de origem: ");
        String from = scanner.nextLine().toUpperCase();
        System.out.print("Digite o código da moeda de destino: ");
        String to = scanner.nextLine().toUpperCase();
        System.out.print("Digite o valor a converter: ");
        double quantidade = scanner.nextDouble();
        double valorConvertido = ApiClient.getConvertedAmount(from, to, quantidade);
        if (valorConvertido >= 0) {
            System.out.printf("%.2f %s = %.2f %s%n", quantidade, from, valorConvertido, to);
        } else {
            System.out.println("Não foi possível obter a taxa de conversão.");
        }
        scanner.close();
    }
}