/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import static grafos.DadosGrafos.instance;
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
    
     boolean bfs(int rGraph[][], int s, int t, int parent[])
    {
        // Create a visited array and mark all vertices as not
        // visited
        boolean visited[] = new boolean[DadosGrafos.getInstance().quantidadeVertice];
        for(int i=0; i < DadosGrafos.getInstance().quantidadeVertice; ++i)
            visited[i]=false;
 
        // Create a queue, enqueue source vertex and mark
        // source vertex as visited
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        parent[s]=-1;
 
        // Standard BFS Loop
        while (!queue.isEmpty())
        {
            int u = queue.poll();
 
            for (int v=0; v < DadosGrafos.getInstance().quantidadeVertice; v++)
            {
                if (visited[v]==false && rGraph[u][v] > 0)
                {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
 
        // If we reached sink in BFS starting from source, then
        // return true, else false
        return (visited[t] == true);
    }
}
