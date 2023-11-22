package Game.Main;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.sound.sampled.*;

public class AmbianceMusicPlayer {

  private static AmbianceMusicPlayer instance;

  private static final Map<String, String> SOUND_MAP = new HashMap<>();
  private Clip currentClip; 

  static {
    SOUND_MAP.put("Menu", "src/Resource/Song/Ambiance.wav");
    SOUND_MAP.put("InGame", "src/Resource/Song/Game.wav");
  }

  private AmbianceMusicPlayer() {}

  public static AmbianceMusicPlayer getInstance() {
    if (instance == null) {
      instance = new AmbianceMusicPlayer();
    }
    return instance;
  }

  public void playSound(String title) {
    stopSound(); 

    String filePath = SOUND_MAP.get(title);
    if (filePath != null) {
      currentClip = createAndStartClip(filePath);
      setVolume(0.6f); 
      addLoopingListener(currentClip);
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

  private void addLoopingListener(Clip clip) {
    clip.addLineListener(event -> {
      if (event.getType() == LineEvent.Type.STOP) {
        clip.setFramePosition(0); 
        clip.start(); 
      }
    });
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
