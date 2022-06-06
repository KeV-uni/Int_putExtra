import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AirportTest {

   @DisplayName("Dado un vuelo economico")
   @Nested
   class EconomyFlightTest{
      private Flight economyFlight;

      @BeforeEach
      void setUp(){
         economyFlight = new EconomyFlight("1"); //Inicializando un vuelo economico
      }

      @Test
      public void testEconomyFlightRegularPassenger(){
         Passenger jessica = new Passenger("Jessica",false); //Inicializando un pasajero noVIP jessica

         assertAll(()-> assertEquals("1", economyFlight.getId()),
                 ()-> assertEquals(true, economyFlight.addPassenger(jessica)),
                 ()-> assertEquals(1, economyFlight.getPassengersList().size()),
                 ()-> assertEquals("Jessica", economyFlight.getPassengersList().get(0).getName()),
                 ()-> assertEquals(true, economyFlight.removePassenger(jessica)),
                 ()->assertEquals(0, economyFlight.getPassengersList().size()));
      }

      @Test
      public void testEconomyFlightVipPassenger(){
         Passenger cesar = new Passenger("Cesar", true);

         assertAll(()-> assertEquals("1", economyFlight.getId()),
                 ()-> assertEquals(true, economyFlight.addPassenger(cesar)),
                 ()-> assertEquals(1, economyFlight.getPassengersList().size()),
                 ()-> assertEquals("Cesar", economyFlight.getPassengersList().get(0).getName()),
                 ()-> assertEquals(false, economyFlight.removePassenger(cesar)),
                 ()-> assertEquals(1, economyFlight.getPassengersList().size()));
      }
   }

   @DisplayName("Dado un vuelo de negocios")
   @Nested
   class BusinessFlightTest{
      private Flight businessFlight;

      @BeforeEach
      void setUp() {
         businessFlight = new BusinessFlight("2"); //Inicializando un vuelo de negocios
      }

      @Test
      public void testBusinessFlightRegularPassenger() {
         Passenger jessica = new Passenger("Jessica", false); //Incializando un pasajero noVIP jessica

         assertAll("Verificando las condiciones para un pasajero regular en un vuelo de negocios.",
                 ()-> assertEquals(false, businessFlight.addPassenger(jessica)),
                 ()-> assertEquals(0, businessFlight.getPassengersList().size()),
                 ()-> assertEquals(false, businessFlight.removePassenger(jessica)),
                 ()-> assertEquals(0, businessFlight.getPassengersList().size()));
      }


      @Test
      public void testBusinessFlightVipPassenger() {
         Passenger cesar = new Passenger("Cesar", true); //Inicializando un pajasero VIP cesar.

         assertAll("Verificando las condiciones para un pasajero VIP en un vuelo de negocios",
                 ()-> assertEquals(true, businessFlight.addPassenger(cesar)),
                 ()-> assertEquals(1, businessFlight.getPassengersList().size()),
                 ()-> assertEquals(false, businessFlight.removePassenger(cesar)),
                 ()-> assertEquals(1, businessFlight.getPassengersList().size()));
      }

   }
}
