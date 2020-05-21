package DesignMode.FactoryMode.FactoryMethodPattern;

import DesignMode.FactoryMode.SimpleFactory.ICourse;

public class FactoryMethodTest {
    public static void main(String[] args) {

        ICourseFactory factory = new PythonCourseFactory();
        ICourse course = factory.create();
        course.record();
    }
}
