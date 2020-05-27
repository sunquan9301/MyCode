public class Ques2 {
    public static void main(String[] args){
        System.out.println("# Circle objecs:->"+Circle.getCount());
        Circle c1 = new Circle();
        System.out.println("# Circle objecs:->"+Circle.getCount());
        System.out.println("radius:->"+c1.getRadius()+","+"area:->"+c1.getArea());
        System.out.println("# Circle objecs:->"+Circle.getCount());
        Circle c2 = new Circle(10);
        System.out.println("radius:->"+c2.getRadius()+","+"area:->"+c2.getArea());
        System.out.println("# Circle objecs:->"+Circle.getCount());
        System.out.println("# Circle objecs from c1:->"+c1.getCount());
        System.out.println("# Circle objecs from c2:->"+c2.getCount());
        c1.getDoubleRadius();

    }
}

//# Circle objects;->0
//radius:->1.0,area:->3.141
class Circle{
    private double radius = 0;
    static int count;

    public Circle() {
        radius = 1.0;
        count++;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public static int getCount() {
        return count;
    }
    public  double getDoubleRadius(){
        return 2*radius;
    }

    public double getArea(){
        return Math.PI*radius*radius;

    }
}
