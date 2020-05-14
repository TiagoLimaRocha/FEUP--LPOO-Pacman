package audio;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.File;


public class SoundFX {

    private File soundFile;

    public SoundFX(String filename){
        this.soundFile = new File(filename);
    }

    public File getSoundFile(){ return soundFile; }

    public Clip play(File sound){
        Clip clip = null;

        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.start();

            Thread.sleep(80);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return clip;
    }

    public Clip loopPlay(File sound){
        Clip clip = null;

        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return clip;
    }

    public void stop(Clip soundClip){
        soundClip.stop();
    }
}