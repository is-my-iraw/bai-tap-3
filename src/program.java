import model.ThucPham;

import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ThucPham p = new ThucPham();
        boolean kt = true;
        boolean th = true;
        System.out.println("nhập mã hàng:");
        p.setMaHang(scanner.nextInt());
        scanner.nextLine();
        do {
            System.out.println("nhập tên hàng: ");
            p.setTenHang(scanner.nextLine());
        }while (p.KiemTraTenHang(kt));
            System.out.println("nhập giá tiền");
            p.setDonGia(scanner.nextDouble());
            do {
                System.out.println("Nhập năm tháng, ngày sản xuất: ");

                p.setNSX(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                System.out.println("nhập năm,tháng,ngày hết hạn : ");
                p.setHSD(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            }while (p.KiemTraTenHang(th));
        System.out.println(p);
        p.KiemTraHSD();
    }
}
