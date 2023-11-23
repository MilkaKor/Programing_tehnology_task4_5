package items;

import javafx.scene.image.Image;

public class Director {
    private Image image;
    public void setImage(Image image){
        this.image = image;
    }

    public Mem Construct(MemBuilder builder){
        builder.setImage(this.image);
        builder.setDesign();
        builder.setColor();
        builder.setText();
        return builder.build();
    }
}
