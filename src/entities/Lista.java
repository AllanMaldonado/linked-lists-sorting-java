package entities;

public class Lista {
    private No inicio, fim;

    public Lista() {
    }

    public void inserirNoInicio(int info) {
        if (inicio == null)
            inicio = fim = new No(info);
        else {
            No nova = new No(info, null, inicio);
            inicio.setAnt(nova);
            inicio = nova;
        }
    }

    public void inserirNoFinal(int info) {
        if (fim == null)
            inicio = fim = new No(info);
        else {
            No novo = new No(info, fim, null);
            fim.setProx(novo);
            fim = novo;
        }
    }

    public void exibir() {
        No aux = inicio;
        while (aux != null) {
            System.out.println(aux.getInfo());
            aux = aux.getProx();
        }
    }

    public No remover(int info) {
        No aux = buscaExaustiva(info);

        if (aux != null) {
            if (inicio == fim) {
                inicio = fim = null;
            } else if (aux == inicio) {
                inicio = aux.getProx();
                aux.getProx().setAnt(null);
            } else if (aux == fim) {
                fim = aux.getAnt();
                aux.getAnt().setAnt(null);
            } else {
                aux.getAnt().setProx(aux.getProx());
                aux.getProx().setAnt(aux.getAnt());
            }
        }

        return null;
    }

    public No buscaExaustiva(int info) {
        No aux = inicio;
        while (aux != null && aux.getInfo() != info) {
            aux = aux.getProx();
        }
        return aux;
    }

    public void insercaoDireta() {
        int aux;
        No pi, ppos;
        pi = inicio.getProx();

        while (pi != null) {
            aux = pi.getInfo();
            ppos = pi;

            while (ppos != inicio && aux < ppos.getAnt().getInfo()) {
                ppos.setInfo(ppos.getAnt().getInfo());
                ppos = ppos.getAnt();
            }

            ppos.setInfo(aux);
            pi = pi.getProx();
        }
    }

    public No getMeio(No auxIni, No auxFim) {
        while (auxIni != null && auxFim != null && auxIni != auxFim && auxIni.getProx() != auxFim) {
            auxIni = auxIni.getProx();
            auxFim = auxFim.getAnt();
        }
        return auxIni;
    }

    public No buscaBin(int info) {
        No auxIni = inicio, auxFim = fim, meio;

        while (auxIni != null && auxFim != null && auxIni != auxFim && auxIni.getProx() != auxFim) {
            meio = getMeio(auxIni, auxFim);
            if (info == meio.getInfo())
                return meio;
            else if (info < meio.getInfo())
                auxFim = meio.getAnt();
            else
                auxIni = meio.getProx();
        }

        if (auxIni != null && auxIni.getInfo() >= info)
            return auxIni;
        if (auxFim != null && auxFim.getInfo() >= info)
            return auxFim;
        return null;
    }

    public void insercaoBin() {
        if (inicio != null) {
            int aux;
            No pi = inicio.getProx(), pj, piProx, pos;

            while (pi != null) {
                piProx = pi.getProx();
                aux = pi.getInfo();

                pos = inicio;
                while (pos != pi && pos.getInfo() < aux) {
                    pos = pos.getProx();
                }

                pj = pi;
                while (pj != pos) {
                    pj.setInfo(pj.getAnt().getInfo());
                    pj = pj.getAnt();
                }

                pj.setInfo(aux);

                pi = piProx;
            }
        }

    }

    public void selecaoDireta() {
        No pMenor, pi = inicio, pj;
        int aux;

        while (pi != null) {
            pMenor = pi;

            pj = pi.getProx();
            while (pj != null) {
                if (pj.getInfo() < pMenor.getInfo())
                    pMenor = pj;
                pj = pj.getProx();
            }

            aux = pMenor.getInfo();
            pMenor.setInfo(pi.getInfo());
            pi.setInfo(aux);

            pi = pi.getProx();
        }
    }

