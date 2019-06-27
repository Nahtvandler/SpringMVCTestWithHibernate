package spring;

import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.io.*;
import java.nio.file.Files;
import java.util.Map;
import java.util.Properties;

@Component
public class FileWriteHelper {
    private static final String TMP_FILE_SUFFIX = ".tmp";
    private static final String TMP_DIRECTORY_NAME = "serviceResponses";

    private static File tmpDirectory;

    @PreDestroy
    private void preDestroy() {
        removeTmpDirectory();
    }

    public boolean createTemporaryFile(String prefix, String content) throws IOException {
        return createTemporaryFile(prefix, TMP_FILE_SUFFIX, content);
    }

    public boolean createTemporaryFile(String prefix, String suffix, String content) throws IOException {
        File tempFile = File.createTempFile(prefix, suffix, getTmpDirectory());
        System.out.println("Temp file On Default Location: " + tempFile.getAbsolutePath());

        try (FileOutputStream outputStream = new FileOutputStream(tempFile)) {
            byte[] strContentBytes = content.getBytes();
            outputStream.write(strContentBytes);
        }

        return true;
    }

    public static boolean writeToConfig(String name) throws IOException {
        File configDir = new File(System.getProperty("catalina.base"), "conf");
        File configFile = new File(configDir, "fairy-ocrm.properties");


//        String fileContent = FileUtils.readFileToString(configFile, StandardCharsets.UTF_8);
//
//        //------------
//        StringBuilder builder = new StringBuilder(fileContent);
//        builder.append("\r\n");
//        builder.append("something").append("\r\n");
//        builder.append("sometsing 2").append("\r\n");
//        String content = builder.toString();
//        byte[] strContentBytes = content.getBytes();
//        //------------
//        outputStream.write(strContentBytes);

        FileOutputStream outputStream = new FileOutputStream(configFile);

//        properties.forEach((serviceName, value) -> {
//            if (serviceName.equals("WSSecSalesCustomerOfferGetOffersList")) {
//                value.setProperty("fairyOcrmUrl","testWritedString");
//            }
//            try {
//                value.store(outputStream, null);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        });
//        outputStream.close();


        return true;
    }

    private File getTmpDirectory() throws IOException {
        if (tmpDirectory == null) {
            tmpDirectory = Files.createTempDirectory(TMP_DIRECTORY_NAME).toFile();
            tmpDirectory.deleteOnExit();
        }
        return tmpDirectory;
    }

    private boolean removeTmpDirectory() {
        tmpDirectory.delete();
        tmpDirectory = null;
        return true;
    }
}
