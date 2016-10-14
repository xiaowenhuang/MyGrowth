package com.exercise.design.mode;

/**
 * Created by sven on 2016/10/13.
 */
//interface
interface ServiceA{
    void methodA();
}
interface ServiceB{
    void methodB();
}
interface ServiceC{
    void methodC();
}
//Facade
class Facade {
    ServiceA sa;
    ServiceB sb;
    ServiceC sc;

    public Facade(){
        sa = new ServiceAImpl();
        sb = new ServiceBImpl();
        sc = new ServiceCImpl();
    }

    public void methodA(){
        sa.methodA();
        sb.methodB();
    }
    public void methodB(){
        sb.methodB();
        sc.methodC();
    }
/*    public void methodC(){
        sc.methodC();
        sa.methodA();
    }*/
}

//SubSystemClasses
class ServiceAImpl implements ServiceA{
    public void methodA(){
        System.out.println("这是服务A");
    }
}
class ServiceBImpl implements ServiceB{
    public void methodB(){
        System.out.println("这是服务B");
    }
}
class ServiceCImpl implements ServiceC{
    public void methodC(){
        System.out.println("这是服务C");
    }
}
//Test
public class FacadeMode{
    public static void main(String[] args){
        ServiceA sa = new ServiceAImpl();
        ServiceB sb = new ServiceBImpl();
        sa.methodA();
        sb.methodB();
        System.out.println("========");
        Facade facade = new Facade();
        facade.methodA();
        facade.methodB();
    }
}
