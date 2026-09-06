package nz.co.rosiesupposes.water.model.pipes;

import nz.co.rosiesupposes.water.model.orientations.Orientation;

import javax.swing.ImageIcon;
import java.net.URL;

public abstract class Pipe implements Cloneable {
    protected final Orientation orientation;
    protected final ImageIcon image;
    protected final ImageIcon waterImage;

    private boolean isFlooded = false;

    public Pipe(Orientation orientation) {
        this(orientation, "water_");
    }

    public Pipe(Orientation orientation, String waterPrefix) {
        this.orientation = orientation;

        String path = "/pipes/%s/%s.png";
        String folder = this.getClass().getSimpleName().toLowerCase().replace("pipe", "");

        String normalFileName = orientation.toString().toLowerCase();
        String waterFileName = waterPrefix + normalFileName;

        this.image = new ImageIcon(getResource(path, folder, normalFileName));
        this.waterImage = new ImageIcon(getResource(path, folder, waterFileName));
    }

    private URL getResource(String path, String folder, String fileName) {
        String fullPath = path.formatted(folder, fileName);
        URL url = getClass().getResource(fullPath);
        if (url == null) {
            throw new IllegalStateException("Couldn't find resource: " + fullPath);
        }
        return url;
    }

    public void flood() {
        isFlooded = true;
    }

    public void drain() {
        isFlooded = false;
    }

    public boolean isFlooded() {
        return isFlooded;
    }

    public ImageIcon getImage() {
        if (isFlooded)
            return waterImage;

        return image;
    }

    public boolean connectsUp() {
        return orientation.hasTop();
    }

    public boolean connectsDown() {
        return orientation.hasBottom();
    }

    public boolean connectsRight() {
        return orientation.hasRight();
    }

    public boolean connectsLeft() {
        return orientation.hasLeft();
    }

    public Pipe create() {
        try {
            return this.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected Pipe clone() throws CloneNotSupportedException {
        return (Pipe) super.clone();
    }
}
