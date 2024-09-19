import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;

public class CuadroConImagenDeFondo extends JPanel {
    private BufferedImage imagenFondo;
    private BufferedImage texturaPiedra;
    private BufferedImage texturaPiedra2;
    private BufferedImage texturaPiedra3;
    private BufferedImage texturaPiedra4;
    private BufferedImage texturaPiedra5;

    private int[] yPoints = {-165, -165, 0, 0}; // Coordenadas y iniciales de la primera figura
    private int[] yPointsFinal = {450, 450, 615, 615}; // Coordenadas y finales de la primera figura
    
    private int[] yPoints1 = {-260, -260, 0, 0}; // Coordenadas y iniciales de la segunda figura
    private int[] yPoints1Final = {350, 350, 610, 610}; // Coordenadas y finales de la segunda figura
   
    int[] yPoints2 = {-190, -190, 0, 0}; // Coordenadas y de los vértices
    private int[] yPoints2Final = {350, 350, 540, 540}; // Coordenadas y de los vértices
    
    int[] yPoints3 = {-200, -200, 0, 0}; // Coordenadas y de los vértices
    private int[] yPoints3Final = {360, 360, 560, 560}; // Coordenadas y de los vértices

    int[] yPoints4 = {-195, -195, 0, 0}; // Coordenadas y de los vértices
    private int[] yPoints4Final = {360, 350, 545, 545}; // Coordenadas y de los vértices

    int[] yPoints5 = {-170, -170, 0, 0}; // Coordenadas y de los vértices
    private int[] yPoints5Final = {360, 360, 530, 530}; // Coordenadas y de los vértices

    int[] yPoints6 = {-60, -60, 0, 0}; // Coordenadas y de los vértices
    private int[] yPoints6Final = {300, 300, 360, 360}; // Coordenadas y de los vértices

    private Timer timer;