    public void bolha() {
        No TL = fim, pi;
        int aux;
        boolean troca = true;

        while (TL != null && troca) {
            troca = false;

            pi = inicio;
            while (pi != TL && pi.getProx() != null) {
                if (pi.getInfo() > pi.getProx().getInfo()) {
                    aux = pi.getInfo();
                    pi.setInfo(pi.getProx().getInfo());
                    pi.getProx().setInfo(aux);
                    troca = true;
                }
                pi = pi.getProx();
            }
            TL = TL.getAnt();
        }
    }

    public void shake() {
        int aux;
        boolean troca = true;
        No pIni = inicio, pFim = fim, pi;

        while (pIni != pFim && pIni.getProx() != pFim && troca) {
            troca = false;

            pi = pIni;
            while (pi != pFim && pi.getProx() != null) {
                if (pi.getInfo() > pi.getProx().getInfo()) {
                    aux = pi.getInfo();
                    pi.setInfo(pi.getProx().getInfo());
                    pi.getProx().setInfo(aux);
                    troca = true;
                }
                pi = pi.getProx();
            }
            pFim = pFim.getAnt();

            pi = pFim;
            while (pi != pIni && pi.getAnt() != null) {
                if (pi.getInfo() < pi.getAnt().getInfo()) {
                    aux = pi.getInfo();
                    pi.setInfo(pi.getAnt().getInfo());
                    pi.getAnt().setInfo(aux);
                    troca = true;
                }
                pi = pi.getAnt();
            }
            pIni = pIni.getProx();
        }
    }

    public void quickSemPivo() {
        quickSP(inicio, fim);
    }

    public void quickSP(No inicio, No fim) {
        No pi = inicio;
        No pj = fim;
        int aux;

        while (pi != pj) {
            while (pi != pj && pi.getInfo() <= pj.getInfo()) {
                pi = pi.getProx();
            }
            while (pi != pj && pj.getInfo() >= pi.getInfo()) {
                pj = pj.getAnt();
            }

            if (pi != pj) {
                aux = pi.getInfo();
                pi.setInfo(pj.getInfo());
                pj.setInfo(aux);
            }
        }

        if (inicio != pi && pi.getAnt() != null) {
            quickSP(inicio, pi.getAnt());
        }
        if (pi != fim && pi.getProx() != null) {
            quickSP(pi.getProx(), fim);
        }
    }

    public void quickComPivo() {
        quickCP(inicio, fim);
    }

    private void quickCP(No inicio, No fim) {
        int aux;
        int pivo = getMeio(inicio, fim).getInfo();
        No pi = inicio, pj = fim;

        while (pi != null && pj != null && pi != pj && pi.getAnt() != pj) {

            while (pi != pj && pi.getInfo() < pivo) {
                pi = pi.getProx();
            }

            while (pi != pj && pj.getInfo() > pivo) {
                pj = pj.getAnt();
            }

            if (pi != pj) {
                aux = pi.getInfo();
                pi.setInfo(pj.getInfo());
                pj.setInfo(aux);

                pi = pi.getProx();
                pj = pj.getAnt();
            }
        }

        if (pi == inicio) {
            pi = inicio.getProx();
        }

        if (inicio != null && pj != null && inicio != pj && inicio.getAnt() != pj) {
            quickCP(inicio, pj);
        }

        if (pi != null && fim != null && pi != fim && pi.getAnt() != fim) {
            quickCP(pi, fim);
        }
    }

    public int tamanho() {
        No atual = inicio;
        int tam = 0;

        while (atual != null) {
            tam++;
            atual = atual.getProx();
        }
        return tam;
    }

    private No buscaPos(int pos) {
        No atual = inicio;
        int posAtual = 0;

        while (posAtual < pos && atual != null) {
            atual = atual.getProx();
            posAtual++;
        }
        return atual;
    }

