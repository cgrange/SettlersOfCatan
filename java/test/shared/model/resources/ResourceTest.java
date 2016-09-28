package shared.model.resources;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

import shared.definitions.ResourceType;
import shared.exceptions.CannotDecrementException;

public class ResourceTest {

  @Test
  public void decrementAmounts() {
    Resource r = new Resource(ResourceType.SHEEP,1);
    try {
      r.decrementAmounts(1);
      assertEquals(0, r.getAmount());
    }
    catch (CannotDecrementException e) {
    }

    r = new Resource(ResourceType.SHEEP,2);
    try {
      r.decrementAmounts(2);
      assertEquals(0, r.getAmount());
    }
    catch (CannotDecrementException e) {
    }

    r = new Resource(ResourceType.SHEEP,1);

    try {
      r.decrementAmounts(2);
    }
    catch (CannotDecrementException e) {
      assertNotNull(e);
      assertEquals("Cannot decrement below zero", e.getMessage());
    }
  }

  @Test
  public void incrementAmounts() {
    Resource r = new Resource(ResourceType.SHEEP,0);
    r.incrementAmounts(1);

    assertEquals(1, r.getAmount());
  }

  @Test
  public void hasEnough() {
    Resource r = new Resource(ResourceType.SHEEP,1);
    assert(r.hasEnough(1));

    r.incrementAmounts(1);
    assert(r.hasEnough(2));
  }

}