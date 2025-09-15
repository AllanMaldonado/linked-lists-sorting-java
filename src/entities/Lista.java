package entities;

public class Lista {
    No inicio, fim;

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

        /*
         * 1) A caixa excluir esta em Inicio = fim ---> coloca null em ambos
         * 2) Quer excluir o inicio, onde tem prox ---> inicio = prox; prox ant = null;
         * 3) Quer excluir o fim, onde tem ant ---> im = ant; ant prox = null;
         * 4) Quer excluir no meio,ant prox = prox; prox ant = ant;
         */

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

        // Retorna o nó onde o valor deve ser inserido
        if (auxIni != null && auxIni.getInfo() >= info)
            return auxIni;
        if (auxFim != null && auxFim.getInfo() >= info)
            return auxFim;
        return null; // insere no final
    }

    public void insercaoBin() {
        if (inicio == null)
            return;

        int aux;
        No pi = inicio.getProx(), pj, piProx, pos;

        while (pi != null) {
            piProx = pi.getProx();
            aux = pi.getInfo();

            // Busca apenas na sublista ordenada (do início até pi.getAnt())
            pos = inicio;
            while (pos != pi && pos.getInfo() < aux) {
                pos = pos.getProx();
            }

            // Desloca os elementos para abrir espaço
            pj = pi;
            while (pj != pos) {
                pj.setInfo(pj.getAnt().getInfo());
                pj = pj.getAnt();
            }

            pj.setInfo(aux);

            pi = piProx;
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
        if (inicio == null || fim == null || inicio == fim)
            return;

        int aux;
        No pivo = getMeio(inicio, fim);
        No pi = inicio, pj = fim;

        while (pi != null && pj != null && pi != pj && pi.getAnt() != pj) {

            while (pi != pj && pi.getInfo() < pivo.getInfo())
                pi = pi.getProx();

            while (pi != pj && pj.getInfo() > pivo.getInfo())
                pj = pj.getAnt();

            if (pi != pj && pi.getInfo() > pj.getInfo()) {
                aux = pi.getInfo();
                pi.setInfo(pj.getInfo());
                pj.setInfo(aux);
            } else {
                if (pi != pj)
                    pi = pi.getProx();
                if (pi != pj)
                    pj = pj.getAnt();
            }

        }

        if (inicio != pj && inicio != pj.getProx())
            quickCP(inicio, pj);
        if (pi != fim && pi != fim.getAnt())
            quickCP(pi, fim);
    }

    // # transformar em lista |-------------------------------------|

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
        int dist = 1, i, pos, aux, TL = 10;
        int[] vet = new int[TL];
        while (dist < TL)
            dist = dist * 3 + 1;
        dist = dist / 3;

        while (dist > 0) {
            for (i = dist; i < TL; i++) {
                aux = vet[i];
                pos = i;

                while (pos >= dist && aux < vet[pos - dist]) {
                    vet[pos] = vet[pos - dist];
                    pos = pos - dist;
                }
                vet[pos] = aux;
            }

            dist = dist / 3;
        }
    }

    // Métodos auxiliares para testes
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
