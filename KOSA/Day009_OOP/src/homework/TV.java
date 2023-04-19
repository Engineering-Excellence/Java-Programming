package homework;

class TV {

    // Field
    private String color = "black";
    private int channel = 1;

    // Getters & Setters
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public void display() {
        System.out.printf("color: %s%nchannel: %d%n", color, channel);
    }
}
