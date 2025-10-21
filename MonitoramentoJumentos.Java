import java.util.Scanner;

public class MonitoramentoJumentos {

    // Função que calcula a taxa de redução da população
    public static double calcularTaxaReducao(int popInicial, int popAtual) {
        double proporcao = (double) popAtual / popInicial;
        double reducao = (1 - proporcao) * 100;
        return reducao;
    }

    // Verifica se a espécie está em risco crítico
    public static boolean emRiscoCritico(double taxaReducao) {
        return taxaReducao >= 90;
    }

    // Simula o impacto dos abates ao longo dos anos
    public static int simularAbates(int popAtual, int abatesPorAno, int anos) {
        int restante = popAtual - (abatesPorAno * anos);
        return restante;
    }

    // Mostra o resultado final da simulação
    public static void mostrarResultado(int restante, int anos) {
        System.out.println("\n--- RESULTADO FINAL ---");
        if (restante <= 0) {
            System.out.println("Depois de " + anos + " anos, a população chegou a zero!");
            System.out.println("A espécie estaria extinta!");
        } else {
            System.out.println("Após " + anos + " anos restariam cerca de " + restante + " jumentos.");
            System.out.println("Ainda há tempo para ações de preservação!");
        }
        System.out.println("\nSimulação encerrada.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int popInicial = 1400000;
        int popAtual = 84000;
        int abatesPorAno = 50000;

        System.out.println("=== MONITORAMENTO DOS JUMENTOS DO NORDESTE ===");
        System.out.println("População inicial: " + popInicial);
        System.out.println("População atual: " + popAtual);
        System.out.println("Abates anuais (estimados): " + abatesPorAno);

        double taxa = calcularTaxaReducao(popInicial, popAtual);
        System.out.printf("\nTaxa de redução: %.2f%%\n", taxa);

        if (emRiscoCritico(taxa)) {
            System.out.println("Espécie em risco crítico (redução acima de 90%)!");
        } else {
            System.out.println("Situação sob controle, mas ainda requer atenção.");
        }

        System.out.print("\nQuantos anos você quer simular os abates? ");
        int anos = sc.nextInt();

        int restante = simularAbates(popAtual, abatesPorAno, anos);

        mostrarResultado(restante, anos);

        sc.close();
    }
}
