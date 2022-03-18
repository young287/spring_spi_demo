package spring.importSelect;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.ClassUtils;
import spring.annotation.SpiAnnotation;

import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

public class ImportselectDemo implements ImportSelector {
    private Properties properties;

    public ImportselectDemo() throws IOException {
        properties = PropertiesLoaderUtils.loadAllProperties("application.properties", ClassUtils.getDefaultClassLoader());
    }

    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
         MergedAnnotations annotations = importingClassMetadata.getAnnotations();
         MergedAnnotation<SpiAnnotation> spiAnnotation= annotations.get(SpiAnnotation.class);
         Optional<Object> value = spiAnnotation.getValue("value");
         String s = value.get().toString();
         Object service_provider_interface = properties.get(s);
         String[] split = service_provider_interface.toString().split(",");
        return split;
    }
}
