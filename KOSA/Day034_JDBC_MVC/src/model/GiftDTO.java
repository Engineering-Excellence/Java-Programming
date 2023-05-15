package model;

public class GiftDTO {

    public final String ClassName = "Gift";

    private int gno;
    private String gname;
    private int g_start;
    private int g_end;

    public String getClassName() {
        return ClassName;
    }

    public int getGno() {
        return gno;
    }

    public void setGno(int gno) {
        this.gno = gno;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public int getG_start() {
        return g_start;
    }

    public void setG_start(int g_start) {
        this.g_start = g_start;
    }

    public int getG_end() {
        return g_end;
    }

    public void setG_end(int g_end) {
        this.g_end = g_end;
    }
}
