import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class voucherPage extends JFrame implements MouseListener, ActionListener{
	
	private JPanel bgPanel, centerPanel, midPanel, titlePanel;
	private JButton backBtn;
	private JLabel titleLbl;
	private JLabel[] image = new JLabel[8];
	private boolean status;
	User user;
	
	ArrayList<Voucher> voucherList;

	public voucherPage(boolean status, User user) {
		
		this.status = status;
		this.user = user;
		voucherList = new ArrayList<Voucher>();
		
		addVoucher();
		
		initComponent();
		addComponent();
		
		initJFrame();
	}
	
	private void addVoucher() {
		voucherList.add(new Voucher("cashback10", (10.0/100), "src/Assets/cashback 10.jpg", "cashback"));
		voucherList.add(new Voucher("cashback20", (20.0/100), "src/Assets/cashback 20.jpg", "cashback"));
		voucherList.add(new Voucher("cashback30", (30.0/100), "src/Assets/cashback 30.jpg", "cashback"));
		voucherList.add(new Voucher("cashback40", (40.0/100), "src/Assets/cashback 40.jpg", "cashback"));
		voucherList.add(new Voucher("ongkir10", (10.0/100), "src/Assets/ongkir 10.jpg", "ongkir"));
		voucherList.add(new Voucher("ongkir20", (20.0/100), "src/Assets/ongkir 20.jpg", "ongkir"));
		voucherList.add(new Voucher("ongkir30", (30.0/100), "src/Assets/ongkir 30.jpg", "ongkir"));
		voucherList.add(new Voucher("ongkir40", (40.0/100), "src/Assets/ongkir 40.jpg", "ongkir"));
	}
	
	private void addComponent() {

		bgPanel.add(backBtn);
		
		titlePanel.add(titleLbl);
		
		for(int i = 0 ; i < voucherList.size() ; i++) {
			if(voucherList.get(i).getQty() > 0) {				
				centerPanel.add(image[i]);
			}
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
		
		titleLbl = initJLabel("Vouchers", Color.white, 50);
		
		for(int i = 0 ; i < voucherList.size() ; i++) {
			image[i] = new JLabel(getImage(voucherList.get(i).getImgPath(), 90, 160));			
			image[i].addMouseListener(this);
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
		setTitle("Voucher");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setVisible(true);
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		for (int i = 0; i < image.length; i++) {
			if (e.getSource() == image[i]) {
				if(voucherList.get(i).getType() == "ongkir") {					
					new ongkir(voucherList.get(i), user);
				}
				else {
					new cashback(voucherList.get(i), user);
				}
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



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backBtn) {
			this.dispose();
			new Home(status, user);
		}
		
	}
	
}
