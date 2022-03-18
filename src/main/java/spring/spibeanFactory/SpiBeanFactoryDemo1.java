package spring.spibeanFactory;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import spring.spiregistry.SpiRegistryDemo1;

@Data
public class SpiBeanFactoryDemo1 {

    @Autowired
    SpiBeanFactoryDemo2 spiBeanFactoryDemo2;
    private String name="SpiBeanFactoryDemo1";

    @Autowired
    SpiRegistryDemo1 spiRegistryDemo1;

    public void test(){
        System.out.println(spiBeanFactoryDemo2.getName());
        System.out.println(spiRegistryDemo1.getName());
        spiRegistryDemo1.test();
    }
}
