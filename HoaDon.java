package VuQuocThai_22700111;

public class HoaDon {

	private String id;
	private String nguoiLap;
	private String congTy;
	private String moTa;
	private int soLuong;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNguoiLap() {
		return nguoiLap;
	}

	public void setNguoiLap(String nguoiLap) {
		this.nguoiLap = nguoiLap;
	}

	public String getCongTy() {
		return congTy;
	}

	public void setCongTy(String congTy) {
		this.congTy = congTy;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public HoaDon(String id, String nguoiLap, String congTy, String moTa, int soLuong) {
		super();
		setCongTy(congTy);
		setId(id);
		setMoTa(moTa);
		setNguoiLap(nguoiLap);
		setSoLuong(soLuong);

	}

	public HoaDon(String id) {
		super();

		setId(id);

	}

	public HoaDon() {
		super();

	}
}
