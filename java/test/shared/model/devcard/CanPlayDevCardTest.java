package shared.model.devcard;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import shared.model.*;
import shared.model.devcard.*;

import shared.definitions.DevCardType;

public class CanPlayDevCardTest {

  @Test
  public void canPlayMonopoly() {
      //arrange
	  DevCardHand hand = new DevCardHand();
	  
	  //act
	  hand.setAmount(DevCardType.MONOPOLY, 1);
	  
	  //assert
	  hand.canPlay(DevCardType.MONOPOLY);
  }
  
  @Test
  public void canPlayMonument() {
      //arrange
	  DevCardHand hand = new DevCardHand();
	  
	  //act
	  hand.setAmount(DevCardType.MONUMENT, 1);
	  
	  //assert
	  hand.canPlay(DevCardType.MONUMENT);
  }
  
  @Test
  public void canPlayYOP() {
      //arrange
	  DevCardHand hand = new DevCardHand();
	  
	  //act
	  hand.setAmount(DevCardType.YEAR_OF_PLENTY, 1);
	  
	  //assert
	  hand.canPlay(DevCardType.YEAR_OF_PLENTY);
  }
  
  @Test
  public void canPlaySoldier() {
      //arrange
	  DevCardHand hand = new DevCardHand();
	  
	  //act
	  hand.setAmount(DevCardType.SOLDIER, 1);
	  
	  //assert
	  hand.canPlay(DevCardType.SOLDIER);
  }
  
  @Test
  public void canPlayBuildRoad() {
      //arrange
	  DevCardHand hand = new DevCardHand();
	  
	  //act
	  hand.setAmount(DevCardType.ROAD_BUILD, 1);
	  
	  //assert
	  hand.canPlay(DevCardType.ROAD_BUILD);
  }


}