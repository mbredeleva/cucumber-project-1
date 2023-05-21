package myproject.enums;

public enum Program {
    MEDICARE("Medicare"),
    MEDICAID("Medicaid"),
    NONE("None");

    public final String value;

    private Program(String programName) {

        this.value = programName;
    }

    public static Program findByProgramName(String name){
        for(Program p : values()){
            if( p.value.equals(name)){
                return p;
            }
        }
        return null;
    }
}
