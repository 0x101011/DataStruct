package DesignMode.FactoryMode.SimpleFactory;

public class SimpleFactoryTest {
    public static void main(String[] args) {

        ICourse course = new JavaCourse();
        course.record();

        CourseFactory factory = new CourseFactory();
        ICourse course1 = factory.create("java");
        course1.record();
        ICourse course2 = factory.create2(JavaCourse.class);

    }

    public ICourse course(String className) throws ClassNotFoundException {
        try {
            if (null == className || "".equals(className)){
                return (ICourse) Class.forName(className).newInstance();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } {

        }

        return null;
    }


}
