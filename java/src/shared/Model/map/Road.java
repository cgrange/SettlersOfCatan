package shared.model.map;

import shared.locations.EdgeLocation;
import shared.model.players.Player;

/**
 * A class representing a road
 *
 */
public class Road {
  private Player owner;
  private EdgeLocation location;

  public Player getOwner() {
    return owner;
  }

  public void setOwner(Player owner) {
    this.owner = owner;
  }

  public EdgeLocation getLocation() {
    return location;
  }

  public void setLocation(EdgeLocation location) {
    this.location = location;
  }
  /**
   * Serializes the road
   * @return a json string
   */
  public String serialize()
  {
    return "";
  }
}
