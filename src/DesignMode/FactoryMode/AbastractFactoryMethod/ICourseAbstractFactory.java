package DesignMode.FactoryMode.AbastractFactoryMethod;

import DesignMode.FactoryMode.SimpleFactory.ICourse;

/*
要求子工厂都实现这个工厂
//一个产品的抽象
 */
public interface ICourseAbstractFactory {
    ICourse createCourse();

    INote createNote();

     IVideo createVideo();
}
