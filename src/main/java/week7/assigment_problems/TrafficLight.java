package week7.assigment_problems;

public class TrafficLight {
    private final String id;
    private String color;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    public void next() {
        if (this.color.equals("RED")) {
            this.color = "GREEN";
        } else if (this.color.equals("GREEN")) {
            this.color = "YELLOW";
        } else if (this.color.equals("YELLOW")) {
            this.color = "RED";
        }
    }

    public String getColor() {
        return this.color;
    }

    public String getId() {
        return this.id;
    }
}
