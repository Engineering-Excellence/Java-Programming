package edu.kosa.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    // web.xml을 대신하는 java class

    @Override
    protected Class<?>[] getRootConfigClasses() {

        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {

        return new Class<?>[]{ServletConfig.class};
    }

    @Override
    protected String[] getServletMappings() {

        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {

        // Encoding Filter
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);

        return new Filter[]{encodingFilter};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {

        registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
        MultipartConfigElement multipartConfig = new MultipartConfigElement(
                "/Users/kyle/Documents/Study/Java/KOSA/Day103_SP14_Ajax/src/main/webapp/upload", 20971520, 41943040, 0);
        registration.setMultipartConfig(multipartConfig);
    }
}
