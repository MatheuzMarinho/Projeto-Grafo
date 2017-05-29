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
 
    int calcularFluxo(int[][] grafo, int verticeInicial, int verticeFinal)
    {
        int aux1, aux2;
 
        int[][] redeResidual = new int[DadosGrafos.getInstance().quantidadeVertice][DadosGrafos.getInstance().quantidadeVertice];
 
        for (aux1 = 0; aux1 < DadosGrafos.getInstance().quantidadeVertice; aux1++)
            for (aux2 = 0; aux2 < DadosGrafos.getInstance().quantidadeVertice; aux2++)
                redeResidual[aux1][aux2] = grafo[aux1][aux2];
 
        int[] caminhoVertice = new int[DadosGrafos.getInstance().quantidadeVertice];
 
        int fluxoMaximo = 0;  
 

        while (BuscaLargura.getInstance().bfs(redeResidual, verticeInicial, verticeFinal, caminhoVertice))
        {

            int fluxoMinimo = Integer.MAX_VALUE;
            for (aux2=verticeFinal; aux2!=verticeInicial; aux2=caminhoVertice[aux2])
            {
                aux1 = caminhoVertice[aux2];
                fluxoMinimo = Math.min(fluxoMinimo, redeResidual[aux1][aux2]);
            }
 
            for (aux2=verticeFinal; aux2 != verticeInicial; aux2=caminhoVertice[aux2])
            {
                aux1 = caminhoVertice[aux2];
                redeResidual[aux1][aux2] -= fluxoMinimo;
                redeResidual[aux2][aux1] += fluxoMinimo;
            }
 
            fluxoMaximo += fluxoMinimo;
        }
 
      
        return fluxoMaximo;
    }
    
}
