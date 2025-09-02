package entities;

public class No {
    int info;
    No ant, prox;

    /* CONSTRUCTORS */

    public No() {}

    public No(int info) {
        this.ant = null;
        this.prox = null;
        this.info = info;
    }

    public No(int info,No ant) {
        this.info = info;
        this.ant = null;
    }

    public No(int info,No ant, No prox) {
        this.info = info;
        this.ant = ant;
        this.prox = prox;
    }

    /* GETTERS & SETTERS */

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public No getAnt() {
        return ant;
    }

    public void setAnt(No ant) {
        this.ant = ant;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }


}
