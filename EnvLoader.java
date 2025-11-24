import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EnvLoader {
    private Map<String, String> config = new HashMap<>();

    public EnvLoader(String filepath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                // Skip comments and empty lines
                if (line.isEmpty() || line.startsWith("#")) continue;
                
                String[] parts = line.split("=", 2);
                if (parts.length >= 2) {
                    config.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading .env file: " + e.getMessage());
            // Fallback defaults if file missing
            config.put("COLLEGE_NAME", "Default University");
            config.put("PRIMARY_COLOR", "#000000");
        }
    }

    public String get(String key) {
        return config.getOrDefault(key, "");
    }
    
    public String get(String key, String defaultValue) {
        return config.getOrDefault(key, defaultValue);
    }
}