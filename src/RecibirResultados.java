import java.math.BigDecimal;
import java.io.Serializable;
public class RecibirResultados implements Serializable{


    private String MX;
    private  String MXT;

    private  String PM;

    private String multiplicacion;

    private String inversa;

    private String totalFinal;

    private String B0;

    private String B1;

    private String YHat;

    private String Prediccion;

    public RecibirResultados(String MX, String MXT, String PM, String multiplicacion, String inversa, String totalFinal, String B0,String B1,String YHat, String Prediccion){
        this.MX = MX;
        this.MXT=MXT;
        this.PM = PM;
        this.multiplicacion= multiplicacion;
        this.inversa =inversa;
        this.totalFinal = totalFinal;
        this.B0=B0;
        this.B1=B1;
        this.YHat= YHat;
        this.Prediccion = Prediccion;

    }

    public String getMX(){
        return MX;
    }

    public String getMXT(){
        return MXT;
    }

    public String getPM(){
        return PM;
    }

    public String getMultiplicacion(){
        return multiplicacion;
    }

    public String getInversa(){
        return inversa;
    }

    public String getTotalFinal(){
        return totalFinal;
    }

    public String getB0(){
        return B0;
    }

    public String getB1(){
        return B1;
    }

    public String getYHat(){
        return YHat;
    }

    public String getPrediccion(){
        return Prediccion;
    }

    public String toString(){
       return  "\n Matriz X: \n " + MX +
        "\n Matriz Transpuesta: \n " + MXT +
               " \n Producto de la MatrizX: \n "+PM +
               "\n Multiplicacion: \n" + multiplicacion +
               "\n Inversa: \n" + inversa +
               "\n Total de la Operacion: \n " + totalFinal +
               "\n Total de B0: \n " + B0 +
               "\n Total B1:  \n " + B1 +
               "\n Total YHAT: \n " + YHat +
               "\n Prediccion: \n " + Prediccion
               ;

    }

}
