package Utils_Appium;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class TestDataUtils {
    private static final String TEST_DATA_FILE = "appium/test-data.properties";
    private static final Properties PROPERTIES = loadProperties();

    private TestDataUtils() {
    }

    public static String get(String key) {
        String value = PROPERTIES.getProperty(key);
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Missing test data property: " + key);
        }
        return value.trim();
    }

    public static String getPreservingWhitespace(String key) {
        String value = PROPERTIES.getProperty(key);
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Missing test data property: " + key);
        }
        return value;
    }

    private static Properties loadProperties() {
        try (InputStream input = TestDataUtils.class.getClassLoader()
                .getResourceAsStream(TEST_DATA_FILE)) {
            if (input == null) {
                throw new IllegalStateException("Test data file not found: " + TEST_DATA_FILE);
            }

            Properties properties = new Properties();
            properties.load(input);
            return properties;
        } catch (IOException e) {
            throw new IllegalStateException("Unable to load test data: " + TEST_DATA_FILE, e);
        }
    }
}
