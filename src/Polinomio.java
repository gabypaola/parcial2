import java.math.BigDecimal;

public class Polinomio {

    dataset dataset = new dataset();


    /////////// calculo para la matriz X ///////////////
    public BigDecimal[][] matrizX(int potencia, double[] X) {
        int n = X.length;
        BigDecimal[][] polinomial = new BigDecimal[n][potencia + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= potencia; j++) {
                polinomial[i][j] = BigDecimal.valueOf(Math.pow(X[i], j));
            }
        }
        return polinomial;
    }


    ///////////// calculo para el vector Y///////////
    public BigDecimal[] matrizY(double[] Y) {
        int n = Y.length;
        BigDecimal[] matrizY = new BigDecimal[n];

        for (int i = 0; i < n; i++) {
            matrizY[i] = BigDecimal.valueOf(Y[i]);
        }
        return matrizY;
    }


    ///////// calculo de la matriz X transpuesta/////////////
    public BigDecimal[][] matrizXTranspuesta(int potencia, double[] X) {
        int n = X.length;
        BigDecimal[][] transpuesta = new BigDecimal[potencia + 1][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= potencia; j++) {
                transpuesta[j][i] = BigDecimal.valueOf(Math.pow(X[i], j));
            }
        }

        return transpuesta;
    }


}