    public CuadroConImagenDeFondo() {
        try {
            imagenFondo = ImageIO.read(new File("src/images/xochi.jpg"));
            texturaPiedra = ImageIO.read(new File("src/images/textura.jpg"));
            texturaPiedra2 = ImageIO.read(new File("src/images/textura2.jpg"));
            texturaPiedra3 = ImageIO.read(new File("src/images/textura3.jpg"));
            texturaPiedra4 = ImageIO.read(new File("src/images/textura4.jpg")); 
            texturaPiedra5 = ImageIO.read(new File("src/images/textura5.jpg"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Inicia la animación
        iniciarAnimacion();
    }

private int figuraActual = 0; // Variable para mantener el índice de la figura actual

private void iniciarAnimacion() {
    timer = new Timer(50, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Actualiza las coordenadas Y de los vértices de los polígonos
            actualizarCoordenadas();

            // Vuelve a dibujar el panel
            repaint();
        }
    });
    timer.start();
}

private void actualizarCoordenadas() {
    switch (figuraActual) {
        case 0:
            // Actualiza las coordenadas Y de la primera figura
            for (int i = 0; i < yPoints.length; i++) {
                if (yPoints[i] < yPointsFinal[i]) {
                    yPoints[i] += 5; // Ajusta la velocidad de caída según lo necesites
                }
            }
            break;
        case 1:
            // Actualiza las coordenadas Y de la segunda figura
            for (int i = 0; i < yPoints1.length; i++) {
                if (yPoints1[i] < yPoints1Final[i]) {
                    yPoints1[i] += 5; // Ajusta la velocidad de caída según lo necesites
                }
            }
            break;
        case 2:
            // Actualiza las coordenadas Y de la tercera figura
            for (int i = 0; i < yPoints2.length; i++) {
                if (yPoints2[i] < yPoints2Final[i]) {
                    yPoints2[i] += 4; // Ajusta la velocidad de caída según lo necesites
                }
            }
            break;
        case 3:
            // Actualiza las coordenadas Y de la cuarta figura
            for (int i = 0; i < yPoints3.length; i++) {
            if (yPoints3[i] < yPoints3Final[i]) {
                yPoints3[i] += 5; // Ajusta la velocidad de caída según lo necesites
            }
        }

            break;
        case 4:
            // Actualiza las coordenadas Y de la quinta figura
            for (int i = 0; i < yPoints4.length; i++) {
            if (yPoints4[i] < yPoints4Final[i]) {
                yPoints4[i] += 5; // Ajusta la velocidad de caída según lo necesites
            }
        }
            break;
        case 5:
            // Actualiza las coordenadas Y de la sexta figura
            for (int i = 0; i < yPoints5.length; i++) {
            if (yPoints5[i] < yPoints5Final[i]) {
                yPoints5[i] += 5; // Ajusta la velocidad de caída según lo necesites
            }
        }

            break;
            
        case 6:
            // Actualiza las coordenadas Y de la septima figura
            for (int i = 0; i < yPoints6.length; i++) {
            if (yPoints6[i] < yPoints6Final[i]) {
                yPoints6[i] += 3; // Ajusta la velocidad de caída según lo necesites
            }
        }


            break;
        
    }

    // Verifica si la figura actual ha alcanzado sus coordenadas finales
    boolean figuraTerminada = false;
    switch (figuraActual) {
        case 0:
            figuraTerminada = Arrays.equals(yPoints, yPointsFinal);
            break;
        case 1:
            figuraTerminada = Arrays.equals(yPoints1, yPoints1Final);
            break;
        case 2:
            figuraTerminada = Arrays.equals(yPoints2, yPoints2Final);
            break;
            
        case 3:
            figuraTerminada = Arrays.equals(yPoints3, yPoints3Final);
            break;
        case 4:
            figuraTerminada = Arrays.equals(yPoints4, yPoints4Final);
            break;
        case 5:
            figuraTerminada = Arrays.equals(yPoints5, yPoints5Final);
            break;
        case 6:
            figuraTerminada = Arrays.equals(yPoints6, yPoints6Final);
            break;
      
    }

    // Si la figura actual ha terminado de moverse, pasa a la siguiente figura
    if (figuraTerminada) {
        figuraActual++;
    }

    // Si todas las figuras han alcanzado sus coordenadas finales, detiene la animación
    if (figuraActual >= 7) { // Donde totalFiguras es la cantidad total de figuras
        timer.stop();
    }
}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Dibuja la imagen de fondo
        if (imagenFondo != null) {
            g2d.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }

        // Dibuja las figuras con sus texturas y coordenadas actualizadas
        if (texturaPiedra != null && texturaPiedra2 != null) {
            //PRIMERA FIGURA
            TexturePaint textura = new TexturePaint(texturaPiedra, new Rectangle(0, 0, texturaPiedra.getWidth(), texturaPiedra.getHeight()));
            g2d.setPaint(textura);
            int[] xPoints = {300, 935, 935, 170}; // Coordenadas x de los vértices
            int nPoints = 4; // Número de vértices del polígono
            Polygon poligono = new Polygon(xPoints, yPoints, nPoints);
            g2d.fillPolygon(poligono);

            //SEGUNDA FIGURA
            TexturePaint textura1 = new TexturePaint(texturaPiedra2, new Rectangle(0, 0, texturaPiedra2.getWidth(), texturaPiedra2.getHeight()));
            g2d.setPaint(textura1);
            int[] xPoints1 = {1400, 1645, 1645, 1400}; // Coordenadas x de los vértices
            int nPoints1 = 4; // Número de vértices del polígono
            Polygon poligono1 = new Polygon(xPoints1, yPoints1, nPoints1);
            g2d.fillPolygon(poligono1);
            
            //TERCERA FIGURA
            TexturePaint textura2 = new TexturePaint(texturaPiedra, new Rectangle(0, 0, texturaPiedra.getWidth(), texturaPiedra.getHeight()));
            g2d.setPaint(textura2);
            int[] xPoints2 = {300, 935, 935, 300}; // Coordenadas x de los vértices
            int nPoints2 = 4; // Número de vértices del polígono
            Polygon poligono2 = new Polygon(xPoints2, yPoints2, nPoints2);
            g2d.fillPolygon(poligono2);
            
            //CUARTA FIGURA
            TexturePaint textura3 = new TexturePaint(texturaPiedra2, new Rectangle(0, 0, texturaPiedra2.getWidth(), texturaPiedra2.getHeight()));
            g2d.setPaint(textura3);
            int[] xPoints3 = {935, 1303, 1303, 935}; // Coordenadas x de los vértices
            int nPoints3 = 4; // Número de vértices del polígono
            Polygon poligono3 = new Polygon(xPoints3, yPoints3, nPoints3);
            g2d.fillPolygon(poligono3);
            
            //QUINTA FIGURA
            TexturePaint textura4 = new TexturePaint(texturaPiedra3, new Rectangle(0, 0, texturaPiedra3.getWidth(), texturaPiedra3.getHeight()));
            g2d.setPaint(textura4);
            int[] xPoints4 = {1300, 1400, 1400, 1300}; // Coordenadas x de los vértices
            int nPoints4 = 4; // Número de vértices del polígono
            Polygon poligono4 = new Polygon(xPoints4, yPoints4, nPoints4);
            g2d.fillPolygon(poligono4);
            
            //SEXTA FIGURA 
            TexturePaint textura5 = new TexturePaint(texturaPiedra4, new Rectangle(0, 0, 400,150));
            g2d.setPaint(textura5);
            int[] xPoints5 = {1645, 1980, 1980, 1645}; // Coordenadas x de los vértices
            int nPoints5 = 4; // Número de vértices del polígono
            Polygon poligono5 = new Polygon(xPoints5, yPoints5, nPoints5);
            g2d.fillPolygon(poligono5);
            
            
            //SEPTIMA FIGURA 
            TexturePaint textura6 = new TexturePaint(texturaPiedra5, new Rectangle(50, 50, 400,150));
            g2d.setPaint(textura6);
            int[] xPoints6 = {300, 1930, 1930, 300}; // Coordenadas x de los vértices
            int nPoints6 = 4; // Número de vértices del polígono
            Polygon poligono6 = new Polygon(xPoints6, yPoints6, nPoints6);
            g2d.fillPolygon(poligono6);




        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Cuadro con Textura de Piedra");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new CuadroConImagenDeFondo());
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
