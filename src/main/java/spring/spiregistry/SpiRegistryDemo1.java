package spring.spiregistry;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class SpiRegistryDemo1 {

    @Autowired
    SpiRegistryDemo2 spiRegistryDemo2;
    private String name="spiRegistryDemo1";

    public void test(){
        final String name = spiRegistryDemo2.getName();
        System.out.println(name);
    }
}
