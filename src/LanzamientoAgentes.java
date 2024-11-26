import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;


public class LanzamientoAgentes {

    public static void main(String[] args){
        Runtime runtime = Runtime.instance();//interface
        Profile profile = new ProfileImpl();//perfil del agente
        profile.setParameter(Profile.MAIN_HOST,"localhost");
        profile.setParameter(Profile.GUI,"true");//interface grafica de jade
        ContainerController LanzamientoAgentes = runtime.createMainContainer(profile);

        try{
            AgentController administrador = LanzamientoAgentes.createNewAgent("AgenteAdministrador",AgenteAdministrador.class.getName(),null);
            AgentController trabajador = LanzamientoAgentes.createNewAgent("AgenteTrabajador", AgenteTrabajador.class.getName(),null);
            AgentController resultado = LanzamientoAgentes.createNewAgent("AgenteResultado", AgenteResultado.class.getName(),null);

            administrador.start();
            trabajador.start();
            resultado.start();
        }
        catch (StaleProxyException e) {
            e.printStackTrace();
        }

    }
}
