import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class Home extends JFrame implements ActionListener, MenuListener{
	
	private JMenuBar mb;
	private JMenu voucherMenu, eventMenu, promoMenu;
	private JPanel bgPanel, videoPanel;
	private JButton signinBtn, exitBtn;
	private static boolean status = false;
	static User user;
	
	audioPlayer audioplayer = new audioPlayer();
	
	public Home(User user) {
		
		this.user = user;
	}
	
	public Home(boolean status, User user) {
		
		this.status = status;
		this.user = user;
		
		initJPanel();
		initJFrame();
		audioplayer.mediaPlayer.play();
		
	}
	
	private void initJFrame() {
		setSize(1050, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("JP ID");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setVisible(true);
	}
	
	private void initJPanel() {
		bgPanel = new JPanel();
		bgPanel.setLayout(null);
		
		initComponent();
		addComponent();
	}
	
	private void addComponent() {
		
		bgPanel.add(signinBtn);
		bgPanel.add(exitBtn);
		bgPanel.add(videoPanel);
		add(bgPanel);
		
	}
	
	private void initComponent() {
		
		try {
			bgPanel = new JPanel() {
				
				Image img = ImageIO.read(new File("src/Assets/red.png"));
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponents(g);
					g.drawImage(img, 0, -40, 1050, 600, null);
				}
			};
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bgPanel.setLayout(null);
		videoPanel = new JPanel(new GridLayout(1,1));
		
		voucherMenu = initJMenu("Voucher", Color.white, new EmptyBorder(0,0,0,15));
		eventMenu = initJMenu("Event", Color.white, new EmptyBorder(0,0,0,15));
		promoMenu = initJMenu("Promo", Color.white, new EmptyBorder(0,0,0,15));
		
		voucherMenu.addMenuListener(this);
		eventMenu.addMenuListener(this);
		promoMenu.addMenuListener(this);
		
		mb = initJMenuBar(new Color(169, 68, 86), new EmptyBorder(10,0,10,10));
		
		mb.add(voucherMenu);
		mb.add(eventMenu);
		mb.add(promoMenu);
		
		setJMenuBar(mb);
		
		signinBtn = initJButton("Sign In", new Color(169, 68, 86), Color.white, 70, 480);
		exitBtn = initJButton("Exit", new Color(169, 68, 86), Color.white, 890, 480);
		
		signinBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		
	}
	
	private JMenuBar initJMenuBar(Color col, Border bd) {
		JMenuBar mb = new JMenuBar();
		mb.setBackground(col);
		mb.setBorder(bd);
		return mb;
	}
	
	private JMenu initJMenu(String str, Color col, Border bd) {
		JMenu men = new JMenu(str);
		men.setForeground(col);
		men.setBorder(bd);
		return men;
	}
	
	private JButton initJButton(String str, Color colbg, Color colfnt, int x, int y) {
		JButton btn = new JButton(str);
		btn.setBackground(colbg);
		btn.setForeground(colfnt);
		btn.setBounds(x, y, 77, 25);
		return btn;
	}
	
	public void redirectToSignin() {
		new Signin(status, user);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == signinBtn) {
			if(status == false) {
				redirectToSignin();
				audioplayer.mediaPlayer.pause();
				this.dispose();				
			}
			else {
				JOptionPane.showMessageDialog(null, "Anda sudah sign in", "Error Message", JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			this.dispose();
			audioplayer.mediaPlayer.pause();
		}
		
	}
	
	public static void main(String[] args) {
		new Home(status, user);
	}

	@Override
	public void menuSelected(MenuEvent e) {
		if(e.getSource() == voucherMenu) {
//			new voucherPage(status, user);
//			this.dispose(); 
//			audioplayer.mediaPlayer.pause();
			if(status == false) {
				new Signin(status, user);
				audioplayer.mediaPlayer.pause();
				this.dispose();
			}
			else {
				new voucherPage(status, user);
				this.dispose();
				audioplayer.mediaPlayer.pause();
			}
		}
		else if(e.getSource() == eventMenu) {
//			new Event(status, user);
//			this.dispose();
//			audioplayer.mediaPlayer.pause();
			if(status == false) {
				new Signin(status, user);
				audioplayer.mediaPlayer.pause();
				this.dispose();
			}
			else {
				new Event(status, user);
				this.dispose();
				audioplayer.mediaPlayer.pause();
			}
		}
		else {
//			new promo(status, "src/Assets/Y540.jpg", "Nama : Legion Y540", 17999999, 20000, user);
//			this.dispose();
//			audioplayer.mediaPlayer.pause();
//			new dragPanel();
			if(status == false) {
				new Signin(status, user);
				this.dispose();
				audioplayer.mediaPlayer.pause();
			}
			else {
				new promo(status, "src/Assets/Y540.jpg", "Nama : Legion Y540", 17999999, 20000, user);
				this.dispose();
				audioplayer.mediaPlayer.pause();
			}

		}
		
	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}


}
