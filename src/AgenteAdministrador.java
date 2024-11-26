import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;

public class AgenteAdministrador  extends Agent {

    public void setup(){
        System.out.println("AgenteAdministrador Inicializado.");

        ACLMessage message = new ACLMessage(ACLMessage.REQUEST);
        message.addReceiver(new AID("AgenteTrabajador", AID.ISLOCALNAME));
        message.setContent("Calculando numeros!");
        send(message);

    }
}
