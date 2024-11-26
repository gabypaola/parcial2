public class SimpleIR {
    public  double C;
    discreteMathematics discreteMathematics = new discreteMathematics(); // instancia de discretMaths


    // formula para calcular el dividendo de B1
    // N*sumatoria(Xi Yi) - sumatoria(Xi) * sumatoria (Yi)

    public double dividendoB1(double[] X, double[] y, int n){
        double resultado = discreteMathematics.NSumatoriaXiYi(X, y, n) - (discreteMathematics.sumatoriaXi(X) * discreteMathematics.suamtoriaYi(y));
        return resultado;
    }

    //(N * sumatoria X^2i )- ((sumatoria Xi)^2)

    public double divisorB1( double [] X, double [] y, int n ){
        double resul = discreteMathematics.NsumatoriaXele2i(X,n) - (discreteMathematics.sumatoriaXiele2(X));
        return resul;
    }



    // formula para calcular el dividendo de B0
    // ((sumatoria X^2i)(sumatoria Yi) -(sumatoria Xi)(sumatoria Xi Yi))

    public double dividendoB0(double [] X, double[]y,int n){
        double resultadoB0= (discreteMathematics.sumatoriaExponencialX(X,y)*(discreteMathematics.suamtoriaYi(y)))-
                (discreteMathematics.sumatoriaXi(X)*discreteMathematics.sumatoriaMultiplicacionXiYi(X,y));
        return resultadoB0;
    }

    //((N * sumatoria X^2i)-((sumatoria Xi)^2))

    public double divisorB0(double [] X, double []y, int n){
        double resulB0 = discreteMathematics.NsumatoriaXele2i(X,n)-(discreteMathematics.sumatoriaXiele2(X));
        return resulB0;
    }

}
