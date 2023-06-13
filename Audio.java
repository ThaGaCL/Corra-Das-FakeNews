import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Audio {
    
    public void tocarSom(String filePath){
        Thread thread = new Thread(() -> {
            try {
                // Cria um objeto AudioInputStream usando o arquivo de áudio
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new java.io.File(filePath));

                // Obtém um objeto Clip para reproduzir o áudio
                Clip clip = AudioSystem.getClip();

                // Abre o áudio e carrega em memória para reprodução
                clip.open(audioInputStream);

                // Define o looping infinito
                clip.loop(Clip.LOOP_CONTINUOUSLY);

                // Inicia a reprodução do áudio
                clip.start();
            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                e.printStackTrace();
            }
        });

        thread.start();
    }
}
