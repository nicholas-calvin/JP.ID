import java.util.ArrayList;

public class Voucher {
	
	String name;
	Double discount;
	String imgPath;
	Integer qty = 1;
	String type;
	
	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public String getName() {
		return name;
	}

	public void setNama(String name) {
		this.name = name;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Voucher() {
		
	}
	
	public Voucher(String name, Double discount, String imgPath, String type) {
		super();
		this.name = name;
		this.discount = discount;
		this.imgPath = imgPath;
		this.type = type;
	}

}
