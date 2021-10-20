import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuDragMouseEvent;
import javax.swing.event.MenuDragMouseListener;
import javax.swing.event.MouseInputListener;

public class promo extends JFrame implements ActionListener,MouseInputListener{

	private JPanel bgPanel, topPanel, backPanel, titlePanel,
				midPanel, right, left, bot, contentPanel,
				contenttopPanel, contentmidPanel, contentbotPanel,
				kiriPanel, kananPanel, namaPanel, pricePanel, ongkirPanel;
	private JLabel titleLbl, image1, nama, harga, ongkir, image3, image2;
	private JButton backBtn, usevoucherBtn, showcaseBtn;
	private boolean status;
	private String imgPath, name;
	private Integer price, delivery;
	Point prevPt, imageCorner;
	User user;
	
	public promo(boolean status, String imgPath, String name, Integer price, Integer delivery, User user) {
		this.status = status;
		this.imgPath = imgPath;
		this.name = name;
		this.price = price;
		this.delivery = delivery;
		this.user = user;
		
		initComponent();
		addComponent();
		initJFrame();
	}

	private void addComponent() {
		
		backPanel.add(backBtn);
		titlePanel.add(titleLbl);
		
		topPanel.add(backPanel);
		topPanel.add(titlePanel);
		
		namaPanel.add(nama);
		pricePanel.add(harga);
		ongkirPanel.add(ongkir);
		
		kiriPanel.add(namaPanel);
		kiriPanel.add(pricePanel);
		kiriPanel.add(ongkirPanel);	
		kiriPanel.add(usevoucherBtn);

		kananPanel.add(showcaseBtn);
		
		topPanel.add(backPanel, BorderLayout.WEST);
		topPanel.add(titlePanel, BorderLayout.CENTER);
		
		contenttopPanel.add(image1);
		
		contentmidPanel.add(kiriPanel);
		contentmidPanel.add(kananPanel);
		
		contentbotPanel.add(image2);
		contentbotPanel.add(image3);		
		
		contentPanel.add(contenttopPanel, BorderLayout.NORTH);
		contentPanel.add(contentmidPanel, BorderLayout.CENTER);
		contentPanel.add(contentbotPanel, BorderLayout.SOUTH);
		
		midPanel.add(contentPanel, BorderLayout.CENTER);
		
		add(bgPanel);
		bgPanel.add(topPanel, BorderLayout.NORTH);
		bgPanel.add(midPanel, BorderLayout.CENTER);
		bgPanel.add(right, BorderLayout.EAST);
		bgPanel.add(left, BorderLayout.WEST);
		bgPanel.add(bot, BorderLayout.SOUTH);
	}

