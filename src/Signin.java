import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import uk.co.caprica.vlcj.player.MediaPlayer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class Signin extends JFrame implements ActionListener, MouseListener{

	private JPanel bgPanel, midPanel, leftPanel, rightPanel, regisPanel, titlePanel, signupPanel;
	private JButton backBtn, signinBtn;
	private JLabel titleLbl, emailLbl, pwLbl, regisLbl, clickLbl;
	private JTextField emailField;
	private JPasswordField pwField;
	private boolean status;
	
	User user;
	audioPlayer audioplayer;
	
	public Signin(boolean status, User user) {
		this.user = user;
		
		initComponent();
		addComponent();
		
		initJFrame();
	}

	private void initJFrame() {
		setSize(1050, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Sign In");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setVisible(true);
	}
	
	private void addComponent() {
		
		leftPanel.add(backBtn);
		
		titlePanel.add(titleLbl);
		
		midPanel.add(titlePanel);
		midPanel.add(emailLbl);
		midPanel.add(emailField);
		midPanel.add(pwLbl);
		midPanel.add(pwField);
		
		regisPanel.add(regisLbl);
		regisPanel.add(clickLbl);
		
		midPanel.add(regisPanel);
		midPanel.add(signinBtn);
		
		add(bgPanel);
		
		bgPanel.add(leftPanel, BorderLayout.WEST);
		bgPanel.add(rightPanel, BorderLayout.EAST);
		bgPanel.add(midPanel, BorderLayout.CENTER);
				
	}
	
	private void initComponent() {
		
		try {
			bgPanel = new JPanel(new BorderLayout()) {
				
				Image img = ImageIO.read(new File("src/Assets/400x300.png"));
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponents(g);
					g.drawImage(img, 0, 0, 1050, 600, null);
				}
			};
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		bgPanel.setBorder(new EmptyBorder(120, 300, 170, 300));	
		
		midPanel = initJPanel(new GridLayout(7,1));
		midPanel.setBorder(new EmptyBorder(0, 0, 30, 0));
		midPanel.setBackground(new Color(255, 249, 244));
		
		leftPanel = initJPanel(new FlowLayout());
		leftPanel.setPreferredSize(new Dimension(100, 0));
		leftPanel.setBackground(new Color(255, 249, 0));
		
		rightPanel = initJPanel(new FlowLayout());
		rightPanel.setPreferredSize(new Dimension(100, 0));
		rightPanel.setBackground(new Color(255, 249, 244));
		
		titlePanel = initJPanel(new FlowLayout());
		titlePanel.setBackground(new Color(255, 0, 244));

		regisPanel = initJPanel(new FlowLayout());
		regisPanel.setBackground(new Color(255, 249, 244));

		signupPanel = initJPanel(new FlowLayout());
		signupPanel.setBackground(new Color(255, 249, 244));
		
		backBtn = new JButton("Back");
		signinBtn = new JButton("Sign In");
		
		backBtn.addActionListener(this);
		signinBtn.addActionListener(this);
		
		titleLbl = new JLabel("Sign in to JP.ID");
		titleLbl.setFont(new Font("Times New Roman", 1, 24));
		emailLbl = new JLabel("Email");
		pwLbl = new JLabel("Password");
		regisLbl = new JLabel("No account?");
		clickLbl = new JLabel("Sign Up");
		
		emailField = new JTextField();
		pwField = new JPasswordField();
		
		clickLbl.setForeground(Color.BLUE.darker());
		clickLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		clickLbl.addMouseListener(this);
	}
	
	private JPanel initJPanel(LayoutManager lm) {
		JPanel pan = new JPanel(lm);
		return pan;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backBtn) {
			new Home(status, user);
			this.dispose();
		}
		else if(e.getSource() == signinBtn){
			User inputtedUser = new User(emailField.getText(), pwField.getText());
			if(emailField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Email tidak boleh kosong", "Error Message", JOptionPane.ERROR_MESSAGE);
			}
			else if(pwField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Password tidak boleh kosong", "Error Message", JOptionPane.ERROR_MESSAGE);
			}
			else if(!user.email.contentEquals(inputtedUser.email)
					|| !user.password.contentEquals(inputtedUser.password)) {
				JOptionPane.showMessageDialog(null, "Email/Password Salah", "Error Message", JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "Berhasil Sign In");
				status = true;	
				new Home(true, user);
				this.dispose();
			}
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource() == clickLbl) {
			new Signup();
			this.dispose();
		}
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	


}
