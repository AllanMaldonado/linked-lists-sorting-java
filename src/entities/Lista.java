package entities;

public class Lista {
    No inicio, fim;

    public Lista(){}

    public void inserirNoInicio(int info){
        if(inicio == null)
            inicio = fim = new No(info);
        else{
            No nova = new No(info,null,inicio);
            inicio.setAnt(nova);
            inicio = nova;
        }
    }

    public void inserirNoFinal(int info){
        if(fim == null)
            inicio = fim = new No(info);
        else{
            No novo = new No(info,fim,null);
            fim.setProx(novo);
            fim = novo;
        }
    }

    public void exibir(){
        No aux = inicio;
        while(aux != null) {
            System.out.println(aux.getInfo());
            aux = aux.getProx();
        }
    }

    public No remover(int info){
        No aux = buscaExaustiva(info);

        /*
         *   1) A caixa excluir esta em Inicio = fim ---> coloca null em ambos
         *   2) Quer excluir o inicio, onde tem prox ---> inicio = prox; prox ant = null;
         *   3) Quer excluir o fim, onde tem ant ---> im = ant; ant prox = null;
         *   4) Quer excluir no meio,ant prox = prox; prox ant = ant;
         */

        if(aux != null){
            if(inicio == fim){
                inicio = fim = null;
            }else if(aux == inicio){
                inicio = aux.getProx();
                aux.getProx().setAnt(null);
            }else if(aux == fim){
                fim = aux.getAnt();
                aux.getAnt().setAnt(null);
            }else{
                aux.getAnt().setProx(aux.getProx());
                aux.getProx().setAnt(aux.getAnt());
            }
        }

        return null;
    }

    public No buscaExaustiva(int info){
        No aux = inicio;
        while(aux != null && aux.getInfo() != info ) {
            aux = aux.getProx();
        }
        return aux;
    }

    public void insercaoDireta(){
        int aux;
        No pi, ppos;
        pi = inicio.getProx();

        while(pi != null){
            aux = pi.getInfo();
            ppos = pi;

            while(ppos != inicio && aux < ppos.getAnt().getInfo()){
                ppos.setInfo(ppos.getAnt().getInfo());
                ppos = ppos.getAnt();
            }

            ppos.setInfo(aux);
            pi = pi.getProx();
        }
    }
 
    //# transformar em lista |-------------------------------------|

    public No getMeio(No auxIni, No auxFim){
        while(auxIni != auxFim && auxIni.getProx() != auxFim){
            auxIni = auxIni.getProx();
            auxFim = auxFim.getAnt();
        }
        return auxIni;
    }

    public No buscaBin(int info){
        if(inicio == null) return null;
        
        No auxIni = inicio, auxFim = fim, meio;

        meio = getMeio(auxIni,auxFim);
        while(auxIni != auxFim && meio != null && info != meio.getInfo()){
            if(info < meio.getInfo()){
                auxFim = meio.getAnt();
                if(auxFim == null) break;
            }else{
                auxIni = meio.getProx();
                if(auxIni == null) break;
            }
            meio = getMeio(auxIni,auxFim);
        }

        if(meio != null && info == meio.getInfo())
            return meio;
        return null;
    }

    public int buscaBin(int info, int position){
        int TL = 10;
        int[] vet = new int[TL];

        int ini = 0, fim = TL - 1, meio = fim/2;

        while(ini < fim && info > vet[meio]){
            if(info < vet[meio]){
                fim = meio - 1;
            }else{
                ini = meio + 1;
            }
            meio = (ini+fim)/2;
        }

        if(info == vet[meio])
            return meio;
        return -1;
    }

    public void insercaoBinaria(){
        int TL = 10;
        int[] vet = new int[TL];

        int aux, pos;

        for(int i = 1; i< TL;i++){
            aux = vet[i];
            pos = buscaBin(aux, i); //buscar a melhor pos (mudar a funcao)

            for(int j = i; j< pos;j--){
                vet[j] = vet[j-1];
            }
            vet[pos] = aux;
        }
    }

    public void selecaoDireta(){
        int TL = 10, menor, posMenor;
        int[] vet = new int[TL];

        for(int i = 0; i < TL - 1; i++){
            menor = vet[i];
            posMenor = i;
            for(int j = i; j < TL - 1; j++){
                if(vet[j] < menor){
                    menor = vet[j];
                    posMenor = j;
                }
            }
            vet[posMenor] = vet[i];
            vet[i] = posMenor;
        }
    }

    public void bolha(){
        int TL = 10, TL2 = TL, aux;
        boolean troca = true;
        int[] vet = new int[TL];

        while(TL2 > 1 && troca){
            troca = false;

            for(int i = 0; i < TL2; i++){
                if(vet[i] > vet[i+1]){
                    aux = vet[i];
                    vet[i] = vet[i+1];
                    vet[i+1] = aux;
                    troca = true;
                }
            }
            TL2--;
        }
    }

    public void shake(){
        int TL = 10, inicio = 0, fim = TL-1, aux;
        int[] vet = new int[TL];
        boolean troca = true;

        while(inicio < fim && troca){
            troca = false;
            for(int i = inicio; i < fim; i++){
                if(vet[i] > vet[i+1]){
                    aux = vet[i];
                    vet[i] = vet[i+1];
                    vet[i+1] = aux;
                    troca = true;
                }
            }
            fim--;
        }

        // CONTINUA COMECA DE FIM E VAI ATE O INCIO, TERMINA COM AMBOS
    }
}
