package shared.model.resources;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

import shared.definitions.ResourceType;

public class BankTest {

  @Test
  public void getResource() {
    Bank bank = new Bank();

    assertEquals(ResourceType.ORE, bank.ore.getType());
    assertEquals(ResourceType.WHEAT, bank.wheat.getType());
    assertEquals(ResourceType.BRICK, bank.brick.getType());
    assertEquals(ResourceType.WOOD, bank.wood.getType());
    assertEquals(ResourceType.SHEEP, bank.sheep.getType());

    assertEquals(0, bank.ore.getAmount());
    assertEquals(0, bank.wheat.getAmount());
    assertEquals(0, bank.brick.getAmount());
    assertEquals(0, bank.wood.getAmount());
    assertEquals(0, bank.sheep.getAmount());
  }

  @Test
  public void canRob() {
    Bank bank = new Bank();
    assertFalse(bank.canRob());

    bank.ore = new Resource(ResourceType.ORE, 1);
    assertTrue(bank.canRob());

    bank = new Bank();
    bank.wheat = new Resource(ResourceType.WHEAT, 1);
    assertTrue(bank.canRob());

    bank = new Bank();
    bank.brick = new Resource(ResourceType.BRICK, 1);
    assertTrue(bank.canRob());

    bank = new Bank();
    bank.wood = new Resource(ResourceType.WOOD, 1);
    assertTrue(bank.canRob());

    bank = new Bank();
    bank.sheep = new Resource(ResourceType.SHEEP, 1);
    assertTrue(bank.canRob());
  }

  @Test
  public void rob() {
    // Test all resource types with only 1 element
    List<ResourceType> types = Arrays.asList(ResourceType.ORE, ResourceType.WHEAT, ResourceType.BRICK, ResourceType.WOOD, ResourceType.SHEEP );

    Bank originalBank = new Bank();
    for(ResourceType type: types) {

      switch (type) {
        case ORE:
          originalBank.ore = new Resource(type, 1);
          break;
        case WHEAT:
          originalBank.wheat = new Resource(type, 1);
          break;
        case BRICK:
          originalBank.brick = new Resource(type, 1);
          break;
        case WOOD:
          originalBank.wood = new Resource(type, 1);
          break;
        case SHEEP:
          originalBank.sheep = new Resource(type, 1);
          break;
      }
      assertTrue(originalBank.canRob());

      Bank robbingBank = new Bank();

      originalBank.rob(robbingBank);
      assertFalse(originalBank.canRob());

      assertEquals(1, robbingBank.getResource(type).getAmount());
    }

    // test with 2 elements
    originalBank = new Bank();
    originalBank.random = new Random(0);



  }
}