import java.io.File;

import javax.swing.JPanel;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.binding.RuntimeUtil;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

public class audioPlayer extends JPanel{

	String vlcPath = "C:\\Program Files\\VideoLAN\\VLC";
	EmbeddedMediaPlayer mediaPlayer;
	
	public audioPlayer() {

		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), vlcPath);
		Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
		mediaPlayer = new MediaPlayerFactory().newEmbeddedMediaPlayer();
		mediaPlayer.prepareMedia("/src/Assets/home.mp3", null);
//		mediaPlayer.play();
	}

}
