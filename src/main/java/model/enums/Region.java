package model.enums;

public enum Region {
    CENTRAL_SWISS ("Zentral Schweiz");

    private final String nameGerman;

    Region(String nameGerman){
        this.nameGerman = nameGerman;
    }

    public String toString(){
        return nameGerman;
    }

    public static Region fromString(String nameGerman){
        for(Region region : Region.values()){
            if(region.nameGerman.equals(nameGerman)){
                return region;
            }
        }

        return null;
    }
}
