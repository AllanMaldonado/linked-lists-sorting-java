# Algoritmos de Ordenação em Listas Ligadas

*Implementação em Java de uma lista duplamente ligada com múltiplos algoritmos de ordenação clássicos e modernos.*

![Badge Java](https://img.shields.io/badge/Java-8%2B-blue)
![Badge Status](https://img.shields.io/badge/Status-Concluído-green) 

---

## 📋 Visão Geral

Este projeto implementa uma **lista duplamente ligada** em Java, explorando a aplicação de diferentes **algoritmos de ordenação** diretamente na estrutura encadeada.

O objetivo é servir como recurso **educacional**, permitindo comparar eficiência, complexidade e comportamento de algoritmos em um contexto fora dos arrays tradicionais.

---

## 🏗️ Arquitetura do Projeto

* **`No`** → Classe que representa um nó da lista (valor + ponteiros anterior/próximo).
* **`Lista`** → Classe principal com as operações da lista e implementação dos algoritmos de ordenação.
* **`Main`** → Classe de testes para execução e validação.

---

## 📚 Algoritmos Implementados
 
* **Selection Sort (`selecaoDireta`)** 
* **Insertion Sort (`insercaoDireta`)**  
* **Insertion Sort Binário (`insercaoBin`)**  
* **Bubble Sort (`bolha`)**  
* **Heap Sort (`heap`)** 
* **Shake Sort (`shake`)** 
* **Shell Sort (`shell`)** 
* **Quick Sort sem pivô (`quickSemPivo`)** 
* **Quick Sort com pivô (`quickComPivo`)** 
* **Merge Sort – 1ª implementação (`mergeSort1implementacaoLista`)** 
* **Merge Sort – 2ª implementação (`mergeSort2implementacaoLista`)** 
* **Counting Sort (`countingSort`)** 
* **Bucket Sort (`bucketSort`)** 
* **Radix Sort (`radixSort`)** 
* **Comb Sort (`combSort`)** 
* **Gnome Sort (`gnomeSort`)**  
* **TimSort (`timSort`)**  

---

## 🚀 Como Executar

### ✅ Pré-requisitos

* Java JDK 8 ou superior
* IDE Java (IntelliJ, Eclipse, NetBeans) **ou** compilação via terminal

### 💻 Execução via terminal

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/linked-lists-sorting-java.git
cd linked-lists-sorting-java-main

# Compile
javac -d bin src/entities/*.java src/Main.java

# Execute
java -cp bin Main
```

---

## 🖥️ Exemplo de Saída

```text
Lista original:  42 → 15 → 7 → 23 → 89  

Ordenando com QuickSort...
Lista ordenada:  7 → 15 → 23 → 42 → 89  

Ordenando com Counting Sort...
Lista ordenada:  7 → 15 → 23 → 42 → 89  

Ordenando com TimSort...
Lista ordenada:  7 → 15 → 23 → 42 → 89
```

--- 

## 👥 Autores

Este projeto foi desenvolvido como parte da disciplina **Pesquisa e Ordenação**.

* Allan Maldonado
* Daniel Andreassi

---    
