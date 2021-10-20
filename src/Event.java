import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.RuntimeUtil;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.videosurface.CanvasVideoSurface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Event extends JFrame implements ActionListener{
	
	private JPanel topPanel, backPanel, titlePanel, midPanel, videoPanel;
	private JLabel titleLbl;
	private JButton backBtn;
	private boolean status;
	User user;
	
	String vlcPath = "C:\\Program Files\\VideoLAN\\VLC";
	EmbeddedMediaPlayerComponent mediaPlayer;

	public Event(boolean status, User user) {
		
		this.status = status;
		this.user = user;
		
		initComponent();
		addComponent();
		
		initJFrame();
		mediaPlayer.getMediaPlayer().playMedia("/src/Assets/legion.mp4", null);

	}
	
	private void addComponent() {
		
		backPanel.add(backBtn);
		titlePanel.add(titleLbl);
		
		topPanel.add(backPanel);
		topPanel.add(titlePanel);
		videoPanel.add(mediaPlayer);
		midPanel.add(videoPanel);
		
		topPanel.add(backPanel, BorderLayout.WEST);
		topPanel.add(titlePanel, BorderLayout.CENTER);
		
		add(topPanel, BorderLayout.NORTH);
		add(midPanel, BorderLayout.CENTER);
		
	}

	private void initComponent() {
		
		topPanel = new JPanel(new BorderLayout());
		topPanel.setBackground(Color.black);
		
		titleLbl = initJLabel("JP.ID Promo Event Item", 30, Color.white);
		
		backPanel = new JPanel();
		backPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		backPanel.setBackground(Color.black);
		titlePanel = new JPanel();
		titlePanel.setBorder(new EmptyBorder(5, -50, 0, 0));
		titlePanel.setBackground(Color.black);
		midPanel = new JPanel(new BorderLayout());
		videoPanel = new JPanel(new GridLayout(1,1));
		
		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), vlcPath);
		mediaPlayer = new EmbeddedMediaPlayerComponent();
		
		backBtn = new JButton("Back");
		backBtn.setPreferredSize(new Dimension(65, 30));
		backBtn.setBackground(new Color(242, 226, 213));
		backBtn.setForeground(new Color(169, 68, 86));
		backBtn.addActionListener(this);
		
	}
	
	private void initJFrame() {
		setSize(1050, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Event");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setVisible(true);
	}
	
	private JLabel initJLabel(String str, int x, Color col) {
		JLabel lbl = new JLabel(str);
		lbl.setFont(new Font("TNR", 0, x));
		lbl.setForeground(col);
		return lbl;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backBtn) {
			new Home(status, user);
			this.dispose();
			mediaPlayer.getMediaPlayer().stop();
		}
		
	}


}