    public void heap() {
        int posPai, posFE, posFD, aux, TL = tamanho();
        No pai, FE, FD, maiorF;

        while (TL > 1) {
            for (posPai = TL / 2 - 1; posPai >= 0; posPai--) {
                pai = buscaPos(posPai);
                posFE = 2 * posPai + 1;
                posFD = posFE + 1;

                FE = buscaPos(posFE);
                maiorF = FE;

                if (posFD < TL) {
                    FD = buscaPos(posFD);
                    if (FD.getInfo() > FE.getInfo()) {
                        maiorF = FD;
                    }
                }

                if (pai.getInfo() < maiorF.getInfo()) {
                    aux = pai.getInfo();
                    pai.setInfo(maiorF.getInfo());
                    maiorF.setInfo(aux);
                }
            }

            aux = inicio.getInfo();
            pai = buscaPos(TL - 1);
            inicio.setInfo(pai.getInfo());
            pai.setInfo(aux);
            TL--;
        }
    }

    public void shell() {
        int dist = 1, i, posAtual, atualInfo, TL = tamanho();
        No atual, aux;

        while (dist < TL)
            dist = dist * 3 + 1;
        dist = dist / 3;

        while (dist > 0) {
            for (i = dist; i < TL; i++) {
                atual = buscaPos(i);
                posAtual = i;

                atualInfo = atual.getInfo();

                aux = buscaPos(posAtual - dist);
                while (posAtual >= dist && aux.getInfo() > atualInfo) {
                    atual.setInfo(aux.getInfo());
                    posAtual = posAtual - dist;
                    atual = aux;
                    aux = buscaPos(posAtual - dist);
                }

                atual.setInfo(atualInfo);
            }

            dist = dist / 3;
        }
    }

    public void bucketSort() {
        int maximo = maiorValorDaLista();
        int minimo = menorValorDaLista();
        int bucketCount = (int) Math.sqrt(maximo - minimo + 1);
        int intervalo = (maximo - minimo + 1) / bucketCount;
        int i, pos;
        Lista[] bucket = new Lista[bucketCount + 1];
        No aux;
        No lista = inicio;

        if (intervalo == 0) {
            intervalo = 1;
        }

        for (i = 0; i < bucket.length; i++) {
            bucket[i] = new Lista();
        }

        for (aux = inicio; aux != null; aux = aux.getProx()) {
            pos = (aux.getInfo() - minimo) / intervalo;
            if (pos >= bucket.length) {
                pos = bucket.length - 1;
            }
            bucket[pos].inserirNoInicio(aux.getInfo());
        }

        for (i = 0; i < bucket.length; i++) {
            if (bucket[i].inicio != null) {
                bucket[i].countingSort();
            }
        }

        for (i = 0; i < bucket.length; i++) {
            for (aux = bucket[i].inicio; aux != null; aux = aux.getProx()) {
                if (lista != null) {
                    lista.setInfo(aux.getInfo());
                    lista = lista.getProx();
                }
            }
        }
    }

    public void radixSort() {
        int maximo = maiorValorDaLista();
        int i, tamanho = tamanho();
        Lista lista = new Lista();
        No aux, Nolista;

        for (i = 0; i < tamanho; i++)
            lista.inserirNoInicio(0);
        for (int digito = 1; digito <= maximo; digito *= 10) {
            int[] contagem = new int[10];

            for (aux = inicio; aux != null; aux = aux.getProx())
                contagem[(aux.getInfo() / digito) % 10]++;

            for (i = 1; i < 10; i++)
                contagem[i] += contagem[i - 1];

            Nolista = lista.inicio;
            i = 0;
            for (aux = fim; aux != null; aux = aux.getAnt()) {
                int pos = (aux.getInfo() / digito) % 10;
                Nolista = posicionaNo(Nolista, i, --contagem[pos]);
                i = contagem[pos];
                Nolista.setInfo(aux.getInfo());
            }

            Nolista = inicio;
            inicio = lista.inicio;
            lista.inicio = Nolista;

            Nolista = fim;
            fim = lista.fim;
            lista.fim = Nolista;
        }
    }

