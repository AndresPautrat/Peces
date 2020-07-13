package jadefirstexample;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JPanel;

/**
 *
 * @author Willy Ugarte
 */
public class EnvironmentPanel extends JPanel {
    public static int MAX_X = 800, MAX_Y = 700, MEDIDA_BORDE = 20;
    
    public EnvironmentPanel() {
        super();
        Dimension d = getSize();
        MAX_X = d.width;
        MAX_Y = d.height;
        //setBackground(Color.BLACK);
        setOpaque(false);
        setPreferredSize(new Dimension(MAX_X, MAX_Y));
    }
      
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLUE);
        g.setColor(Color.CYAN);
        Dimension d = getSize();
        //g.clearRect(0, 0, d.width, d.height);
        g.fillRect(0, 0, d.width, d.height);
        //g.setColor(Color.RED);
        //System.out.println(d.width + "," + d.height);
        //g.drawOval(HostAgent.x_global + 65, 695, 10, 10);
        //g.drawLine(HostAgent.x_global + 30, 700, HostAgent.x_global + 100, 700);
        if(HostAgent.ENABLED){
            for (FishAgent pez : HostAgent.lista_peces) {
                //g.setColor(Color.BLUE);
                g.setColor(pez.color);
                //System.out.println(pez+"(" + pez.x + "-" + pez.y);
                //g.drawString(pez+"(" + pez.x +"," + pez.y + ")", pez.x, pez.y);
                //g.drawOval(pez.x, pez.y, 70, 20);
                //int largo = 30 + pez.tamano / 20;
                int largo = 10 + 4* pez.tamano / 5;
                int ancho = 5 + pez.tamano / 5;
                switch (pez.status) {
                    case 1:
                        g.fillOval(pez.x, pez.y, largo, ancho);
                        g.setColor(Color.WHITE);
                        g.fillOval(pez.x + largo / 4, pez.y + ancho / 4, largo / 2, ancho / 2);
                        g.setColor(pez.color);
                        break;
                    case 2:
                        g.drawOval(pez.x, pez.y, largo, ancho);
                        break;
                    case 3:
                        g.setColor(pez.color);
                        g.fillOval(pez.x, pez.y, largo, ancho);
                        break;
                    case 4:
                        g.setColor(Color.WHITE);
                        g.fillOval(pez.x, pez.y, largo, ancho);
                        g.setColor(pez.color);
                        g.drawOval(pez.x, pez.y, largo, ancho);
                        break;
                    default:
                        g.fillOval(pez.x, pez.y, largo, ancho);
                        break;
                }
                //g.setColor(Color.WHITE);
                //g.fillOval(pez.x + 5, pez.y + 5, 40, 10);
                //g.setColor(Color.BLUE);
                //g.drawString(pez.x +"," + pez.y + "=" + pez.status + " " + pez.tamano + "(" +largo+","+ancho+ ")", pez.x, pez.y + 15);
            }
        }
        /*Graphics2D g2 = (Graphics2D)g;
        g2.setBackground(Color.BLUE);
        MAX_X = d.width - MEDIDA_BORDE;
        MAX_Y = d.height - MEDIDA_BORDE;
        Image mi_imagen = createImage(d.width, d.height);
        Graphics2D g3 = (Graphics2D)mi_imagen.getGraphics();
        g3.setBackground(Color.BLUE);
        g3.setColor(Color.RED);
        g3.fillOval(10, 10, 50, 20);*/
        /*Image image = cargarImagen("grafico" + File.separator + "campo.png");
        g3.drawImage(image, 0, 0, d.width, d.height, null);
        if(AgenteAnfitrion.HABILITADO_DIBUJAR) {
            for(Jugador jugador : Jugador.JUGADORES)
                jugador.getBase().paint(g3);
            ArrayList<UnidadCampo> unidades_vivas = new ArrayList<UnidadCampo>();
            for(Map.Entry<String, UnidadCampo> entry : UnidadCampo.UNIDADES.entrySet()) {
                if(entry.getValue().estaVivo())
                    unidades_vivas.add(entry.getValue());
                else
                    entry.getValue().paint(g3);
            }
            for(UnidadCampo unidad_viva : unidades_vivas)
                unidad_viva.paint(g3);
        }
        g2.drawImage(mi_imagen, 0, 0, null);*/
    }
}