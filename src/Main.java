import entities.Lista; 
import java.util.Scanner;

public class Main {

    static void limparTerminal() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[2J\033[H");
                System.out.flush();
            }
        } catch (Exception e) {
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

        gerarVetorAleatorio(vetorOriginal);

        if (opcao == 9) {
            int tamanho = vetorOriginal.length;
            int novoTamanho = 1;
            while (novoTamanho < tamanho) {
                novoTamanho *= 2;
            }
            int[] novoVetor = new int[novoTamanho];
            System.arraycopy(vetorOriginal, 0, novoVetor, 0, tamanho);
            for (int i = tamanho; i < novoTamanho; i++) {
                novoVetor[i] = (int) (Math.random() * 100);
            }
            vetorOriginal = novoVetor;
        }

        lista.limpar();
        lista.popularComDados(vetorOriginal);

        System.out.println("\nVetor original:");
        lista.exibirEmLinha();

        long inicio = System.currentTimeMillis();

        try {
            switch (opcao) {
                case 1 -> {
                    nomeAlgoritmo = "Inserção Direta";
                    lista.insercaoDireta();
                }
                case 2 -> {
                    nomeAlgoritmo = "Seleção Direta";
                    lista.selecaoDireta();
                }
                case 3 -> {
                    nomeAlgoritmo = "Bubble Sort";
                    lista.bolha();
                }
                case 4 -> {
                    nomeAlgoritmo = "Shake Sort";
                    lista.shake();
                }
                case 5 -> {
                    nomeAlgoritmo = "Quick Sort sem Pivô";
                    lista.quickSemPivo();
                }
                case 6 -> {
                    nomeAlgoritmo = "Quick Sort com Pivô";
                    lista.quickComPivo();
                }
                case 7 -> {
                    nomeAlgoritmo = "Heap Sort";
                    lista.heap();
                }
                case 8 -> {
                    nomeAlgoritmo = "Shell Sort";
                    lista.shell();
                }
                case 9 -> {
                    nomeAlgoritmo = "Merge Sort 1ª Implementação";
                    lista.mergeSort1implementacaoLista();
                }
                case 10 -> {
                    nomeAlgoritmo = "Merge Sort 2ª Implementação";
                    lista.mergeSort2implementacaoLista();
                }
                case 11 -> {
                    nomeAlgoritmo = "Counting Sort";
                    lista.countingSort();
                }
                case 12 -> {
                    nomeAlgoritmo = "Bucket Sort";
                    lista.bucketSort();
                }
                case 13 -> {
                    nomeAlgoritmo = "Radix Sort";
                    lista.radixSort();
                }
                case 14 -> {
                    nomeAlgoritmo = "Comb Sort";
                    lista.combSort();
                }
                case 15 -> {
                    nomeAlgoritmo = "Gnome Sort";
                    lista.gnomeSort();
                }
                case 16 -> {
                    nomeAlgoritmo = "Tim Sort";
                    lista.timSort();
                }
                default -> {
                    return false;
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao executar " + nomeAlgoritmo + ": " + e.getMessage());
            sucesso = false;
        }

        long fim = System.currentTimeMillis();

        System.out.println("\nVetor ordenado com " + nomeAlgoritmo + ":");
        lista.exibirEmLinha();

        boolean ordenado = lista.estaOrdenada();
        System.out.println("Status: " + (ordenado ? "ORDENADO!" : "NÃO ORDENADO!"));
        System.out.println("Tempo de execução: " + (fim - inicio) + " ms");

        return sucesso && ordenado;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Lista lista = new Lista();
            int[] vetorTeste = new int[14]; 
            
            System.out.println("Bem-vindo ao Sistema de Testes de Algoritmos de Ordenação!");
            
            while (true) {
                limparTerminal();
                exibirMenu();
                
                System.out.print("Digite sua opção (número ou nome do método): ");
                String entrada = scanner.nextLine().trim().toLowerCase();
                
                int opcao;
                
                try {
                    opcao = Integer.parseInt(entrada);
                } catch (NumberFormatException e) {
                    switch (entrada) {
                        case "insercaodireta", "insercao" -> opcao = 1;
                        case "selecaodireta", "selecao" -> opcao = 2;
                        case "bolha", "bubble" -> opcao = 3;
                        case "shake" -> opcao = 4;
                        case "quicksempivo", "quick1" -> opcao = 5;
                        case "quickcompivo", "quick2" -> opcao = 6;
                        case "heap" -> opcao = 7;
                        case "shell" -> opcao = 8;
                        case "mergesort1implementacaolista", "merge1" -> opcao = 9;
                        case "mergesort2implementacaolista", "merge2" -> opcao = 10;
                        case "countingsort", "counting" -> opcao = 11;
                        case "bucketsort", "bucket" -> opcao = 12;
                        case "radixsort", "radix" -> opcao = 13;
                        case "combsort", "comb" -> opcao = 14;
                        case "gnomesort", "gnome" -> opcao = 15;
                        case "timsort", "tim" -> opcao = 16;
                        case "sair", "exit" -> opcao = 0;
                        default -> {
                            System.out.println("Opção inválida! Pressione Enter para continuar...");
                            scanner.nextLine();
                            continue;
                        }
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
                
                boolean sucesso = executarAlgoritmo(lista, opcao, vetorTeste);
                
                if (!sucesso) {
                    System.out.println("\nHouve um problema na execução do algoritmo!");
                }
                
                System.out.println("\nPressione Enter para continuar...");
                scanner.nextLine();
            }
        }
    }
}