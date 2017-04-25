package holidays.android.myapplicationdev.com.p02_holidays;

public class Holiday {
    private String name;
    private String date;
    private boolean type;
    private int symbol;

    public Holiday(String name, String date, boolean type, int symbol) {
        this.name = name;
        this.date = date;
        this.type = type;
        this.symbol = symbol;
    }
    public String getName() {

        return name;
    }
    public String getDate() {

        return date;
    }
    public int getSym() {

        return symbol;
    }
    public boolean isSecular() {

        return type;
    }
}
