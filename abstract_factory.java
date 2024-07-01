
//step 1: create an interface for the products.
interface Shape {
    void draw();
}

//step 2: create concrete classes implementing the same interface.
class Rectangle implements Shape {
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}

//step 3: create an interface for Abstract Factory.
interface AbstractFactory {
    Shape getShape(String shapeType);
}

//step 4: create Factory classes extending AbstractFactory to generate objects of concrete class.
class ShapeFactory implements AbstractFactory {
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}

//step 5: create a Factory generator/producer class to get factories by passing an information such as Shape.
class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("SHAPE")) {
            return new ShapeFactory();
        }
        return null;
    }
}

//step 6: use the FactoryProducer to get the AbstractFactory and then get the concrete class by passing an information such as type.
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        //get shape factory
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

        //get an object of Shape Rectangle
        Shape shape1 = shapeFactory.getShape("RECTANGLE");
        shape1.draw();

        //get an object of Shape Square
        Shape shape2 = shapeFactory.getShape("SQUARE");
        shape2.draw();
    }
}

