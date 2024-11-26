import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class AgenteResultado extends Agent {
    public void setup() {
        System.out.println("AgenteResultado inicializado");

        MessageTemplate template = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
        ACLMessage recibeMensaje = blockingReceive(template);//recibiendo el mensaje enviado

        if (recibeMensaje != null) {
            try {
                Object contenido = recibeMensaje.getContentObject();
                if (contenido instanceof RecibirResultados) {
                    RecibirResultados resultados = (RecibirResultados) contenido;
                    //System.out.println("Matriz X recibida: \n" + resultados.getMX());
                    //System.out.println("Matriz Transpuesta recibida: \n" + resultados.getMXT());
                    System.out.println("------------------------Producto de matrices:---------------- \n" + resultados.getPM());
                    System.out.println("------------------------Multiplicacion: --------------------- \n"+ resultados.getMultiplicacion());
                    //System.out.println("Inversa: \n"+ resultados.getInversa());
                    System.out.println("-----------------------Bhat su ejecucion salio bien:  --------------\n"+ resultados.getTotalFinal());

                    System.out.println("---------------------Lineal simple --------------------------------- \n ");
                    System.out.println(" ----------------------B0: -------------- \n" + resultados.getB0());
                    System.out.println(" ----------------------B1: -------------- \n" + resultados.getB1());
                    //System.out.println(" YHat: \n" + resultados.getYHat());
                    //System.out.println(" Prediccion: \n" + resultados.getPrediccion());


                    /// las operaciones que faltan solo imprimir
                } else {
                    System.err.println("El contenido no es del tipo esperado (RecibirResultados).");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
