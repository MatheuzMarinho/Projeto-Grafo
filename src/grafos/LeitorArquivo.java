/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author mathe
 */
public class LeitorArquivo {

 
    public static int[][] lerArquivo() {
        Scanner ler = new Scanner(System.in);
        int qtdVertice = 0;
        int qtdLinha = 0;
        int linhaGrafo = 0;
        int colunaGrafo = 0;
        int flag = 0;
        int[][] grafoFinal = new int [20][20] ;
   
        System.out.printf("Informe o nome de arquivo texto:\n");
        String nome = ler.nextLine();

        System.out.printf("\nConteúdo do arquivo texto:\n");
        try {
            FileInputStream entrada = new FileInputStream(nome);
            InputStreamReader arq = new InputStreamReader(entrada);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            while (linha != null) {
                String[] arrayValores = linha.split(" ");
                if (qtdLinha == 0) {
                    qtdVertice = Integer.parseInt(arrayValores[0]);
                    DadosGrafos.getInstance().setQuantidadeVertice(qtdVertice);
                } else if (qtdLinha > 0 && qtdLinha < qtdVertice) {
                    linhaGrafo = qtdLinha - 1;
                    int count = 0;
                    for (String s : arrayValores) {
                           if (count != 0) {
                            if (flag == 1) {
                                grafoFinal[linhaGrafo][colunaGrafo] = Integer.parseInt(s);
                                flag = 2; // pegar fluxo
                            } else if (flag == 2) {
                               // grafoFinal[colunaGrafo][linhaGrafo] = Integer.parseInt(s);
                                flag = 0; // pegar coluna
                            } else if (flag == 0) {
                                for (char c : s.toCharArray()) {
                                    if (c == '-') {
                                        break;
                                    } else if (c == 'v') {
                                        colunaGrafo = posicaoColuna(s);
                                        flag = 1; // pegar capacidade
                                    } else if (c == 's') {
                                        colunaGrafo = 0;
                                        flag = 1;
                                    } else if (c == 't') {
                                        colunaGrafo = qtdVertice - 1;
                                        flag = 1;
                                    }
                                }
                            }
                        }
                        count++;
                    }
                }
                System.out.printf("%s\n", linha);
                qtdLinha++;
                linha = lerArq.readLine(); // lê da segunda até a última linha

            }
            for (int i = 0; i < DadosGrafos.getInstance().quantidadeVertice; i++) {
                for (int j = 0; j < DadosGrafos.getInstance().quantidadeVertice; j++) {
                    System.out.printf("%d", grafoFinal[i][j]);
                   
                }
                System.out.printf("\n");
            }
            System.out.printf("%d", qtdVertice);
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

        System.out.println();
        return grafoFinal;
    }

    public static int posicaoColuna(String coluna) {
        System.out.printf("Posição Coluna");
        String valorFinal = "";
        for (char c : coluna.toCharArray()) {
            if (Character.isDigit(c)) {
                valorFinal += c;
            }
        }

        return Integer.parseInt(valorFinal);
    }
}
