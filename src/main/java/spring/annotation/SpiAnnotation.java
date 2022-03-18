package spring.annotation;

import org.springframework.context.annotation.Import;
import spring.beanDefinitionRegistry.BeanDefinitionRegistryPostProcessorDemo;
import spring.importSelect.ImportselectDemo;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({BeanDefinitionRegistryPostProcessorDemo.class, ImportselectDemo.class})
public @interface SpiAnnotation {
   String value() default " ";
}
