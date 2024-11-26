import java.math.BigDecimal;

public class Resultado {

    operaciones operaciones=new operaciones();

    public BigDecimal[] resultado(BigDecimal[][] Inversa, BigDecimal[] MultiplicacionMTporY) {
        int n = Inversa.length;
        BigDecimal[] resul = new BigDecimal[n];


        for (int i = 0; i < n; i++) {
            resul[i] = BigDecimal.ZERO;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                resul[i] = resul[i].add(Inversa[i][j].multiply(MultiplicacionMTporY[j]));
            }
        }
        BigDecimal[][] resulmatriz = new BigDecimal[1][n];// para imprimir en una sola fila es un arreglo bidimensional
        resulmatriz[0]=resul;
        return resul;
    }
}
