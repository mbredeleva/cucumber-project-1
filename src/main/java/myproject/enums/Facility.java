package myproject.enums;

public enum Facility {
    TOKYO("Tokyo CURA Healthcare Center"),
    HONGKONG("Hongkong CURA Healthcare Center"),
    SEOUL("Seoul CURA Healthcare Center");

    public final String cityName;

    private Facility(String cityName) {
        this.cityName = cityName;
    }

    public static Facility findByCityName(String name){
        for(Facility f : values()){
            if( f.cityName.equals(name)){
                return f;
            }
        }
        return null;
    }
}

