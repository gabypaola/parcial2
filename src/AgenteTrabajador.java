import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import java.math.BigDecimal;

public class AgenteTrabajador extends Agent {
    dataset data = new dataset();

    Polinomio Polinomio = new Polinomio();

    operaciones Operacion = new operaciones();

    Resultado Resultado=new Resultado();

    discreteMathematics discret = new discreteMathematics();

    SimpleIR prediccion = new SimpleIR();

    resultadoLineal resul =new resultadoLineal();

    //Prediciones predecir = new Prediciones();

    int potencia=3;

    public void setup(){

        System.out.println("AgenteTrabajador inicializado ");
        //espero el mensaje del coordinador
        MessageTemplate template = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
        ACLMessage recibeMensaje = blockingReceive(template);

        if(recibeMensaje != null){
            System.out.println("AgenteTrabajador recibio el mensaje: ");

            double[] X = data.X;
            double[] y= data.y;
            double[] C= data.C;
            int potencia= data.potencia;
            int n= data.n;
            double[] coeficientes = {2.5, -1.3, 0.05 };

            // llamar a mis operaciones polinomiales

            BigDecimal[][] mX = Polinomio.matrizX(potencia,X);
            BigDecimal[][] matrizXT = Polinomio.matrizXTranspuesta(potencia,X);
            BigDecimal[][] productoMX = Operacion.MultiplicacionMatrices(potencia);
            BigDecimal[] multiplicacion = Operacion.MultiplicacionMTporY(potencia);
            BigDecimal[][] inversa = Operacion.Inversa(matrizXT);
            BigDecimal[] resultadoFinal = Resultado.resultado(Operacion.Inversa(matrizXT),Operacion.MultiplicacionMTporY(potencia));


            // llamar a mis operaciones lineales

            double B0 = resul.operacionB0(X,y,n);
            double B1 = resul.operacionB1(X,y,n);
            double YHat = resul.YdeHat(X,y,n);
            //double [] prediccion = predecir.calcularPredicciones(C,coeficientes);
            double predicciones = resul.predicciones(C);






            //cambiarlos a arrayToString
            String mXst = arrayToString(mX);
            String matrizXTst = arrayToString(matrizXT);
            String productost = arrayToString(productoMX);
            String multiplicacionst = arrayToString(multiplicacion);
            String inversast = arrayToString(inversa);
            String totalst = arrayToString(resultadoFinal);

            String B0st= String.valueOf(B0);
            String B1st = String.valueOf(B1);
            String YHatst = String.valueOf(YHat);
            String predecirst = String.valueOf(predicciones);




            RecibirResultados resultados = new RecibirResultados(mXst,matrizXTst, productost, multiplicacionst, inversast, totalst, B0st,B1st,YHatst,predecirst); //llamando a la clase
            comunicarResultado(resultados); //manda los resultados


        }

    }
    private void comunicarResultado(RecibirResultados resultado){ // comunica con la clase recibir resultados

        try {
            ACLMessage mensaje = new ACLMessage(ACLMessage.INFORM);
            mensaje.addReceiver(new AID("AgenteResultado",AID.ISLOCALNAME));
            mensaje.setContentObject(resultado);
            send(mensaje);
            System.out.println("mensaje enviado al agente resultado: ");

        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("no se pudo enviar el mensaje: ");
        }

    }
    private String arrayToString(BigDecimal[][] matrix) {//convierte la matriz x a un tostring
        StringBuilder sb = new StringBuilder();
        for (BigDecimal[] row : matrix) {
            for (BigDecimal val : row) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private String arrayToString(BigDecimal[] array) {
        StringBuilder sb = new StringBuilder();
        for (BigDecimal val : array) {
            sb.append(val).append(" ");
        }
        return sb.toString();
    }



}
