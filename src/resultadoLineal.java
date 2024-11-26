public class resultadoLineal {

    public  double C;
    SimpleIR SimpleIR = new SimpleIR(); // instancia de discretMaths


    public double predicciones(double [] C){
        for (int i=0; i<C.length; i++){
            double x1 = C[i];
            double y1= 168 + 23 * x1;

            System.out.println("prediccion para x1 = " + x1 + ": y = 168 + 23 * " + x1 + " = " + y1);
        }
        return 0;
    }



    public double operacionB1(double []X, double []y, int n){
        double resultadoOperacion = SimpleIR.dividendoB1(X,y,n) / SimpleIR.divisorB1(X,y,n);
        return  resultadoOperacion;
    }

    public  double operacionB0(double[]X, double []y, int n){
        double resultadooperacionB0 = SimpleIR.dividendoB0(X,y,n) / SimpleIR.divisorB0(X,y,n);
        return resultadooperacionB0;
    }

    public double YdeHat(double []X, double []y, int n){
        for (int i=0; i<X.length; i++){
            double x1 = X[i];
            double YHat= operacionB1(X,y,n) * x1 + operacionB0(X,y,n);

            System.out.println("Y de hat para X = " + x1 + " = " + YHat);
        }
        return 0;
    }


}
