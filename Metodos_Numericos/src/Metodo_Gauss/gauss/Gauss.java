package gauss;

public class Gauss {
	public static void eliminacao(double[][] a, double[] y) {
		int n = y.length;
		for (int i = 0; i < n; i++) {
			int pivo = i;
			for (int j = i + 1; j < n; j++) {
				if (Math.abs(a[j][i]) > Math.abs(a[pivo][i])) {
					pivo = j;
				}
			}
			double[] aux = a[i];
			a[i] = a[pivo];
			a[pivo] = aux;
			
			double temp = y[i];
			y[i] = y[pivo];
			y[pivo] = temp;
			
			double elementopivo = a[i][i];
			for (int j = i; j < n; j++) {
				a[i][j] /= elementopivo;
			}
			y[i] /= elementopivo;
			for (int k = i + 1; k < n; k++) {
				double fator = a[k][i];
				for (int j = i; j < n; j++) {
					a[k][j] -= fator * a[i][j];
				}
				y[k] -= fator * y[i];
			}
		}
	}
	
	public static double[] retrossubstituicao(double[][] a, double[] y) {
		int n = y.length;
		double[] solucao = new double[n];
		for (int i = n - 1; i >= 0; i--) {
			solucao[i] = y[i];
			for (int j = i + 1; j < n; j++) {
				solucao[i] -= a[i][j] * solucao[j];
			}
		}
		return solucao;
	}
	
	public static boolean verConvergencia(double[][] a) {
		int n = a.length;
		boolean convergente = true;
		for (int i = 0; i < n; i++) {
			double soma = 0.0;
			for (int j = 0; j < n; j++) {
				if (i != j) {
					soma += Math.abs(a[i][j]);
				}
			}
			if (Math.abs(a[i][i]) <= soma) {
				convergente = false;
				break;
			}
		}
		return convergente;
	}
}
