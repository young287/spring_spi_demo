package spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import spring.annotation.SpiAnnotation;

@Component
@SpiAnnotation(value = "Spi_Importselect")

public class Demo {

}
