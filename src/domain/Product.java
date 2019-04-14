package domain;
/**
 * 创建Product的JavaBean类
 * @author 29050
 *
 */
public class Product {
	private int pid;
	private String p_sn;
	private String pname;
	private double market_price;
	private double shop_price;
	private String pimage;
	private String pdate;
	private int is_hot;
	private String pdesc;
	private int pflag;
	private String cid;
	
	public Product() {}

	public int getPid() {
		return pid;
	}

	public String getP_sn() {
		return p_sn;
	}

	public String getPname() {
		return pname;
	}

	public double getMarket_price() {
		return market_price;
	}

	public double getShop_price() {
		return shop_price;
	}

	public String getPimage() {
		return pimage;
	}

	public String getPdate() {
		return pdate;
	}

	public int getIs_hot() {
		return is_hot;
	}

	public String getPdesc() {
		return pdesc;
	}

	public int getPflag() {
		return pflag;
	}

	public String getCid() {
		return cid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public void setP_sn(String p_sn) {
		this.p_sn = p_sn;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public void setMarket_price(double market_price) {
		this.market_price = market_price;
	}

	public void setShop_price(double shop_price) {
		this.shop_price = shop_price;
	}

	public void setPimage(String pimage) {
		this.pimage = pimage;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

	public void setIs_hot(int is_hot) {
		this.is_hot = is_hot;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public void setPflag(int pflag) {
		this.pflag = pflag;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}
	
}
