public class Prediciones {

    public double[] calcularPredicciones(double[] C, double[] coeficientes) {
        double[] predicciones = new double[C.length];

        for (int i = 0; i < C.length; i++) {
            double resultado = 0.0;

            for (int j = 0; j < coeficientes.length; j++) {

                resultado += coeficientes[j] * Math.pow(C[i], j);
            }

            predicciones[i] = resultado;
        }

        return predicciones;
    }

}
