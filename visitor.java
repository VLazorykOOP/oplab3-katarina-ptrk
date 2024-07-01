//step 1: define the interface for the Visitor.
interface Visitor {
    void visit(Circle circle);
    void visit(Rectangle rectangle);
    void visit(Square square);
}

//step 2: create concrete classes implementing the Visitable interface.
interface Shape {
    void accept(Visitor visitor);
}

//step 3: create concrete classes implementing the Shape interface.
class Circle implements Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Square implements Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

//step 4: create concrete classes implementing the Visitor interface to operate on each concrete element.
class AreaVisitor implements Visitor {
    public void visit(Circle circle) {
        System.out.println("Calculating area of circle with radius: " + circle.getRadius());
        //calculate area of circle
        double area = Math.PI * circle.getRadius() * circle.getRadius();
        System.out.println("Area of circle: " + area);
    }

    public void visit(Rectangle rectangle) {
        System.out.println("Calculating area of rectangle with width " + rectangle.getWidth() +
                " and height " + rectangle.getHeight());
        //calculate area of rectangle
        int area = rectangle.getWidth() * rectangle.getHeight();
        System.out.println("Area of rectangle: " + area);
    }

    public void visit(Square square) {
        System.out.println("Calculating area of square with side " + square.getSide());
        //calculate area of square
        int area = square.getSide() * square.getSide();
        System.out.println("Area of square: " + area);
    }
}

//step 5: demonstrate the use of the Visitor pattern.
public class VisitorPatternDemo {
    public static void main(String[] args) {
        Shape[] shapes = {new Circle(3), new Rectangle(4, 5), new Square(6)};

        AreaVisitor areaVisitor = new AreaVisitor();

        for (Shape shape : shapes) {
            shape.accept(areaVisitor);
        }
    }
}
