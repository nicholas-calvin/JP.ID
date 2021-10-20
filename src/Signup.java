import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

public class Signup extends JFrame implements ActionListener{

	private BufferedImage image;
	private JPanel bgPanel, backPanel, titlePanel, topPanel, genderPanel, 
	midPanel, botPanel, unamePanel, genderlblPanel, emailPanel, pwPanel, confirmpwPanel, addressPanel, dobPanel;
	private JRadioButton maleButton, femaleButton;
	private ButtonGroup genderGroup;
	private JButton backBtn, signupBtn;
	private JLabel titleLbl, usernameLbl, genderLbl, emailLbl, pwLbl, 
			confirmpwLbl, addressLbl, dobLbl;
	private JTextField usernameField, emailField, dateField, addressField;
	private JPasswordField pwField, confirmpwField;
	private JDateChooser calendar;
	private boolean status;
	User user;
	
	public Signup() {
		
		initComponent();
		addComponent();
		
		initJFrame();
	}
	
	
	private void initJFrame() {
		setSize(1050, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Sign Up");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setVisible(true);
	}
	
	private void addComponent() {
		
		genderGroup.add(femaleButton);
		genderGroup.add(maleButton);
		genderPanel.add(femaleButton);
		genderPanel.add(maleButton);
		
		backPanel.add(backBtn);
		titlePanel.add(titleLbl);
		
		topPanel.add(backPanel);
		topPanel.add(titlePanel);
		
		unamePanel.add(usernameLbl);
		midPanel.add(unamePanel);
		midPanel.add(usernameField);
		
		genderlblPanel.add(genderLbl);
		midPanel.add(genderlblPanel);
		midPanel.add(genderPanel);
		
		emailPanel.add(emailLbl);
		midPanel.add(emailPanel);
		midPanel.add(emailField);
		
		pwPanel.add(pwLbl);
		midPanel.add(pwPanel);
		midPanel.add(pwField);
		
		confirmpwPanel.add(confirmpwLbl);
		midPanel.add(confirmpwPanel);
		midPanel.add(confirmpwField);
		
		addressPanel.add(addressLbl);
		midPanel.add(addressPanel);
		midPanel.add(addressField);
		
		dobPanel.add(dobLbl);
		midPanel.add(dobPanel);
		midPanel.add(calendar);
//		midPanel.add(dateField);
		
		botPanel.add(signupBtn);
		
		topPanel.add(backPanel, BorderLayout.WEST);
		topPanel.add(titlePanel, BorderLayout.CENTER);
		
		add(bgPanel);
		
		bgPanel.add(topPanel, BorderLayout.NORTH);
		bgPanel.add(midPanel, BorderLayout.CENTER);
		bgPanel.add(botPanel, BorderLayout.SOUTH);
		
	}
	
	private void initComponent() {
		
		try {
			bgPanel = new JPanel(new BorderLayout()) {
				
				Image img = ImageIO.read(new File("src/Assets/600x400.png"));
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
		
		bgPanel.setBorder(new EmptyBorder(100, -20, 100, 550));
		
		topPanel = initJPanel(new BorderLayout());
		topPanel.setBackground(new Color(169, 68, 86));
		
		midPanel = initJPanel(new GridLayout(8,2, 10, 10));
		midPanel.setBackground(new Color(169, 68, 86));
		
		botPanel = initJPanel(new FlowLayout());
		botPanel.setBackground(new Color(169, 68, 86));
		
		titlePanel = initJPanel(new FlowLayout());
		titlePanel.setBackground(new Color(169, 68, 86));
		titlePanel.setBorder(new EmptyBorder(0,-50,0,0));
		
		backPanel = initJPanel(new FlowLayout());
		backPanel.setBackground(new Color(169, 68, 86));
		backPanel.setBorder(new EmptyBorder(0,30,0,0));
		
		genderPanel = initJPanel(new FlowLayout());
		genderPanel.setBackground(new Color(169, 68, 86));
		genderGroup = new ButtonGroup();
		femaleButton = initJRadioButton("Female", new Color(169, 68, 86), Color.white);
		maleButton = initJRadioButton("Male", new Color(169, 68, 86), Color.white);
		
		unamePanel = initJPanel(new FlowLayout());
		unamePanel.setBackground(new Color(169, 68, 86));
		
		genderlblPanel = initJPanel(new FlowLayout());
		genderlblPanel.setBackground(new Color(169, 68, 86));
		
		emailPanel = initJPanel(new FlowLayout());
		emailPanel.setBackground(new Color(169, 68, 86));
		
		pwPanel = initJPanel(new FlowLayout());
		pwPanel.setBackground(new Color(169, 68, 86));
		
		confirmpwPanel = initJPanel(new FlowLayout());
		confirmpwPanel.setBackground(new Color(169, 68, 86));
		
		addressPanel = initJPanel(new FlowLayout());
		addressPanel.setBackground(new Color(169, 68, 86));
		
		dobPanel = initJPanel(new FlowLayout());
		dobPanel.setBackground(new Color(169, 68, 86));
		
		
		backBtn = new JButton("Back");
		signupBtn = new JButton("Sign Up");
		
		backBtn.addActionListener(this);
		signupBtn.addActionListener(this);
		
		
		titleLbl = initJLabel("Sign Up to JP.ID", Color.white);
		titleLbl.setFont(new Font("Times New Roman", 1, 24));
		usernameLbl = initJLabel("UserName", Color.white);
		genderLbl = initJLabel("Gender", Color.white);
		emailLbl = initJLabel("Email", Color.white);
		pwLbl = initJLabel("Password", Color.white);
		confirmpwLbl = initJLabel("Confirm Password", Color.white);
		addressLbl = initJLabel("Address", Color.white);
		dobLbl = initJLabel("DOB", Color.white);
		
		usernameField = initJTextField();
		emailField = initJTextField();
		pwField = new JPasswordField();
		confirmpwField = new JPasswordField();
		addressField = initJTextField();
		dateField = initJTextField();
		
		calendar = new JDateChooser();
		
	}
	
	private JLabel initJLabel(String str, Color col){
		JLabel lbl = new JLabel(str);
		lbl.setForeground(col);
		return lbl;
	}
	
	private JTextField initJTextField() {
		JTextField txt = new JTextField();
		txt.setPreferredSize(new Dimension(100, 10));
		return txt;
	}
	
	private JPanel initJPanel(LayoutManager lm) {
		JPanel pan = new JPanel(lm);
		return pan;
	}
	
	private JRadioButton initJRadioButton(String str, Color col, Color font) {
		JRadioButton rad = new JRadioButton(str);
		rad.setBackground(col);
		rad.setForeground(font);
		return rad;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(image, 0, 30, 1050, 600, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backBtn) {
			new Signin(status, user);
			this.dispose();
		}
		else if(e.getSource() == signupBtn) {
			
			if(usernameField.getText().length() < 5 ||
		       usernameField.getText().length() > 50) {
				JOptionPane.showMessageDialog(null, "Username must be 5-50 characters", "Error Message", JOptionPane.ERROR_MESSAGE);
				Border border = BorderFactory.createLineBorder(Color.red, 1);
				usernameField.setBorder(border);
			}
			else if(!usernameField.getText().contains(" ")) {
				JOptionPane.showMessageDialog(null, "Username must consist 2 words", "Error Message", JOptionPane.ERROR_MESSAGE);
				Border border = BorderFactory.createLineBorder(Color.red, 1);
				usernameField.setBorder(border);
			}
			else if(!emailField.getText().matches("^(.+)@(.+)$")) {
				usernameField.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				JOptionPane.showMessageDialog(null, "Invalid email format", "Error Message", JOptionPane.ERROR_MESSAGE);
				Border border = BorderFactory.createLineBorder(Color.red, 1);
				emailField.setBorder(border);
			}
			else if(pwField.getText().length() < 8 || 
					pwField.getText().length() > 50) {
				emailField.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				JOptionPane.showMessageDialog(null, "Password must be 8-50 characters", "Error Message", JOptionPane.ERROR_MESSAGE);
				Border border = BorderFactory.createLineBorder(Color.red, 1);
				pwField.setBorder(border);
			}
			else if(!pwField.getText().matches("[A-Za-z0-9]+")) {
				JOptionPane.showMessageDialog(null, "Password must be alphanumeric", "Error Message", JOptionPane.ERROR_MESSAGE);
				Border border = BorderFactory.createLineBorder(Color.red, 1);
				pwField.setBorder(border);
			}
			else if(!confirmpwField.getText().contentEquals(pwField.getText())) {
				pwField.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				JOptionPane.showMessageDialog(null, "Password must be the same", "Error Message", JOptionPane.ERROR_MESSAGE);
				Border border = BorderFactory.createLineBorder(Color.red, 1);
				confirmpwField.setBorder(border);
			}
			else if(addressField.getText().length() < 8 ||
					addressField.getText().length() > 50) {
				confirmpwField.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				JOptionPane.showMessageDialog(null, "Address must be 8-50 characters", "Error Message", JOptionPane.ERROR_MESSAGE);
				Border border = BorderFactory.createLineBorder(Color.red, 1);
				addressField.setBorder(border);
			}
			else if(java.time.LocalDate.now().isBefore(convertToLocalDateViaInstant(calendar.getDate())) || 
					java.time.LocalDate.now().isEqual(convertToLocalDateViaInstant(calendar.getDate()))) {
				addressField.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				JOptionPane.showMessageDialog(null, "Date of Birth must be at least yesterday", "Error Message", JOptionPane.ERROR_MESSAGE);
			}
			else {
				User user = new User(emailField.getText(), String.valueOf(pwField.getPassword()));
				System.out.println(user.email);
				System.out.println(user.password);
				Home home = new Home(user);
				home.redirectToSignin();
				this.dispose();
			}
			
		}
		
	}
	
	public LocalDate convertToLocalDateViaInstant(java.util.Date date) {
	    return date.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
}
