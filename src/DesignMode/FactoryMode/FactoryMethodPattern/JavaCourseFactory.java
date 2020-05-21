package DesignMode.FactoryMode.FactoryMethodPattern;

import DesignMode.FactoryMode.SimpleFactory.ICourse;
import DesignMode.FactoryMode.SimpleFactory.JavaCourse;

public class JavaCourseFactory implements ICourseFactory {

    @Override
    public ICourse create() {
        return new JavaCourse();
    }

}
