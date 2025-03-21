package ballboy.view;

import ballboy.model.Entity;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class EntityViewImpl implements EntityView {
    private final Entity entity;
    private boolean delete = false;
    private final ImageView node;

    EntityViewImpl(Entity entity) {
        this.entity = entity;
        node = new ImageView(entity.getImage());
        node.setViewOrder(getViewOrder(entity.getLayer()));
        update(0.0, 0.0);
    }

    private static double getViewOrder(Entity.Layer layer) {
        switch (layer) {
            case BACKGROUND:
                return 100.0;
            case FOREGROUND:
                return 50.0;
            case EFFECT:
                return 25.0;
            default:
                throw new IllegalStateException("Javac doesn't understand how enums work so now I have to exist");
        }
    }

    @Override
    public void update(
            double xViewportOffset,
            double yViewportOffset) {
        if (!node.getImage().equals(entity.getImage())) {
            node.setImage(entity.getImage());
        }
        node.setX(entity.getPosition().getX() - xViewportOffset);
        node.setY(entity.getPosition().getY() - yViewportOffset);
        node.setFitHeight(entity.getHeight());
        node.setFitWidth(entity.getWidth());
        node.setPreserveRatio(true);
        delete = false;
    }

    @Override
    public boolean matchesEntity(Entity entity) {
        return this.entity.equals(entity);
    }

    @Override
    public void markForDelete() {
        delete = true;
    }

    @Override
    public Node getNode() {
        return node;
    }

    @Override
    public boolean isMarkedForDelete() {
        return delete;
    }
}
