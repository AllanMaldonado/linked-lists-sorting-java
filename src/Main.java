import entities.Lista;
import entities.No;

public class Main {
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
     
        
        System.out.println("\n=== RESULTADO ===");
        System.out.println("Passou: " + passou + "/" + total);
    }
}