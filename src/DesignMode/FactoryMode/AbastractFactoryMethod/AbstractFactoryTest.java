package DesignMode.FactoryMode.AbastractFactoryMethod;

public class AbstractFactoryTest {
    public static void main(String[] args) {

        ICourseAbstractFactory factory = new JavaProductFactory();
        factory.createCourse().record();
        factory.createNote();
        factory.createVideo();
    }
}