    public void combSort() {
        int tamanho = tamanho();
        int intervalo = (int) (tamanho / 1.3);
        int i, info;
        No aux, aux2;
        boolean troca = true;

        while (intervalo > 1 || troca) {
            troca = false;
            i = 0;
            aux = inicio;
            aux2 = posicionaDepois(aux, 0, intervalo);
            while (i + intervalo < tamanho) {
                if (aux.getInfo() > aux2.getInfo()) {
                    info = aux.getInfo();
                    aux.setInfo(aux2.getInfo());
                    aux2.setInfo(info);
                    troca = true;
                }
                i++;
                aux = aux.getProx();
                aux2 = aux2.getProx();
            }
            if (intervalo > 1) {
                troca = true;
                intervalo = (int) (intervalo / 1.3);
            }
        }
    }

    public void gnomeSort() {
        No aux = inicio;

        while (aux != null) {
            if (aux == inicio)
                aux = aux.getProx();
            if (aux.getInfo() >= aux.getAnt().getInfo())
                aux = aux.getProx();
            else {
                int info = aux.getInfo();
                aux.setInfo(aux.getAnt().getInfo());
                aux.getAnt().setInfo(info);
                aux = aux.getAnt();
            }
        }
    }

    private void insersacaoDiretaTimSort(No inicio, No fim) {
        No posicaoInicial, ppos;
        int aux;

        for (posicaoInicial = inicio.getProx(); posicaoInicial != fim.getProx(); posicaoInicial = posicaoInicial
                .getProx()) {
            ppos = posicaoInicial;
            aux = posicaoInicial.getInfo();

            while (ppos != inicio && aux < ppos.getAnt().getInfo()) {
                ppos.setInfo(ppos.getAnt().getInfo());
                ppos = ppos.getAnt();
            }
            ppos.setInfo(aux);
        }
    }

    public void timSort() {
        int tl = tamanho(), run = 32, esquerda, meio, direita;
        No ini = this.inicio, noEsquerda, noMeio;
        No fim = posicionaDepois(inicio, 0, Math.min(run, tl - 1));

        for (int i = 0; i < tl;) {
            insersacaoDiretaTimSort(ini, fim);
            i += run;
            if (i < tl) {
                ini = fim;
                fim = posicionaDepois(ini, i + run, Math.min(i + run, tl - 1));
            }
        }

        No lista = new No(), aux = lista;
        for (int i = 1; i < tl; i++) {
            aux.setProx(new No());
            aux.getProx().setAnt(aux);
            aux = aux.getProx();
        }

        for (int tam = run; tam < tl; tam = 2 * tam) {
            for (esquerda = 0; esquerda < tl; esquerda += 2 * tam) {
                meio = esquerda + tam - 1;
                direita = Math.min((esquerda + 2 * tam - 1), (tl - 1));

                if (meio < direita) {
                    noEsquerda = posicionaDepois(inicio, 0, esquerda);
                    noMeio = posicionaDepois(noEsquerda, esquerda, meio);
                    No noDireita = posicionaDepois(inicio, 0, direita);
                    fusao2Lista(lista, noEsquerda, noMeio, esquerda, meio, noMeio.getProx(), noDireita, meio + 1,
                            direita);
                }
            }
        }
    }

