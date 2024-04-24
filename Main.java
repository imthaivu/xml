package VuQuocThai_22700111;

import java.util.Scanner;

public class Main {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ManageHD dom = new ManageHD();

		// nhap hd
			
//		System.out.println("nhap id hoa don");
//		String id = sc.nextLine();
//		System.out.println("nhap nguoi lap hoa don");
//		String ng = sc.nextLine();
//		System.out.println("nhap cong ty hoa don");
//		String cty = sc.nextLine();
//		System.out.println("nhap mo ta hoa don");
//		String moTa = sc.nextLine();
//		System.out.println("nhap so luong hoa don");
//		int soLuong = sc.nextInt();
//		HoaDon hd = new HoaDon(id, ng, cty, moTa, soLuong);

		// xuat toan bo
		
//		System.out.println("xuat toan bo");
//		dom.printAll();

		// xuat cac hd so luong > 60
		
//		System.out.println("xuat cac hd so luong >= 60 ");
//		dom.printHDSoLuongHon60();
//
//		// them hd
//		System.out.println("them ");
//		dom.addHd(hd);
//		dom.printAll();
//		
		// xoa cac hoa don ML >=50
		System.out.println("xoa cac hd >= 50");
//		dom.deleteML50();
		
		dom.printAll();
	}
}
