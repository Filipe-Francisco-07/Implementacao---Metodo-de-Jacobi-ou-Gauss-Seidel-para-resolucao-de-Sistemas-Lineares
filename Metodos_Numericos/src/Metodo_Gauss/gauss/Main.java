package gauss;

import java.util.Arrays;
public class Main {
	public static void main(String[] args) {
	double[][] A = {
			{2, 1,4},
			{3,-5,2},
			{1,2,-3}
	};
	double[] y = {3,4.5,-6.5};
	if(Gauss.verConvergencia(A)) {
		System.out.println("e convergente.");
	}else {
		System.out.println("podera nao convergir.");
	}
	Gauss.eliminacao(A, y);
	double[] solucao = Gauss.retrossubstituicao(A, y);

	System.out.println("Solucao:");
	System.out.println(Arrays.toString(solucao));	
	}

}
