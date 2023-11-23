package iterator;

import javafx.scene.image.Image;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CAggregate implements IAggregate {
    private final String fileTopic = new File("src//main//resources//topic//").getAbsolutePath() + "\\";
    private List<File> findImages(File dir){
        return Arrays.stream(dir.listFiles()).toList();
    }

    @Override
    public Iterator createIterator() {
        return new ImageIterator();
    }

    private class ImageIterator implements Iterator {
        private int current = 0;
        private final int max = findImages(Paths.get(fileTopic).toFile()).size();
        private Image getImage(int iterator){
            return new Image(Paths.get(fileTopic + iterator + ".jpg").toUri().toString());
        }

        @Override
        public boolean hasNext() {
            return !getImage(current + 1).isError();
        }

        @Override
        public Object next() {
            if (this.hasNext()){
                return getImage(++current);
            }
            current = 1;
            return getImage(current);
        }

        @Override
        public Object preview() {
            if (this.hasNext()){
                return getImage(--current);
            }
            current = max;
            return getImage(current);
        }
    }
}
