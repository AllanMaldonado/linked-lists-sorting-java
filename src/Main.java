import entities.Lista;
import entities.No;
import java.util.Scanner;

public class Main {

    static void limparTerminal() {
        // Limpa o terminal (funciona na maioria dos terminais)
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[2J\033[H");
                System.out.flush();
            }
        } catch (Exception e) {
            // Se não conseguir limpar, apenas adiciona algumas linhas em branco
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }

    static void gerarVetorAleatorio(int[] vet) {
        for (int i = 0; i < vet.length; i++) {
            vet[i] = (int) (Math.random() * 100);
        }
    }

    static void exibirMenu() {
        System.out.println("=== ALGORITMOS DE ORDENAÇÃO ===");
        System.out.println("1. Inserção Direta (insercaoDireta)");
        System.out.println("2. Seleção Direta (selecaoDireta)");
        System.out.println("3. Bubble Sort (bolha)");
        System.out.println("4. Shake Sort (shake)");
        System.out.println("5. Quick Sort sem Pivô (quickSemPivo)");
        System.out.println("6. Quick Sort com Pivô (quickComPivo)");
        System.out.println("7. Heap Sort (heap)");
        System.out.println("8. Shell Sort (shell)");
        System.out.println("9. Merge Sort 1ª Implementação (mergeSort1implementacaoLista) - Apenas múltiplos de 2");
        System.out.println("10. Merge Sort 2ª Implementação (mergeSort2implementacaoLista)");
        System.out.println("11. Counting Sort (countingSort)");
        System.out.println("12. Bucket Sort (bucketSort)");
        System.out.println("13. Radix Sort (radixSort)");
        System.out.println("14. Comb Sort (combSort)");
        System.out.println("15. Gnome Sort (gnomeSort)");
        System.out.println("16. Tim Sort (timsort)");
        System.out.println("0. Sair");
        System.out.println("=====================================");
    }

    static boolean executarAlgoritmo(Lista lista, int opcao, int[] vetorOriginal) {
        boolean sucesso = true;
        String nomeAlgoritmo = "";

        // Gera novo vetor aleatório
        gerarVetorAleatorio(vetorOriginal);

        // Para merge1, precisa ser múltiplo de 2
        if (opcao == 9) {
            // Ajusta o tamanho para ser múltiplo de 2
            int tamanho = vetorOriginal.length;
            int novoTamanho = 1;
            while (novoTamanho < tamanho) {
                novoTamanho *= 2;
            }
            int[] novoVetor = new int[novoTamanho];
            System.arraycopy(vetorOriginal, 0, novoVetor, 0, tamanho);
            // Preenche o resto com valores aleatórios
            for (int i = tamanho; i < novoTamanho; i++) {
                novoVetor[i] = (int) (Math.random() * 100);
            }
            vetorOriginal = novoVetor;
        }

        // Limpa e popula a lista
        lista.limpar();
        lista.popularComDados(vetorOriginal);

        System.out.println("\nVetor original:");
        lista.exibirEmLinha();

        long inicio = System.currentTimeMillis();

        try {
            switch (opcao) {
                case 1:
                    nomeAlgoritmo = "Inserção Direta";
                    lista.insercaoDireta();
                    break;
                case 2:
                    nomeAlgoritmo = "Seleção Direta";
                    lista.selecaoDireta();
                    break;
                case 3:
                    nomeAlgoritmo = "Bubble Sort";
                    lista.bolha();
                    break;
                case 4:
                    nomeAlgoritmo = "Shake Sort";
                    lista.shake();
                    break;
                case 5:
                    nomeAlgoritmo = "Quick Sort sem Pivô";
                    lista.quickSemPivo();
                    break;
                case 6:
                    nomeAlgoritmo = "Quick Sort com Pivô";
                    lista.quickComPivo();
                    break;
                case 7:
                    nomeAlgoritmo = "Heap Sort";
                    lista.heap();
                    break;
                case 8:
                    nomeAlgoritmo = "Shell Sort";
                    lista.shell();
                    break;
                case 9:
                    nomeAlgoritmo = "Merge Sort 1ª Implementação";
                    lista.mergeSort1implementacaoLista();
                    break;
                case 10:
                    nomeAlgoritmo = "Merge Sort 2ª Implementação";
                    lista.mergeSort2implementacaoLista();
                    break;
                case 11:
                    nomeAlgoritmo = "Counting Sort";
                    lista.countingSort();
                    break;
                case 12:
                    nomeAlgoritmo = "Bucket Sort";
                    lista.bucketSort();
                    break;
                case 13:
                    nomeAlgoritmo = "Radix Sort";
                    lista.radixSort();
                    break;
                case 14:
                    nomeAlgoritmo = "Comb Sort";
                    lista.combSort();
                    break;
                case 15:
                    nomeAlgoritmo = "Gnome Sort";
                    lista.gnomeSort();
                    break;
                case 16:
                    nomeAlgoritmo = "Tim Sort";
                    lista.timSort();
                    break;
                default:
                    return false;
            }
        } catch (Exception e) {
            System.out.println("Erro ao executar " + nomeAlgoritmo + ": " + e.getMessage());
            sucesso = false;
        }

        long fim = System.currentTimeMillis();

        System.out.println("\nVetor ordenado com " + nomeAlgoritmo + ":");
        lista.exibirEmLinha();

        boolean ordenado = lista.estaOrdenada();
        System.out.println("Status: " + (ordenado ? "ORDENADO ✓" : "NÃO ORDENADO ✗"));
        System.out.println("Tempo de execução: " + (fim - inicio) + " ms");

        return sucesso && ordenado;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lista lista = new Lista();
        int[] vetorTeste = new int[14]; // Tamanho padrão

        System.out.println("Bem-vindo ao Sistema de Testes de Algoritmos de Ordenação!");

        while (true) {
            limparTerminal();
            exibirMenu();

            System.out.print("Digite sua opção (número ou nome do método): ");
            String entrada = scanner.nextLine().trim().toLowerCase();

            int opcao = -1;

            // Tenta converter para número
            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                // Se não for número, tenta mapear pelo nome
                switch (entrada) {
                    case "insercaodireta":
                    case "insercao":
                        opcao = 1;
                        break;
                    case "selecaodireta":
                    case "selecao":
                        opcao = 2;
                        break;
                    case "bolha":
                    case "bubble":
                        opcao = 3;
                        break;
                    case "shake":
                        opcao = 4;
                        break;
                    case "quicksempivo":
                    case "quick1":
                        opcao = 5;
                        break;
                    case "quickcompivo":
                    case "quick2":
                        opcao = 6;
                        break;
                    case "heap":
                        opcao = 7;
                        break;
                    case "shell":
                        opcao = 8;
                        break;
                    case "mergesort1implementacaolista":
                    case "merge1":
                        opcao = 9;
                        break;
                    case "mergesort2implementacaolista":
                    case "merge2":
                        opcao = 10;
                        break;
                    case "countingsort":
                    case "counting":
                        opcao = 11;
                        break;
                    case "bucketsort":
                    case "bucket":
                        opcao = 12;
                        break;
                    case "radixsort":
                    case "radix":
                        opcao = 13;
                        break;
                    case "combsort":
                    case "comb":
                        opcao = 14;
                        break;
                    case "gnomesort":
                    case "gnome":
                        opcao = 15;
                        break;
                    case "timsort":
                    case "tim":
                        opcao = 16;
                        break;
                    case "sair":
                    case "exit":
                        opcao = 0;
                        break;
                    default:
                        System.out.println("Opção inválida! Pressione Enter para continuar...");
                        scanner.nextLine();
                        continue;
                }
            }

            if (opcao == 0) {
                System.out.println("Saindo do programa. Até logo!");
                break;
            }

            if (opcao < 1 || opcao > 16) {
                System.out.println("Opção inválida! Pressione Enter para continuar...");
                scanner.nextLine();
                continue;
            }

            // Executa o algoritmo
            boolean sucesso = executarAlgoritmo(lista, opcao, vetorTeste);

            if (!sucesso) {
                System.out.println("\nHouve um problema na execução do algoritmo!");
            }

            System.out.println("\nPressione Enter para continuar...");
            scanner.nextLine();
        }

        scanner.close();
    }
}