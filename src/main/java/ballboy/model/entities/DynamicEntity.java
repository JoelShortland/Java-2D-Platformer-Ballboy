package ballboy.model.entities;

import ballboy.model.Entity;
import ballboy.model.entities.utilities.Vector2D;
import ballboy.model.observers.EnemyObserver;

/**
 * An entity with motion.
 */
public abstract class DynamicEntity implements Entity {

    /**
     * @param entity The entity which a collision is checked against.
     * @return boolean True if this entity collides with the provided entity.
     */
    public abstract boolean collidesWith(Entity entity);

    /**
     * @param entity The entity that this entity has collided with.
     *               This method is responsible for any entity-specific behaviour.
     */
    public abstract void collideWith(Entity entity);

    /**
     * @param pos The new top left position to anchor the entity on.
     */
    public abstract void setPosition(Vector2D pos);

    /**
     * @return Vector2 The previous top left anchor position prior to the last update.
     */
    public abstract Vector2D getPositionBeforeLastUpdate();

    /**
     * @return Vector2 The current velocity.
     */
    public abstract Vector2D getVelocity();

    /**
     * @param vel The new velocity.
     */
    public abstract void setVelocity(Vector2D vel);

    /**
     * @return double The current entity's horizontal acceleration relative to ground.
     */
    public abstract double getHorizontalAcceleration();

    /**
     * @param horizontalAcceleration The new horizontal acceleration to be applied to the entity.
     */
    public abstract void setHorizontalAcceleration(double horizontalAcceleration);

    /**
     * Steps the current dynamic state forward by the provided duration.
     *
     * @param durationMilli The time (positive) to increment the entities state by.
     * @param levelGravity  The current level gravity that should be applied.
     */
    public abstract void update(
            double durationMilli,
            double levelGravity);

    /**
     * Called by observers to notify the enemies related score
     */
    public abstract void notifyScore();

    /**
     * Attaches an observer to this entity
     * @param bo the observer to attach
     */
    public abstract void attach(EnemyObserver bo);

    /**
     * Notifies all observers of an event
     */
    public abstract void notifyAllObservers();


}
