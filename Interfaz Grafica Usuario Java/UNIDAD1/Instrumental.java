import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class Instrumental extends JFrame implements ActionListener {

    private Clip[] clips;
    private boolean[] isPaused;

    public Instrumental() {
        super("Instrumental");
        JPanel panelPrincipal = new JPanel(new GridLayout(4, 4));

        JPanel panelImagenes = new JPanel();
        agregarImagenes(panelImagenes);

        JPanel panelAudios = new JPanel();
        agregarBotonesDeAudio(panelAudios);

        panelPrincipal.add(panelImagenes);
        panelPrincipal.add(panelAudios);

        add(panelPrincipal);

        setLayout(new java.awt.FlowLayout());
        setSize(1070, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);
    }

    private void agregarImagenes(JPanel panel) {
        JLabel label = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();

        ImageIcon paraiso1 = new ImageIcon("paraiso1.jpg");
        ImageIcon paraiso2 = new ImageIcon("paraiso2.jpg");
        ImageIcon paraiso3 = new ImageIcon("paraiso3.jpg");
        ImageIcon paraiso4 = new ImageIcon("paraiso4.jpg");

        int width = 250;
        int height = 200;

        Image image1 = paraiso1.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
        Image image2 = paraiso2.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
        Image image3 = paraiso3.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
        Image image4 = paraiso4.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);

        paraiso1 = new ImageIcon(image1);
        paraiso2 = new ImageIcon(image2);
        paraiso3 = new ImageIcon(image3);
        paraiso4 = new ImageIcon(image4);

        // Establece las imágenes en los JLabel respectivos
        label.setIcon(paraiso1);
        label2.setIcon(paraiso2);
        label3.setIcon(paraiso3);
        label4.setIcon(paraiso4);

        // Añade los JLabel al panel
        panel.add(label);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
    }

    private void agregarBotonesDeAudio(JPanel panel) {
        clips = new Clip[4];
        isPaused = new boolean[4];

        cargarAudio(0, "Aparaiso1.wav");
        cargarAudio(1, "Aparaiso2.wav");
        cargarAudio(2, "Aparaiso3.wav");
        cargarAudio(3, "Aparaiso4.wav");

        for (int i = 0; i < clips.length; i++) {
            JButton playButton = new JButton("Play Aparaiso" + (i + 1));
            JButton pauseButton = new JButton("Pausa/Resume" + (i + 1));

            playButton.setActionCommand("Play_" + i);
            playButton.addActionListener(this);

            pauseButton.setActionCommand("pausa_" + i);
            pauseButton.addActionListener(this);

            panel.add(playButton);
            panel.add(pauseButton);
        }
    }

    private void cargarAudio(int index, String filePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
            clips[index] = AudioSystem.getClip();
            clips[index].open(audioInputStream);
            isPaused[index] = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        int audioIndex = Integer.parseInt(command.split("_")[1]);

        if (command.startsWith("Play")) {
            playAudio(audioIndex);
        } else if (command.startsWith("Pausa")) {
            togglePause(audioIndex);
        }
    }

    private void playAudio(int index) {
        if (index >= 0 && index < clips.length) {
            if (!clips[index].isRunning() || isPaused[index]) {
                clips[index].start();
                isPaused[index] = false;
            }
        }
    }

    private void togglePause(int index) {
        if (index >= 0 && index < clips.length) {
            if (clips[index].isRunning() && !isPaused[index]) {
                clips[index].stop();
                isPaused[index] = true;
            } else if (isPaused[index]) {
                clips[index].start();
                isPaused[index] = false;
            }
        }
    }

    public static void main(String[] args) {
        new Instrumental();
    }
}
