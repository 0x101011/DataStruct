package DesignMode.FactoryMode.AbastractFactoryMethod;

import DesignMode.FactoryMode.SimpleFactory.ICourse;
import DesignMode.FactoryMode.SimpleFactory.JavaCourse;

public class JavaProductFactory implements ICourseAbstractFactory{
    @Override
    public ICourse createCourse() {
         return new JavaCourse();
    }

    @Override
    public INote createNote() {
        return new JavaNote();
    }

    @Override
    public IVideo createVideo() {
        return new JavaVideo();
    }
}
