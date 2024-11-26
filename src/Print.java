import java.math.BigDecimal;

public class Print {
    dataset data = new dataset();

    Polinomio Polinomio = new Polinomio();

    operaciones Operacion = new operaciones();

    Resultado Resultado=new Resultado();

    int potencia = 3;



    BigDecimal[][] matrizPolinomial = Polinomio.matrizX(potencia, data.X);


    BigDecimal[][]matrizXTranspuesta= Polinomio.matrizXTranspuesta(potencia, data.X);

    BigDecimal[][] multiplicacionMatrices= Operacion.MultiplicacionMatrices(potencia);
    BigDecimal[] matriz= Polinomio.matrizY(data.y);

    BigDecimal[] total= Operacion.MultiplicacionMTporY(potencia);

    BigDecimal[][] inversa = Operacion.Inversa(matrizXTranspuesta);

    BigDecimal[] resul = Resultado.resultado(Operacion.Inversa(matrizXTranspuesta), Operacion.MultiplicacionMTporY(potencia));





    public void  printmatrizX(){
        System.out.println("-------------------resultado matrizX: --------------------------");
        for (int i = 0; i < matrizPolinomial.length; i++) {
            for (int j = 0; j < matrizPolinomial[i].length; j++) {
                System.out.printf("%30.10f" , matrizPolinomial[i][j]);
            }
            System.out.println();
        }

    }


    public void printmatrizTranspuesta(){
        System.out.println("-----------------------Resultado de matriz X transpuesta:---------------------");
        for (int i = 0; i < matrizXTranspuesta.length; i++) {
            for (int j = 0; j < matrizXTranspuesta[0].length; j++) {
                System.out.printf("%30.10f", matrizXTranspuesta[i][j]);
            }
            System.out.println();
        }

    }


    public void printResulMultiplicacion() {
        System.out.println("-------------- Resultado de la operación: ----------------------- ");
        for (int i = 0; i < multiplicacionMatrices.length; i++) {
            for (int j = 0; j < multiplicacionMatrices[i].length; j++) {
                System.out.printf("%30s", multiplicacionMatrices[i][j].toString());
            }
            System.out.println();
        }
    }

    public void printmatrizY() {
        System.out.println("-------------------resultado matrizY: --------------------------");
        for (int i = 0; i < matriz.length; i++) {
            System.out.printf("%30s%n" , matriz[i].toString());
        }
    }

    public void printResulXTY(){
        System.out.println("-------------------resultado multiplicacion XT por Y: --------------------------");
        for(int i = 0; i < total.length; i++){
            System.out.printf("%30s%n", total[i].toString());
        }
    }


    public void printInversa() {
        System.out.println("--------------- Resultado de la matriz inversa ------: ");
        for (int i = 0; i < inversa.length; i++) {
            for (int j = 0; j < inversa[i].length; j++) {
                System.out.printf("%30.8f", inversa[i][j].doubleValue());
            }
            System.out.println();
        }
    }

    public void printTotal(){
        System.out.println("-------------------resultado: --------------------------");
        for(int i = 0; i < resul.length; i++){
            System.out.printf("%30s%n", resul[i].toString());


        }
    }
}
