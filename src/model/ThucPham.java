package model;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ThucPham {
    private int MaHang;
    private String TenHang;

    private double donGia;

    private Date nSX, hSD;



    public ThucPham(){}

    public ThucPham(int maHang, String tenHang, double donGia, Date nSX, Date hSD) {
        MaHang = maHang;
        TenHang = tenHang;
        this.donGia = donGia;
        this.nSX = nSX;
        this.hSD = hSD;
    }

    public int getMaHang() {
        return MaHang;
    }

    public void setMaHang(int maHang) {
        MaHang = maHang;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getTenHang() {
        return TenHang;
    }

    public void setTenHang(String tenHang) {
        TenHang = tenHang;
    }

    public Date getnSX() {
        return nSX;
    }

    public void setnSX(Date nSX) {
        this.nSX = nSX;
    }

    public Date gethSD() {
        return hSD;
    }

    public void sethSD(Date hSD) {
        this.hSD = hSD;
    }

    public String toString() {
        //sử dung phương thức Locale để biến đổi theo tiền tệ việt nam
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeVN);
        String str = numberFormat.format(donGia);
        // sử dụng phương thức SimpleDateFormat để biến đổi ngày tháng năm theo dạng "dd/MM/yyyy"
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String str1 = simpleDateFormat.format(nSX);
        String str2 = simpleDateFormat.format(hSD);
        return "Thông tin về thực phẩm: \n" +
                "Mã hàng : " + MaHang +
                "\nTên hàng : '" + TenHang +
                "\nĐơn giá : " + str +
                "\nNgày sản xuất : " + str1 +
                "\nHạn sử dụng : " + str2
                ;
    }
    public void setNSX(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        this.nSX = calendar.getTime();
    }

    public void setHSD(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        this.hSD = calendar.getTime();
    }

    public boolean KiemTraTenHang(boolean K){
        if (this.TenHang == "" || this.TenHang.isEmpty()){
            System.out.println("tên hàng không được để trồng:");
        }else {
            K = false;
        }
        return K;
    }

    public void KiemTraHSD(){
        Date today = new Date();
        today.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
        String str = simpleDateFormat.format(today);
        if (this.gethSD().compareTo(today) < 0){
            System.out.println("Hôm nay là ngày " + str + " hàng hoá đã hết hạn");
        }else
            System.out.println("Hôm nay là ngày " + str + " hàng hoá vẫn còn hạn");
    }
}
