package DesignMode.FactoryMode.AbastractFactoryMethod;

import DesignMode.FactoryMode.SimpleFactory.ICourse;

public class PythonProductFactory implements ICourseAbstractFactory {
    @Override
    public ICourse createCourse() {
        return null;
    }

    @Override
    public INote createNote() {
        return null;
    }

    @Override
    public IVideo createVideo() {
        return null;
    }
}
