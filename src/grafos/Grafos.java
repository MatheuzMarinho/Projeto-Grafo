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
public class Grafos {

   
    public static void main(String[] args) {
       
        EncontrarFluxo encontrarFluxo = new EncontrarFluxo();
        
        DadosGrafos.getInstance().setQuantidadeVertice(6);
 
        System.out.println("O Fluxo Máximo do Grafo é : " +
                           encontrarFluxo.calcularFluxo(LeitorArquivo.lerArquivo(), 0, 5));
 
    }
    
    
}
