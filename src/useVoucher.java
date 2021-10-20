import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class useVoucher extends JFrame implements ActionListener, MouseListener{

	private JPanel bgPanel, centerPanel, midPanel, titlePanel;
	private JButton backBtn;
	private JLabel titleLbl, image1, image2, image3, image4,
	image5, image6, image7, image8;
	private ArrayList<Voucher> claimedVoucher;
	private ArrayList<JLabel> voucher;
	private String imgPath, name;
	private Integer price, delivery;
	private boolean status;
	
	User user;
	promo promo;
	
	public useVoucher(boolean status,String imgPath, String name, Integer price, Integer delivery, User user, promo promo) {
		this.status = status;
		this.imgPath = imgPath;
		this.name = name;
		this.price = price;
		this.delivery = delivery;
		this.user = user;
		this.voucher = new ArrayList<JLabel>();
		this.promo = promo;
		this.claimedVoucher = user.getClaimedVoucher();
		
		initComponent();
		addComponent();
		
		initJFrame();
		
	}
	
	private void addComponent() {
		
		
		titlePanel.add(titleLbl);
		
		for(int i = 0 ; i < voucher.size() ; i++) {
			centerPanel.add(voucher.get(i));
		}
		
		midPanel.add(titlePanel, BorderLayout.NORTH);
		midPanel.add(centerPanel, BorderLayout.CENTER);
		
		bgPanel.add(midPanel);
		
		add(bgPanel);
	}

	private void initComponent() {
		try {
			bgPanel = new JPanel() {
				
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
		bgPanel.setLayout(null);
		
		bgPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		midPanel = initJPanel(new BorderLayout());
		midPanel.setBounds(135, 95, 760, 430);
		midPanel.setBackground(new Color(255, 255, 255, 90));
		
		titlePanel = initJPanel(new FlowLayout());
		titlePanel.setBackground(new Color(255, 255, 255, 0));
		
		centerPanel = initJPanel(new GridLayout(2, 4));
		centerPanel.setBackground(new Color(255, 255, 255, 0));
		centerPanel.setBorder(new EmptyBorder(0, 50, 20, 50));
		
		backBtn = new JButton("Back");
		backBtn.setBounds(30, 10, 63, 25);
		backBtn.setBackground(new Color(242, 226, 213));
		backBtn.setForeground(new Color(169, 68, 86));
		backBtn.addActionListener(this);
		
		titleLbl = initJLabel("Your Voucher(s)", Color.white, 50);
		
		for(int i = 0 ; i < claimedVoucher.size() ; i++) {
			voucher.add(new JLabel(getImage(claimedVoucher.get(i).getImgPath(), 90, 160)));
			voucher.get(i).addMouseListener(this);
		}
		
	}
	
	private ImageIcon getImage(String URL, int x, int y) {
		ImageIcon io = new ImageIcon(URL);
		Image img = io.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH);
		return new ImageIcon(img);
	}
	
	private JPanel initJPanel(LayoutManager lm) {
		JPanel pan = new JPanel(lm);
		return pan;
	}
	
	private JLabel initJLabel(String str, Color col, int x){
		JLabel lbl = new JLabel(str);
		lbl.setForeground(col);
		lbl.setFont(new Font("TNR", 0, x));
		return lbl;
	}

	private void initJFrame() {
		setSize(1050, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Your Voucher");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		for(int i = 0 ; i < voucher.size() ; i++) {
			if(e.getSource() == voucher.get(i)) {
				Voucher selectedVoucher = claimedVoucher.get(i);
				claimedVoucher.remove(i);
				promo.recalculate(selectedVoucher);
				this.dispose();
			}
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
