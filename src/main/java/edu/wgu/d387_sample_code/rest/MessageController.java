package edu.wgu.d387_sample_code.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;

@RestController
public class MessageController {
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/welcome")
    public CompletableFuture<String[]> loadMessages() {
        CompletableFuture<String[]> future = new CompletableFuture<>();

        CompletableFuture.runAsync(() -> {
            String[] messagesFrCA = loadMessagesFromFile("welcome_fr_CA.properties");
            String[] messagesEnUS = loadMessagesFromFile("welcome_en_US.properties");
            String[] combinedMessages = new String[]{messagesEnUS[0], messagesFrCA[0]};
            future.complete(combinedMessages);
        });

        return future;
    }

    private String[] loadMessagesFromFile(String fileName) {
        try {
            Properties properties = new Properties();
            InputStream stream = getClass().getClassLoader().getResourceAsStream(fileName);

            if (stream != null) {
                properties.load(stream);
                String welcomeMessage = properties.getProperty("welcome");
                return new String[]{welcomeMessage};
            } else {
                return new String[]{"Error loading messages from " + fileName};
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new String[]{"Error loading messages from " + fileName};
        }
    }
}