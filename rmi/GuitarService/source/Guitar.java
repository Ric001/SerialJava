import java.io.Serializable;

public class Guitar implements Serializable {
    
    private int id; 
    private String builder;
    private String type;
    private String topWood;
    private String backWood;
    private double price;
    
    public Guitar(int id, String builder, String type, String topWood, String backWood, 
        double price) {
            this.id = id;
            this.builder = builder;
            this.type = type;
            this.topWood = topWood;
            this.backWood = backWood;
            this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuilder() {
        return builder;
    }

    public void setBuilder(String builder) {
        this.builder = builder;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTopWood() {
        return topWood;
    }

    public void setTopWood(String topWood) {
        this.topWood = topWood;
    }

    public String getBackWood() {
        return backWood;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return new StringBuilder()
            .append("Id: ".concat(Integer.toString(id)))
            .append("Builder: ".concat(builder))
            .append("Type: ".concat(type))
            .append("TopWood: ".concat(topWood))
            .append("BackWood: ".concat(backWood))
            .append("Price: ".concat(Double.toString(price)))
            .toString();
    }
   

}