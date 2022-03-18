import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.Demo;
import spring.importRegister.ImportRegisterDemo1;
import spring.spibeanFactory.SpiBeanFactoryDemo1;
import spring.spiregistry.SpiRegistryDemo1;

public class Test {

    @org.junit.Test
    public void spibeanFactory(){
        final AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Demo.class);
        AnnotationConfigApplicationContext appcationContext = annotationConfigApplicationContext;
        final SpiBeanFactoryDemo1 bean = appcationContext.getBean(SpiBeanFactoryDemo1.class);
        final String name = bean.getName();
        System.out.println(name);
        bean.test();
    }

    @org.junit.Test
    public void spiregistry(){
        final AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Demo.class);
        AnnotationConfigApplicationContext appcationContext = annotationConfigApplicationContext;
        final SpiRegistryDemo1 bean = appcationContext.getBean(SpiRegistryDemo1.class);
        final String name = bean.getName();
        System.out.println(name);
        bean.test();
    }

    @org.junit.Test
    public void importRegister(){
        final AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Demo.class);
        AnnotationConfigApplicationContext appcationContext = annotationConfigApplicationContext;
        final ImportRegisterDemo1 bean = appcationContext.getBean(ImportRegisterDemo1.class);
        final String name = bean.getName();
        System.out.println(name);
        bean.test();
    }
}
