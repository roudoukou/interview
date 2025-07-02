package icu.xiamu.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * @author roudoukou
 * @date 2025/6/14
 */
public class MyTypeFilter implements TypeFilter {

    /**
     *
     * @param metadataReader the metadata reader for the target class 读取当前正在扫描类的细腻
     * @param metadataReaderFactory a factory for obtaining metadata readers 获取其他任务类的信息
     * for other classes (such as superclasses and interfaces)
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        // 获取当前类注解的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();

        // 获取当前正在扫描类的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        // 获取当前类资源(类的路径)
        Resource resource = metadataReader.getResource();

        MetadataReader metadataReader1 = metadataReaderFactory.getMetadataReader("icu.xiamu.controller.BookController");
        System.out.println(metadataReader1);

        if (classMetadata.getClassName().contains("ll")) {
            return true;
        }

        return false;
    }
}
