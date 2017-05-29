/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.Objects;

/**
 *
 * @author mathe
 */
public class DadosGrafos {

    public static DadosGrafos instance;
    int quantidadeVertice;

    public DadosGrafos() {
    }

    public static DadosGrafos getInstance() {
        if (Objects.isNull(instance)) {
            instance = new DadosGrafos();
        }
        return instance;
    }

    public int getQuantidadeVertice() {
        return quantidadeVertice;
    }

    public void setQuantidadeVertice(int quantidadeVertice) {
        this.quantidadeVertice = quantidadeVertice;
    }

}
