package edu.wgu.d387_sample_code;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@SpringBootApplication
public class DisplayMessage {

    static ExecutorService messageExecutor = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        loadMessages("welcome_en_US.properties");
        loadMessages("welcome_fr_CA.properties");
    }

    public static String[] loadMessages(String fileName) {
        messageExecutor.execute(() -> {
            try {
                Properties properties = new Properties();
                InputStream stream = new ClassPathResource(fileName).getInputStream();
                properties.load(stream);
                String welcomeMessage = properties.getProperty("welcome");
                System.out.println(welcomeMessage);
                // You may want to store the messages in a data structure or return them as needed.
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return new String[0];
    }
}
