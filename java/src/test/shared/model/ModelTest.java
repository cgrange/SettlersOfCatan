package shared.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import shared.model.*;

public class ModelTest {
  @Test
  public void calculatePoints() {
    Model model = new Model();
    int points = model.calculatePoints(0);

    assertEquals(0, points);
  }
}