    public void countingSort() {
        int maximo = maiorValorDaLista(), i;
        No aux;

        int[] vetorContagem = new int[maximo + 1];

        for (aux = inicio; aux != null; aux = aux.getProx())
            vetorContagem[aux.getInfo()]++;

        for (i = 1; i < vetorContagem.length; i++)
            vetorContagem[i] += vetorContagem[i - 1];

        No ordenado = new No();
        int tamanho = tamanho();
        No lista = ordenado;
        for (i = 1; i < tamanho; i++) {
            lista.setProx(new No());
            lista.getProx().setAnt(lista);
            lista = lista.getProx();
        }

        aux = fim;
        fim = lista;
        inicio = ordenado;
        for (; aux != null; aux = aux.getAnt()) {
            lista = posicionaNo(lista, i, vetorContagem[aux.getInfo()]);
            i = vetorContagem[aux.getInfo()];
            lista.setInfo(aux.getInfo());
            vetorContagem[aux.getInfo()]--;
        }
    }

    public void mergeSort1implementacaoLista() {
        Lista lista1 = new Lista();
        Lista lista2 = new Lista();
        int sequencia = 1;
        int tamanho = tamanho();
        int meio = tamanho / 2;

        for (int i = 0; i < meio; i++) {
            lista1.inserirNoInicio(0);
            lista2.inserirNoInicio(0);
        }
        System.out.println("Lista 1 e 2 criadas com tamanho: " + meio);
        lista1.exibirEmLinha();
        lista2.exibirEmLinha();
        while (sequencia < tamanho) {
            particao1Lista(lista1, lista2, tamanho, meio);
            fusao1Lista(lista1, lista2, sequencia);
            sequencia *= 2;
        }
    }

    public void particao1Lista(Lista lista1, Lista lista2, int tamanho, int meio) {
        No aux = inicio;
        No lista1Aux = lista1.inicio;
        for (int i = 0; i < meio; i++) {
            lista1Aux.setInfo(aux.getInfo());
            lista1Aux = lista1Aux.getProx();
            aux = aux.getProx();
        }

        No lista2Aux = lista2.inicio;
        for (int i = meio; i < tamanho; i++) {
            lista2Aux.setInfo(aux.getInfo());
            lista2Aux = lista2Aux.getProx();
            aux = aux.getProx();
        }
    }

    public void exibirListas(Lista lista1, Lista lista2) {
        System.out.print("Lista 1: ");
        lista1.exibirEmLinha();
        System.out.print("Lista 2: ");
        lista2.exibirEmLinha();
    }

    public void fusao1Lista(Lista lista1, Lista lista2, int sequencia) {
        No ListaAux1 = lista1.inicio;
        No ListaAux2 = lista2.inicio;
        exibirListas(lista1, lista2);
        No aux = inicio;
        int i, j, auxSeq = sequencia;

        for (i = j = 0; aux != null;) {
            while (i < sequencia && j < sequencia) {
                if (ListaAux1.getInfo() < ListaAux2.getInfo()) {
                    aux.setInfo(ListaAux1.getInfo());
                    ListaAux1 = ListaAux1.getProx();
                    i++;
                } else {
                    aux.setInfo(ListaAux2.getInfo());
                    ListaAux2 = ListaAux2.getProx();
                    j++;
                }
                aux = aux.getProx();
            }
            while (i < sequencia) {
                aux.setInfo(ListaAux1.getInfo());
                ListaAux1 = ListaAux1.getProx();
                i++;
                aux = aux.getProx();
            }
            while (j < sequencia) {
                aux.setInfo(ListaAux2.getInfo());
                ListaAux2 = ListaAux2.getProx();
                j++;
                aux = aux.getProx();
            }
            sequencia += auxSeq;
        }

    }

    public void mergeSort2Lista(No lista, No esquerda, No direita, int posEsquerda, int posDireita) {
        if (posEsquerda < posDireita) {
            int meioPos = (posEsquerda + posDireita) / 2;
            No meio = posicionaDepois(esquerda, posEsquerda, meioPos);
            mergeSort2Lista(lista, esquerda, meio, posEsquerda, meioPos);
            mergeSort2Lista(lista, meio.getProx(), direita, meioPos + 1, posDireita);
            fusao2Lista(lista, esquerda, meio, posEsquerda, meioPos, meio.getProx(), direita, meioPos + 1, posDireita);
        }
    }

