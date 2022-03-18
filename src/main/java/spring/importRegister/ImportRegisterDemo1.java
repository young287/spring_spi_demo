package spring.importRegister;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import spring.spiregistry.SpiRegistryDemo1;

@Data
public class ImportRegisterDemo1 {

    @Autowired
    ImportRegisterDemo2 importRegisterDemo2;
    private String name="ImportRegisterDemo1";

    public void test(){
        System.out.println(importRegisterDemo2.getName());
    }
}
