package DesignMode.FactoryMode.FactoryMethodPattern;

import DesignMode.FactoryMode.SimpleFactory.ICourse;
import DesignMode.FactoryMode.SimpleFactory.PythonCourse;

public class PythonCourseFactory implements ICourseFactory {

    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