    public void mergeSort2implementacaoLista() {
        int tamanho = tamanho();
        No ListaAux = new No(), aux = ListaAux;

        for (int i = 1; i < tamanho; i++) {
            aux.setProx(new No());
            aux.getProx().setAnt(aux);
            aux = aux.getProx();
        }
        mergeSort2Lista(ListaAux, inicio, fim, 0, tamanho - 1);
    }

    public void fusao2Lista(No lista, No inicio1, No fim1, int pos_inicio1, int pos_fim1, No inicio2, No fim2,
            int pos_inicio2, int pos_fim2) {
        No aux = lista;
        No NoInicio1 = inicio1;
        No NoInicio2 = inicio2;
        int i = pos_inicio1, j = pos_inicio2, k = 0;

        while (i <= pos_fim1 && j <= pos_fim2) {
            if (NoInicio1.getInfo() < NoInicio2.getInfo()) {
                aux.setInfo(NoInicio1.getInfo());
                NoInicio1 = NoInicio1.getProx();
                i++;
            } else {
                aux.setInfo(NoInicio2.getInfo());
                NoInicio2 = NoInicio2.getProx();
                j++;
            }
            aux = aux.getProx();
            k++;
        }

        while (i <= pos_fim1) {
            aux.setInfo(NoInicio1.getInfo());
            NoInicio1 = NoInicio1.getProx();
            aux = aux.getProx();
            i++;
            k++;
        }
        while (j <= pos_fim2) {
            aux.setInfo(NoInicio2.getInfo());
            NoInicio2 = NoInicio2.getProx();
            aux = aux.getProx();
            j++;
            k++;
        }

        No no = posicionaDepois(inicio, 0, pos_inicio1);
        aux = lista;
        for (i = 0; i < k; i++) {
            no.setInfo(aux.getInfo());
            no = no.getProx();
            aux = aux.getProx();
        }
    }

    private No posicionaDepois(No pos, int posAtual, int posDestino) {
        while (posAtual < posDestino) {
            pos = pos.getProx();
            posAtual++;
        }
        return pos;
    }

    public int maiorValorDaLista() {
        int maximo = inicio.getInfo();
        No aux = inicio.getProx();
        while (aux != null) {
            if (aux.getInfo() > maximo)
                maximo = aux.getInfo();
            aux = aux.getProx();
        }
        return maximo;
    }

    private No posicionaNo(No no, int pos_atual, int pos_destino) {
        if (pos_destino > pos_atual) {
            while (pos_atual != pos_destino) {
                no = no.getProx();
                pos_atual++;
            }
            return no;
        }
        while (pos_atual != pos_destino) {
            no = no.getAnt();
            pos_atual--;
        }
        return no;
    }

    public int menorValorDaLista() {
        int minimo = inicio.getInfo();
        No aux = inicio.getProx();
        while (aux != null) {
            if (aux.getInfo() < minimo)
                minimo = aux.getInfo();
            aux = aux.getProx();
        }
        return minimo;
    }

    public void limpar() {
        inicio = fim = null;
    }

    public void popularComDados(int[] dados) {
        limpar();
        for (int valor : dados) {
            inserirNoFinal(valor);
        }
    }

    public boolean estaOrdenada() {
        if (inicio == null)
            return true;

        No atual = inicio;
        while (atual.getProx() != null) {
            if (atual.getInfo() > atual.getProx().getInfo()) {
                return false;
            }
            atual = atual.getProx();
        }
        return true;
    }

    public void exibirEmLinha() {
        No aux = inicio;
        System.out.print("[");
        while (aux != null) {
            System.out.print(aux.getInfo());
            if (aux.getProx() != null) {
                System.out.print(", ");
            }
            aux = aux.getProx();
        }
        System.out.println("]");
    }

}