	private void initComponent() {
		
		try {
			bgPanel = new JPanel(new BorderLayout()) {
				
				Image img = ImageIO.read(new File("src/Assets/voucherpage.png"));
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
		
		topPanel = new JPanel(new BorderLayout());
		topPanel.setBackground(new Color(0, 0, 0, 0));
		topPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		titleLbl = initJLabel("JP.ID Promo Event Item", 20, Color.white);
		
		backPanel = new JPanel();
		backPanel.setBorder(new EmptyBorder(10, 10, 0, 10));
		backPanel.setBackground(new Color(0, 0, 0, 0));
		titlePanel = new JPanel();
		titlePanel.setBorder(new EmptyBorder(5, -100, 0, 0));
		titlePanel.setBackground(new Color(0, 0, 0, 0));
		
		right = new JPanel();
		right.setPreferredSize(new Dimension(250, 0));
		right.setBackground(new Color(0, 0, 0, 0));
		left = new JPanel();
		left.setPreferredSize(new Dimension(250, 0));
		left.setBackground(new Color(0, 0, 0, 0));
		bot = new JPanel();
		bot.setPreferredSize(new Dimension(0, 10));
		bot.setBackground(new Color(0, 0, 0, 0));
		
		midPanel = new JPanel(new BorderLayout());
		midPanel.setBorder(new EmptyBorder(10, 70, 10, 70));
		midPanel.setBackground(new Color(0, 0, 0, 70));
		
		contentPanel = new JPanel(new BorderLayout());
		contentPanel.setBackground(new Color(0, 0, 0));

		contenttopPanel = new JPanel();
		contenttopPanel.setBackground(new Color(0, 0, 0));
		
		contentmidPanel = new JPanel();
		contentmidPanel.setBackground(new Color(0, 0, 0));
		kiriPanel = new JPanel(new GridLayout(4, 1, 0, 15));
		kiriPanel.setBackground(new Color(0, 0, 0));
		kiriPanel.setBorder(new EmptyBorder(0, 0, 0, 50));
		kananPanel = new JPanel();
		kananPanel.setBackground(new Color(0, 0, 0));

		contentbotPanel = new JPanel();
		contentbotPanel.setBackground(new Color(0, 0, 0));
		
		backBtn = new JButton("Back");
		backBtn.setPreferredSize(new Dimension(65, 30));
		backBtn.setBackground(new Color(242, 226, 213));
		backBtn.setForeground(new Color(169, 68, 86));
		backBtn.addActionListener(this);
		
		image1 = new JLabel(getImage(imgPath, 350, 160));
		
		nama = new JLabel(name);
		nama.setForeground(Color.white);
		harga = new JLabel("Price : Rp. " + price.toString());
		harga.setForeground(Color.white);
		ongkir = new JLabel("Ongkir : Rp. " + delivery.toString());
		ongkir.setForeground(Color.white);
		
		usevoucherBtn = new JButton("Use Voucher");
		usevoucherBtn.addActionListener(this);
		
		namaPanel = new JPanel();
		namaPanel.setBackground(new Color(0, 0, 0));
		pricePanel = new JPanel();
		pricePanel.setBackground(new Color(0, 0, 0));
		ongkirPanel = new JPanel();
		ongkirPanel.setBackground(new Color(0, 0, 0));
		
		showcaseBtn = new JButton("Product Showcase");
		showcaseBtn.addActionListener(this);
		
		image2 = new JLabel(getImage("src/Assets/Y540.jpg", 190, 120));
		image2.addMouseListener(this);
		image3 = new JLabel(getImage("src/Assets/Y740.jpg", 190, 120));
		image3.addMouseListener(this);
		
	}
	
	private ImageIcon getImage(String URL, int x, int y) {
		ImageIcon io = new ImageIcon(URL);
		Image img = io.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH);
		return new ImageIcon(img);
	}

	private JLabel initJLabel(String str, int x, Color col) {
		JLabel lbl = new JLabel(str);
		lbl.setFont(new Font("TNR", 0, x));
		lbl.setForeground(col);
		return lbl;
	}

	private void initJFrame() {
		setSize(1050, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Promo");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setVisible(true);
		
	}
	
	void recalculate(Voucher voucher) {
		if(voucher.getType() == "ongkir") {
			this.delivery = (int) (this.delivery * (1 - voucher.getDiscount()));
			ongkir.setText("Ongkir : Rp. " + String.valueOf(this.delivery));
		}
		else {
			this.price = (int) (this.price * (1 - voucher.getDiscount()));
			harga.setText("Price : Rp. " + String.valueOf(this.price));
		}
	}
	
	private class ClickListener extends MouseAdapter{
		  public void mousePressed(MouseEvent e) {
		  prevPt = e.getPoint();
		  }
		  public void mouseReleased(MouseEvent e) {
			  if(e.getSource() == image2) {
				  System.out.println("Released image2");
				  new promo(status, "src/Assets/Y540.jpg", "Nama : Legion Y540", 17999999, 20000, user);
			  }
			  else if(e.getSource() == image3) {
				  System.out.println("Released image3");
			  }
		  }
	}
	
	private class DragListener extends MouseMotionAdapter{
		
		public void mouseDragged(MouseEvent e) {
			   
			   Point currentPt = e.getPoint();
			   
			   imageCorner.translate(
			     
			     (int)(currentPt.getX() - prevPt.getX()),
			     (int)(currentPt.getY() - prevPt.getY())
			   );
			   prevPt = currentPt;
			   repaint();
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backBtn) {
			new Home(status, user);
			this.dispose();
		}
		else if(e.getSource() == showcaseBtn) {
				new productShowcase(imgPath);
		}
		else {
			if(user.getClaimedVoucher().isEmpty()) {
				JOptionPane.showMessageDialog(null, "You don't have any voucher", "Error Message", JOptionPane.ERROR_MESSAGE);
			}
			else {				
				new useVoucher(status, imgPath, name, price, delivery, user, this);
				
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Point currentPt = e.getPoint();
		   
		   imageCorner.translate(
		     
		     (int)(currentPt.getX() - prevPt.getX()),
		     (int)(currentPt.getY() - prevPt.getY())
		   );
		   prevPt = currentPt;
		   repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getSource() == image2) {
			new promo(status, "src/Assets/Y540.jpg", "Nama : Legion Y540", 17999999, 20000, user);
			this.dispose();
		}
		else if(e.getSource() == image3) {			
			new promo(status, "src/Assets/Y740.jpg", "Nama : Legion Y740", 20999999, 20000, user);
			this.dispose();
		}
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
