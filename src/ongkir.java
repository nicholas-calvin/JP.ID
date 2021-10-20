import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ongkir extends JFrame implements ActionListener{

	private JPanel bgPanel, rightPanel, leftPanel, voucherPanel, ongkirPanel;
	private JLabel voucherLbl, ongkirLbl, image;
	private JButton claimBtn, cancelBtn;
	
	User user;
	Voucher voucher;
	
	public ongkir(Voucher voucher, User user) {
		this.voucher = voucher;
		this.user = user;
		
		initComponent();
		addComponent();
		
		initJFrame();
	}

	private void addComponent() {
		
		leftPanel.add(image);
		
		voucherPanel.add(voucherLbl);
		ongkirPanel.add(ongkirLbl);
		
		rightPanel.add(voucherPanel);
		rightPanel.add(ongkirPanel);
		rightPanel.add(claimBtn);
		rightPanel.add(cancelBtn);
		
		bgPanel.add(leftPanel, BorderLayout.WEST);
		bgPanel.add(rightPanel, BorderLayout.EAST);
		
		add(bgPanel);
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
		
		leftPanel = new JPanel(new FlowLayout());
		leftPanel.setBackground(new Color(0, 0, 0, 0));
		leftPanel.setBorder(new EmptyBorder(90, 15, 0, 0));

		rightPanel = new JPanel(new GridLayout(4, 1, 0, 5));
		rightPanel.setBackground(new Color(0, 0, 0, 0));
		rightPanel.setBorder(new EmptyBorder(100, 50, 125, 50));

		voucherLbl = initJLabel("Voucher");
		voucherPanel = new JPanel(new FlowLayout());
		
		ongkirLbl = initJLabel("Ongkir");
		ongkirPanel = new JPanel(new FlowLayout());
		
		voucherPanel.setBackground(new Color(0, 0, 0, 0));
		ongkirPanel.setBackground(new Color(0, 0, 0, 0));
		
		image = new JLabel(getImage(voucher.getImgPath(), 90, 160));
		
		claimBtn = new JButton("Claim");
		cancelBtn = new JButton("Cancel");
		
		cancelBtn.addActionListener(this);
		claimBtn.addActionListener(this);
		
	}
	
	private JLabel initJLabel(String str) {
		JLabel lbl = new JLabel(str);
		lbl.setForeground(Color.white);
		lbl.setFont(new Font("TNR", 0, 20));
		return lbl;
	}



	private ImageIcon getImage(String URL, int x, int y) {
		ImageIcon io = new ImageIcon(URL);
		Image img = io.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH);
		return new ImageIcon(img);
	}


	private void initJFrame() {
		setSize(300, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Ongkir");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancelBtn) {
			this.dispose();
		}
		else if(e.getSource() == claimBtn) {
			if(voucher.getQty() > 0) {
				JOptionPane.showMessageDialog(null, "Voucher claimed!");
				user.addClaimedVoucher(voucher);
				voucher.setQty(voucher.getQty() - 1);
			}
			else {
				JOptionPane.showMessageDialog(null, "The voucher has already been claimed", "Error Message", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}

}
