package test;

import java.io.*;
import java.util.*;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
//以上import需要   mybatis-generator-core-1.3.2.jar

public class GeneratorTest {

    public static void main(String[] args) {
        try { 
            List<String> warnings = new ArrayList<String>();  
            boolean overwrite = true;  
            String genCfg = "/generatorConfig.xml";  
            File configFile = new File(GeneratorTest.class.getResource(genCfg).getFile());  
            ConfigurationParser cp = new ConfigurationParser(warnings);  
            Configuration config = null;  
            config = cp.parseConfiguration(configFile);  
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);  
            MyBatisGenerator  myBatisGenerator = new MyBatisGenerator(config, callback, warnings);  

             myBatisGenerator.generate(null);  

        } catch (Exception e) {  
                e.printStackTrace();  
            }   

    }

}