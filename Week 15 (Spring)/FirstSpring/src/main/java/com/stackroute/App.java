package com.stackroute;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        BeanFactory factory= new XmlBeanFactory(new ClassPathResource("bean.xml"));
        Employee employee2 =  (Employee) factory.getBean("employee");
         System.out.println("The employee name is  :: "+ employee2.getEmpName());
        System.out.println(employee2.toString());
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Employee employee = context.getBean("employee",Employee.class);
        System.out.println("Employee Details" + employee.toString());
    }
}
