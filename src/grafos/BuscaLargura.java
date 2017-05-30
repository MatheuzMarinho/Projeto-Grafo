/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.LinkedList;
import java.util.Objects;

/**
 *
 * @author mathe
 */
public class BuscaLargura {
    public static BuscaLargura instance;
    
    public BuscaLargura() {
    }
    
     public static BuscaLargura getInstance() {
        if (Objects.isNull(instance)) {
            instance = new BuscaLargura();
        }
        return instance;
    }
    
     boolean existeCaminho(int[][] redeResidual, int verticeInicial, int verticeFinal, int[] caminhoVertice)
    {
   
        boolean[] visitados = new boolean[DadosGrafos.getInstance().quantidadeVertice];
        for(int i=0; i < DadosGrafos.getInstance().quantidadeVertice; ++i)
            visitados[i]=false;
 
        LinkedList<Integer> fila = new LinkedList<Integer>();
        fila.add(verticeInicial);
        visitados[verticeInicial] = true;
        caminhoVertice[verticeInicial]=-1;

        while (!fila.isEmpty())
        {
            int vertice = fila.poll();
 
            for (int v=0; v < DadosGrafos.getInstance().quantidadeVertice; v++)
            {
                if (visitados[v]==false && redeResidual[vertice][v] > 0)
                {
                    fila.add(v);
                    caminhoVertice[v] = vertice;
                    visitados[v] = true;
                }
            }
        }
 
        return (visitados[verticeFinal] == true);
    }
     
}
