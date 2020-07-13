import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.core.behaviours.WakerBehaviour;

public class App extends Agent {
    protected void setup() {
        System.out.println("My name is " + getLocalName());

        /*
         * addBehaviour(new CyclicBehaviour(this) {
         * 
         * @Override public void action() { // TODO Auto-generated method stub
         * System.out.println("Reportarse"); } });
         */

        /*
         * addBehaviour(new OneShotBehaviour(this) {
         * 
         * @Override public void action() { // TODO Auto-generated method stub
         * System.out.println("Caminar"); } }); /
         */

        addBehaviour(new TickerBehaviour(this, 1000) {

            @Override
            protected void onTick() { // TODO Auto-generated method stub
                System.out.println("Agente" + myAgent.getLocalName() + getTickCount());
            }
        });

        addBehaviour(new WakerBehaviour(this, 10000) {
            protected void handleElapsedTimeout() {
                System.out.println("A despertar");
                myAgent.doDelete();
            }
        });

        // addBehaviour(new TresEtapasBehavior());
    }

    public class TresEtapasBehavior extends Behaviour {
        private int etapa = 1;

        // public TresEtapasBehavior(FirstBehaviour fb) { }

        @Override
        public void action() {
            // TODO Auto-generated method stub
            switch (etapa) {
                case 1:
                    System.out.println("operacion 1");
                    break;
                case 2:
                    System.out.println("operacion 2");
                    myAgent.addBehaviour(new OneShotBehaviour(myAgent) {

                        @Override
                        public void action() {
                            // TODO Auto-generated method stub
                            System.out.println("Unico Intento");
                        }
                    });
                    break;
                case 3:
                    System.out.println("operacion 3");
            }
            etapa += 1;
        }

        @Override
        public boolean done() {
            // TODO Auto-generated method stub

            return etapa == 4;
        }
    }
}
