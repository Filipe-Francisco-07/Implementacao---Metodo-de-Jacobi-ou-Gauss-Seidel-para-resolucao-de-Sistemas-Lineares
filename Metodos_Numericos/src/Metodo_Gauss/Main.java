package Metodo_Gauss;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[][] matriz = {
            {1, 1, 1},
            {4, 4, 2},
            {2, 1, -1}
        };

        double[] vetor = {1, 2, 0};
        
        if(Gauss.verConvergente(matriz)) {
        	System.out.println("é convergente.");
        }else {
        	System.out.println("não é convergente.");
        }

        Gauss.eliminacao(matriz, vetor);
        double[] solucao = Gauss.retrossubstituicao(matriz, vetor);

        System.out.println("Solução:");
        System.out.println(Arrays.toString(solucao));
    }
}
