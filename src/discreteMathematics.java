public class discreteMathematics {

    //////////Operaciones de B0 y B1////////////////
    public double sumatoriaMultiplicacionXiYi(double [] X, double[] y) {
        int suma = 0;  // Variable para almacenar la suma de las multiplicaciones

        // Realizar la multiplicación y sumar los resultados
        for (int i = 0; i < X.length; i++) {
            suma += X[i] * y[i];
        }

        return suma;  // Devolver el resultado
    }

    public double sumatoriaExponencialX(double [] X, double[] y){
        int suma =0;

        // Iterar sobre el arreglo X, elevar cada elemento al cuadrado y sumar los resultados
        for (int i = 0; i < X.length; i++) {
            suma += X[i] * X[i];  // Elevar al cuadrado y sumar
        }

        return suma;  // Devolver el resultado
    }

    public double NSumatoriaXiYi(double[] X, double[] y, int n) {
        int suma = 0;  // Variable para almacenar la suma de las multiplicaciones

        // Realizar la multiplicación y sumar los resultados
        for (int i = 0; i < X.length; i++) {
            suma += X[i] * y[i];
        }

        return n*suma;  // Devolver el resultado
    }

    public double sumatoriaXi(double [] X){
        int suma=0;

        for(int i=0; i< X.length; i++){
            suma += X[i];
        }
        return suma;
    }

    public double suamtoriaYi(double [] y){
        int suma=0;

        for( int i=0; i< y.length; i++){
            suma += y[i];
        }
        return suma;
    }


    public double NsumatoriaXele2i(double[] X, int n){
        int suma=0;
        for (int i=0; i< X.length; i++){
            suma += X[i] * X[i];
        }
        return n* suma;
    }

    public double sumatoriaXiele2(double [] X){
        double suma=0;
        double resultado = 0;
        double [] potencias = new  double[X.length];
        for (int i = 0; i < X.length; i++) {
            suma += X[i];
        }
        return suma * suma;
    }


}
