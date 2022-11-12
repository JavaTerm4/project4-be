package FPTHotel.Dto;

public class ChangePassDto {
    private String tenDangNhap;
    private String oldPass;
    private String newPass;

    private String cfPass;

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    public String getCfPass() {
        return cfPass;
    }

    public void setCfPass(String cfPass) {
        this.cfPass = cfPass;
    }
}
