public class Weather {
    private int tempature = 70;
    private String conditions = "sunny";

    public int getTempature() {
        return tempature;
    }

    public void setTempature(int tempature) {
        this.tempature = tempature;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public Weather(int tempature, String conditions) {
        this.tempature = tempature;
        this.conditions = conditions;
    }

    @Override
    public String toString() {
        return "tempature is " + tempature + "; sky conditions is " + conditions;
    }

    public double convertCelsius() {
        return (tempature - 32) * 5f / 9f;
    }

    public boolean checkConsistent() {
        if (tempature > 32 && conditions.equals("snowy")) return false;
        if (tempature < 32 && conditions.equals("rainy")) return false;
        return true;
    }
}
class client{
    public static void main(String[] args){
        Weather weather = new Weather(43,"snowy");
        System.out.println("The weather info is "+weather.toString());
        System.out.println("Convert Celsius "+weather.convertCelsius());
        System.out.println("check consistent "+weather.checkConsistent());
    }
}
