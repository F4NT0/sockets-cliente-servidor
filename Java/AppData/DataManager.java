import java.io.File;
import java.nio.file.Files;

enum FileType {
    case SMALL, MEDIUM, BIG
}

class DataManager {

    public static byte [] getFile(FileType type) {
        return type == FileType.SMALL ?
         Files.readAllBytes("DataManager.java") : type == FileType.MEDIUM ?
         Files.readAllBytes("five-mb-file.jpg") : Files.readAllBytes("twenty-mb-file.txt")
    }

}