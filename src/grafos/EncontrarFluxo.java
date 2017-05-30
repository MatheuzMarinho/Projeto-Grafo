/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

/**
 *
 * @author mathe
 */
public class EncontrarFluxo {

    int calcularFluxo(int[][] grafo, int verticeInicial, int verticeFinal) {
        int aux1, aux2, qtdVezes = 0;
        
         System.out.println("Grafo Original: ");
         mostrarMatriz(grafo);
         System.out.println();
         System.out.println();

        int[][] redeResidual = new int[DadosGrafos.getInstance().quantidadeVertice][DadosGrafos.getInstance().quantidadeVertice];

        for (aux1 = 0; aux1 < DadosGrafos.getInstance().quantidadeVertice; aux1++) {
            for (aux2 = 0; aux2 < DadosGrafos.getInstance().quantidadeVertice; aux2++) {
                redeResidual[aux1][aux2] = grafo[aux1][aux2];
            }
        }

        int[] caminhoVertice = new int[DadosGrafos.getInstance().quantidadeVertice];

        int fluxoMaximo = 0;

        while (BuscaLargura.getInstance().existeCaminho(redeResidual, verticeInicial, verticeFinal, caminhoVertice)) {
            qtdVezes++;
            int fluxoMinimo = Integer.MAX_VALUE;
            for (aux2 = verticeFinal; aux2 != verticeInicial; aux2 = caminhoVertice[aux2]) {
                aux1 = caminhoVertice[aux2];
                fluxoMinimo = Math.min(fluxoMinimo, redeResidual[aux1][aux2]);
            }

            for (aux2 = verticeFinal; aux2 != verticeInicial; aux2 = caminhoVertice[aux2]) {
                aux1 = caminhoVertice[aux2];
                redeResidual[aux1][aux2] -= fluxoMinimo;
                redeResidual[aux2][aux1] += fluxoMinimo;
            }
            System.out.println("Dados do Processamento : " + qtdVezes);
            System.out.print("Caminho ");
            mostrarCaminho(caminhoVertice, verticeInicial, verticeFinal);
            System.out.println();
            System.out.println("Ampliação " + qtdVezes + " : " + fluxoMinimo);
            System.out.println("Grafo Resultante: ");
            mostrarMatriz(redeResidual);

            fluxoMaximo += fluxoMinimo;
        }

        return fluxoMaximo;
    }

    public void mostrarCaminho(int caminhoVertice[], int verticeInicial, int vertice) {
        if (vertice == verticeInicial) {
            System.out.print("S ");
        } else {
            mostrarCaminho(caminhoVertice, verticeInicial, caminhoVertice[vertice]);
            if (vertice == (DadosGrafos.getInstance().quantidadeVertice - 1)) {
                System.out.print(" -> " + "T ");
            } else {
                System.out.print(" -> " + "V " + vertice);
            }

        }

    }

    public void mostrarMatriz(int matriz[][]) {
        for (int i = 0; i < DadosGrafos.getInstance().quantidadeVertice; i++) {
            if (i == 0) {
                System.out.print("S -> ");
            }
            else if(i == (DadosGrafos.getInstance().quantidadeVertice - 1)){
                System.out.print("T ");
            }
            else {
                System.out.print("V" + i + "-> ");
            }
            for (int j = 0; j < DadosGrafos.getInstance().quantidadeVertice; j++) {
                if (DadosGrafos.getInstance().getGrafo()[i][j] > 0) {
                    if (j == (DadosGrafos.getInstance().quantidadeVertice - 1)) {
                        System.out.print("T ");
                    } else {
                        System.out.print("V" + j);
                    }
                    System.out.print(" Capacidade : " + DadosGrafos.getInstance().getGrafo()[i][j]);
                    System.out.printf(" Fluxo : %d ", DadosGrafos.getInstance().getGrafo()[i][j] - matriz[i][j]);

                }
            }
            System.out.printf("\n");
        }
    }

}
