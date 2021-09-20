package demo;

import org.springframework.stereotype.Component;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * @author cennavi_zt
 * @title: ConfigurationDemo
 * @projectName algorithm
 * @description: TODO
 * @date 2021/9/1515:15
 */

public class ConfigurationDemo {
    public static void main(String[] args) {
//        method01();
        method02();
    }

    private static void method02() {

        ResourceBundle resource = getResourceBundleMethod01();
        resource = getResourceBundleMethod02();

        Enumeration<String> keys = resource.getKeys();

        while (keys.hasMoreElements()){
            String key = keys.nextElement();
            String value = resource.getString(key);
            System.out.println(key+" : " + value);
        }

    }

    private static ResourceBundle getResourceBundleMethod02() {
        InputStream inStream = getInputStreamFromCurrentClassLoader();
        ResourceBundle resource = null;
        try {
            resource = new PropertyResourceBundle(inStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resource;
    }

    private static ResourceBundle getResourceBundleMethod01() {
        return  ResourceBundle.getBundle("property"); //property为属性文件名，如果是放在src下，直接用property即可;
    }


    /***
     * 读取properties
     */
    private static void method01() {
        Properties properties = new Properties();

        InputStream input = null;
        try {
            input = getInputStreamFromCurrentClassLoader();
//            input = getInputStreamFromClassLoader();
//            input = getInputStreamFromFileInputStream();
//            input = getInputStreamFromURL();
//            input = getInputStreamFromServletContext();

            properties.load(input);
            Enumeration<?> enumeration = properties.propertyNames();

            while (enumeration.hasMoreElements()){
                String key = (String) enumeration.nextElement();
                String name = properties.getProperty(key);
                System.out.println(key+" : "+name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private static InputStream getInputStreamFromServletContext() {
//        return context.getResourceAsStream("filePath");
//    }

    private static InputStream getInputStreamFromURL() throws IOException {
        return new URL("path").openStream();
    }

    private static InputStream getInputStreamFromCurrentClassLoader() {
        return ConfigurationDemo.class.getClassLoader().getResourceAsStream("property.properties");
    }

    private static FileInputStream getInputStreamFromFileInputStream() throws FileNotFoundException {
        return new FileInputStream(new File("BaseAlgorithm/src/main/resources/property.properties"));
    }

    private static InputStream getInputStreamFromClassLoader() {
        return ClassLoader.getSystemResourceAsStream("property.properties");
    }
}
