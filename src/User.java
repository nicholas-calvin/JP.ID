import java.util.ArrayList;

public class User {

	String email;
	String password;
	ArrayList<Voucher> claimedVoucher;
	
	public ArrayList<Voucher> getClaimedVoucher() {
		return claimedVoucher;
	}

	public void addClaimedVoucher(Voucher claimedVoucher) {
		this.claimedVoucher.add(claimedVoucher);
	}

	public User(String email, String password) {
		this.email = email;
		this.password = password;
		
		claimedVoucher = new ArrayList<Voucher>();
		
	}

}
