package Game.Main;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.sound.sampled.*;

public class SoundPlayer {

  private static SoundPlayer instance;

  private static final Map<String, String> SOUND_MAP = new HashMap<>();
  private Clip currentClip;

  static {
    SOUND_MAP.put("Projectil", "src/Resource/Song/Projectil.wav");
    SOUND_MAP.put("Lose", "src/Resource/Song/Lose.wav");
    SOUND_MAP.put("Death", "src/Resource/Song/EnemyDeath.wav");
  }

  private SoundPlayer() {}

  public static SoundPlayer getInstance() {
    if (instance == null) {
      instance = new SoundPlayer();
    }
    return instance;
  }

  public void playSound(String title) {
    stopSound();

    String filePath = SOUND_MAP.get(title);
    if (filePath != null) {
      currentClip = createAndStartClip(filePath);
      setVolume(0.6f);
    } else {
      System.out.println("Invalid sound title");
    }
  }

  public void stopSound() {
    if (currentClip != null && currentClip.isRunning()) {
      currentClip.stop();
      currentClip.close();
    }
  }

  public void setVolume(float volume) {
    if (currentClip != null) {
      FloatControl gainControl = (FloatControl) currentClip.getControl(
        FloatControl.Type.MASTER_GAIN
      );
      float range = gainControl.getMaximum() - gainControl.getMinimum();
      float gain = (range * volume) + gainControl.getMinimum();
      gainControl.setValue(gain);
    }
  }

  private Clip createAndStartClip(String filePath) {
    Clip clip = null;
    try {
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
        new File(filePath)
      );

      clip = AudioSystem.getClip();

      clip.open(audioInputStream);

      clip.start();

      return clip;
    } catch (
      UnsupportedAudioFileException | LineUnavailableException | IOException e
    ) {
      e.printStackTrace();
    }
    return null;
  }
}
