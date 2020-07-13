import java.util.ArrayList;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;

public class HostAgent extends Agent {
    public static MainFrame frame = null;
    public static int numero_peces = 10;
    public static ArrayList<FishAgent> lista_peces = new ArrayList<FishAgent>();
    public static boolean ENABLED = false;

    @Override
    public void setup() {
        try {
            DFAgentDescription dfd = new DFAgentDescription();
            dfd.setName(getAID());
            DFService.register(this, dfd);

            frame = new MainFrame(this);
            frame.setVisible(true);

            ParallelBehaviour parallelBehaviour = new ParallelBehaviour();
            parallelBehaviour.addSubBehaviour(new CyclicBehaviour() {

                @Override
                public void action() {
                    frame.panel_principal.repaint();
                }
            });
        } catch (Exception e) {
            System.err.println("exception" + e);
            e.printStackTrace();
        }
    }
}