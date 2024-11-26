import java.math.BigDecimal;

public class operaciones {
    dataset data = new dataset();
    Polinomio polinomio = new Polinomio();


    ////////////////////// multiplicacion de matriz X por la transpuesta de X/////////////////////////
    public BigDecimal[][] MultiplicacionMatrices(int potencia) {
        // invoca la matriz X
        BigDecimal[][] MX = polinomio.matrizX(potencia, data.X);
        BigDecimal[][] MT = polinomio.matrizXTranspuesta(potencia, data.X);

        BigDecimal[][] resultado = new BigDecimal[MT.length][MX[0].length];

        for (int i = 0; i < MT.length; i++) {
            for (int j = 0; j < MX[0].length; j++) {
                resultado[i][j] = BigDecimal.ZERO;
                for (int k = 0; k < MX.length; k++) {
                    resultado[i][j] = resultado[i][j].add(MT[i][k].multiply(MX[k][j]));
                }
            }
        }
        return resultado;
    }

    ///////resultado de la inversa Gaus Jordan/////////////
    public BigDecimal[][] Inversa(BigDecimal[][] matriz) {
        int n = matriz.length;
        BigDecimal[][] matrizJordan = new BigDecimal[n][2 * n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrizJordan[i][j] = matriz[i][j];
                matrizJordan[i][j + n] = (i == j) ? BigDecimal.ONE : BigDecimal.ZERO;
            }
        }
        //// jordan operacion/////
        for (int i = 0; i < n; i++) {
            BigDecimal pivote = matrizJordan[i][i];
            if (pivote.compareTo(BigDecimal.ZERO) == 0) {
                throw new IllegalArgumentException("La matriz no es invertible.");
            }

            for (int j = 0; j < 2 * n; j++) {
                matrizJordan[i][j] = matrizJordan[i][j].divide(pivote, 20, BigDecimal.ROUND_HALF_UP);
            }

            // Hacer ceros en la columna i de todas las demás filas
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    BigDecimal factor = matrizJordan[j][i];
                    for (int k = 0; k < 2 * n; k++) {
                        matrizJordan[j][k] = matrizJordan[j][k].subtract(factor.multiply(matrizJordan[i][k]));
                    }
                }
            }
        }

        BigDecimal[][] inversa = new BigDecimal[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inversa[i][j] = matrizJordan[i][j + n];
            }
        }

        return inversa;
    }



    /////////multiplicacion de X transpuesta por el vector Y///////
    public BigDecimal[] MultiplicacionMTporY(int potencia) {
        // invoca  la matriz transpuesta de X
        BigDecimal[][] MT = polinomio.matrizXTranspuesta(potencia, data.X);

        BigDecimal[] MY = polinomio.matrizY(data.y);


        BigDecimal[] total = new BigDecimal[MT.length];

        for (int i = 0; i < MT.length; i++) {
            total[i] = BigDecimal.ZERO;
            for (int j = 0; j < MY.length; j++) {
                total[i] = total[i].add(MT[i][j].multiply(MY[j]));
            }
        }

        return total;
    }

}
