package spring.beanDefinitionRegistry;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.util.Properties;

public class BeanDefinitionRegistryPostProcessorDemo implements BeanDefinitionRegistryPostProcessor {

    private  Properties properties;

    public BeanDefinitionRegistryPostProcessorDemo() throws IOException {
        properties = PropertiesLoaderUtils.loadAllProperties("application.properties", ClassUtils.getDefaultClassLoader());
    }

    @SneakyThrows
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        Object service_provider_interface = properties.get("Spi_For_BeanDefinitionRegistry");
        String[] split = service_provider_interface.toString().split(",");
        for (String s : split) {
            String[] split1 = s.split("\\.");
            String s1 = toLowerCaseFirstOne(split1[split1.length - 1]);
            GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
            Class<?> aClass = Class.forName(s);
            genericBeanDefinition.setBeanClass(aClass);
            registry.registerBeanDefinition(s1,genericBeanDefinition);
        }
    }

    @SneakyThrows
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory){
        DefaultListableBeanFactory beanFactorys=(DefaultListableBeanFactory)beanFactory;
        Object service_provider_interface = properties.get("Spi_For_BeanFactory");
        String[] split = service_provider_interface.toString().split(",");
        for (String s : split) {
            String[] split1 = s.split("\\.");
            String s1 = toLowerCaseFirstOne(split1[split1.length - 1]);
            GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
            Class<?> aClass = Class.forName(s);
            genericBeanDefinition.setBeanClass(aClass);
         beanFactorys.registerBeanDefinition(s1,genericBeanDefinition);
        }

    }

    /**
     * 首字母转小写
     * @param
     * @return
     */
    public static String toLowerCaseFirstOne(String s){
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }
}
