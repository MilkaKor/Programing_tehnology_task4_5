package items;

import javafx.scene.image.Image;

public interface IBuilder {
    public void setImage(Image image);
    public void setText();
    public void setDesign();
    public void setColor();
    public Mem build();
}