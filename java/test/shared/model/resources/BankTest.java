package shared.model.resources;

import static org.junit.Assert.*;

import org.junit.Test;

import shared.definitions.ResourceType;
import shared.model.*;
import shared.model.players.Player;

public class BankTest {
  @Test
  public void canRob() {
    Bank bank = new Bank();

    assertFalse(bank.canRob());
    bank.sheep = new Resource(ResourceType.SHEEP, 1);
    assertTrue(bank.canRob());
  }
}