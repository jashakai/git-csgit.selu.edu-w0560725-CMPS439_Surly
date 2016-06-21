

public class Attribute {

    String name;
    String type;
    int len;

    public Attribute(String name, String type, int len) {
        this.name = name;
        this.len = len;

        if (type.equalsIgnoreCase("num") || type.equalsIgnoreCase("int")
                || type.equalsIgnoreCase("float")) {
            this.type = "num";
        } else if (type.equalsIgnoreCase("string") || type.equalsIgnoreCase("char")) {
            this.type = "char";
        }
    }

}
