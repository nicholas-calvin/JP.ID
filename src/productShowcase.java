import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class productShowcase extends JFrame implements ActionListener{

	private JPanel mainPanel, buttonPanel;
	private JButton rotateleftBtn, rotaterightBtn, zoominBtn, zoomoutBtn, closeBtn;
	private BufferedImage image;
	private String imgPath;
	private int x = 50, y = 50, width = 600, height = 300;
	private int degree = 0;
	
	public productShowcase(String imgPath) {
		
		this.imgPath = imgPath;
		
		try {
			image = ImageIO.read(new File(imgPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		initComponent();
		addComponent();
		
		initJFrame();
	}
	
	private void addComponent() {
		
		buttonPanel.add(rotateleftBtn);
		buttonPanel.add(rotaterightBtn);
		buttonPanel.add(zoominBtn);
		buttonPanel.add(zoomoutBtn);
		buttonPanel.add(closeBtn);
		
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		add(mainPanel);
	}

	private void initComponent() {
		
		
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBackground(Color.black);
		
		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.black);
		buttonPanel.setBorder(new EmptyBorder(0, 0, 30, 0));
		
		rotateleftBtn = new JButton("Rotate Left");
		rotaterightBtn = new JButton("Rotate Right");
		zoominBtn = new JButton("Zoom in");
		zoomoutBtn = new JButton("Zoom out");
		closeBtn = new JButton("Close");
		
		rotateleftBtn.addActionListener(this);
		rotaterightBtn.addActionListener(this);
		zoominBtn.addActionListener(this);
		zoomoutBtn.addActionListener(this);
		closeBtn.addActionListener(this);
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.rotate(Math.toRadians(degree), x + width/2, y + 20 + height/2);
		g2.drawImage(image, x, y, width, height, null);
	}
	

	private void initJFrame() {
		setSize(700, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Event");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == rotateleftBtn) {
			degree -= 45;
			degree %= 360;
			repaint();
		}
		else if(e.getSource() == rotaterightBtn) {
			degree += 45;
			degree %= 360;
			repaint();
		}
		else if(e.getSource() == zoominBtn) {
			width += 20;
			height += 10;
			repaint();
		}
		else if(e.getSource() == zoomoutBtn) {
			width -= 20;
			height -= 10;
			repaint();
		}
		else if(e.getSource() == closeBtn) {
			this.dispose();
		}
		
	}

}
