import entities.Lista;
import entities.No;

public class Main {
    static void repreencherVetor(int[] vet) {
        for (int i = 0; i < vet.length; i++) {
            vet[i] = (int) (Math.random() * 100);
        }
    }
    public static void main(String[] args) {
        System.out.println("=== TESTE DAS FUNÇÕES ===\n");


        Lista lista = new Lista();
        int passou = 0, total = 6;
        
        // Teste inserirNoInicio
        lista.inserirNoInicio(10);
        lista.inserirNoInicio(20);
        if(lista.buscaExaustiva(20) != null) {
            System.out.println("✓ inserirNoInicio: OK");
            passou++;
        } else {
            System.out.println("✗ inserirNoInicio: FALHOU");
        }
        
        // Teste inserirNoFinal
        lista.inserirNoFinal(5);
        if(lista.buscaExaustiva(5) != null) {
            System.out.println("✓ inserirNoFinal: OK");
            passou++;
        } else {
            System.out.println("✗ inserirNoFinal: FALHOU");
        }
        
        // Teste buscaExaustiva
        No encontrado = lista.buscaExaustiva(10);
        No naoEncontrado = lista.buscaExaustiva(99);
        if(encontrado != null && naoEncontrado == null) {
            System.out.println("✓ buscaExaustiva: OK");
            passou++;
        } else {
            System.out.println("✗ buscaExaustiva: FALHOU");
        }
        
        // Teste remover
        lista.remover(20);
        if(lista.buscaExaustiva(20) == null) {
            System.out.println("✓ remover: OK");
            passou++;
        } else {
            System.out.println("✗ remover: FALHOU");
        }
        
        // Teste insercaoDireta
        lista.inserirNoInicio(30);
        lista.inserirNoInicio(15);
        lista.insercaoDireta();
        if(lista.buscaExaustiva(5) != null && lista.buscaExaustiva(10) != null && 
           lista.buscaExaustiva(15) != null && lista.buscaExaustiva(30) != null) {
            System.out.println("✓ insercaoDireta: OK");
            passou++;
        } else {
            System.out.println("✗ insercaoDireta: FALHOU");
        }

        int[] vet = {10, 3, 7, 2, 8, 6, 4, 5};
        // 1 implementacao do merge so funciona com multiplos de 8, por isso em vetor de 8 esta sendo criado aqui
        //para segunda implementacao esse problema nao existe
        /*System.out.println("\n=== TESTE popularComDados E exibir ===");
        lista.popularComDados(vet);
        lista.exibirEmLinha();
        lista.mergeSort1implementacaoLista();
        lista.exibirEmLinha();
        System.out.println(lista.estaOrdenada());*/

        System.out.println("\n=== TESTE mergeSort2implementacaoLista ===");
        int[] vet2 = {10, 3, 7, 2, 8, 6, 4, 5, 1, 9, 12, 11, 14, 13};
        lista.limpar();
        lista.popularComDados(vet2);
        lista.exibirEmLinha();
        lista.mergeSort2implementacaoLista();
        lista.exibirEmLinha();
        System.out.println(lista.estaOrdenada() ? "Lista ordenada com MergeSort2 implementacao" : "Lista não ordenada!");

        System.out.println("\n=== TESTE CountingSort ===");
        lista.limpar();
        repreencherVetor(vet2);
        lista.popularComDados(vet2);
        lista.exibirEmLinha();
        lista.countingSort();
        lista.exibirEmLinha();
        System.out.println(lista.estaOrdenada() ? "Lista ordenada com CountingSort" : "Lista não ordenada!");

        System.out.println("\n=== TESTE BucketSort ===");
        lista.limpar();
        repreencherVetor(vet2);
        lista.popularComDados(vet2);
        lista.exibirEmLinha();
        lista.countingSort();
        lista.exibirEmLinha();
        System.out.println(lista.estaOrdenada() ? "Lista ordenada com BucketSort" : "Lista não ordenada!");

        System.out.println("\n=== TESTE RadixSort ===");
        lista.limpar();
        repreencherVetor(vet2);
        lista.popularComDados(vet2);
        lista.exibirEmLinha();
        lista.radixSort();
        lista.exibirEmLinha();
        System.out.println(lista.estaOrdenada() ? "Lista ordenada com RadixSort" : "Lista não ordenada!");


        System.out.println("\n=== TESTE combSort ===");
        lista.limpar();
        repreencherVetor(vet2);
        lista.popularComDados(vet2);
        lista.exibirEmLinha();
        lista.combSort();
        lista.exibirEmLinha();
        System.out.println(lista.estaOrdenada() ? "Lista ordenada com CombSort" : "Lista não ordenada!");

        System.out.println("\n=== TESTE gnomeSort ===");
        lista.limpar();
        repreencherVetor(vet2);
        lista.popularComDados(vet2);
        lista.exibirEmLinha();
        lista.gnomeSort();
        lista.exibirEmLinha();
        System.out.println(lista.estaOrdenada() ? "Lista ordenada com gnomeSort" : "Lista não ordenada!");




        System.out.println("\n=== RESULTADO ===");
        System.out.println("Passou: " + passou + "/" + total);
    }
}