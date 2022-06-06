import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AirportTest {

    @DisplayName("Dado que hay un vuelo economico")
    @Nested
    class EconomyFlightTest {

        private Flight economyFlight;

        @BeforeEach
        void setUp() {
            economyFlight = new EconomyFlight("1"); //Inicializando un vuelo economico
        }

        @Test
        public void testEconomyFlightRegularPassenger() {
            Passenger jessica = new Passenger("Jessica", false); //Inicializando un pasajero noVIP jessica

            assertEquals("1", economyFlight.getId()); //Comparando el ID esperado con el ID del vuelo economico
            assertEquals(true, economyFlight.addPassenger(jessica)); //Comparando true con que se pueda añadir la pasajera noVIP jessica al vuelo economico
            assertEquals(1, economyFlight.getPassengers().size()); //Comparando 1 con el tamaño de la lista de pasajeros del vuelo economico(jessica)
            assertEquals("Jessica", economyFlight.getPassengers().get(0).getName()); //Comparando "Jessica" con el nombre del pasajero[0] de la lista de pasajeros

            assertEquals(true, economyFlight.removePassenger(jessica)); //Comparando true con que se pueda remover la pasajera noVIP jessica del vuelo economico
            assertEquals(0, economyFlight.getPassengers().size()); //Comparando 0 con el tamaño de la lista de pasajeros del vuelo economico()
        }

        @Test
        public void testEconomyFlightVipPassenger() {
            Passenger cesar = new Passenger("Cesar", true); //Inicializando un pajasero VIP cesar.

            assertEquals("1", economyFlight.getId()); //Comparando el ID esperado con el ID del vuelo economico
            assertEquals(true, economyFlight.addPassenger(cesar)); //Comparando true con que se pueda añadir un pasajero VIP cesar al vuelo economico
            assertEquals(1, economyFlight.getPassengers().size()); //Comparando 1 con el tamaño de la lista de pasajeros del vuelo economico(cesar)
            assertEquals("Cesar", economyFlight.getPassengers().get(0).getName()); //Comparando "cesar" con el nombre del pasajero[0] de la lista de pasajeros

            assertEquals(false, economyFlight.removePassenger(cesar)); //Comparando false con que se pueda remover el pasajero VIP cesar del vuelo economico
            assertEquals(1, economyFlight.getPassengers().size()); //Comparando 1 con el tamaño de la lista de pasajeros del vuelo economico(cesar)
        }

    }

    @DisplayName("Dado que hay un vuelo negocios")
    @Nested
    class BusinessFlightTest {
        private Flight businessFlight;

        @BeforeEach
        void setUp() {
            businessFlight = new BusinessFlight("2"); //Inicializando un vuelo de negocios
        }

        @Test
        public void testBusinessFlightRegularPassenger() {
            Passenger jessica = new Passenger("Jessica", false); //Incializando un pasajero noVIP jessica

            assertEquals(false, businessFlight.addPassenger(jessica));//Comparando false con que se pueda añadir un pasajero noVIP jessica al vuelo de negocios
            assertEquals(0, businessFlight.getPassengers().size());  //Comparando 0 con el tamaño de la lista de pasajeros del vuelo de negocios()
            assertEquals(false, businessFlight.removePassenger(jessica)); //Comparando false con que se pueda remover el pasajero noVIP jessica del vuelo de negocios (OJO: Jessica nunca fue añadida, ¿como puedo eliminar a alguien que nunca fue agregada?)
            assertEquals(0, businessFlight.getPassengers().size()); //Comparando 0 con el tamaño de la lista de pasajeros del vuelo de negocios()

        }

        @Test
        public void testBusinessFlightVipPassenger() {
            Passenger cesar = new Passenger("Cesar", true); //Inicializando un pajasero VIP cesar.

            assertEquals(true, businessFlight.addPassenger(cesar)); //Comparando true con que se pueda añadir un pasajero VIP cesar al vuelo de negocios
            assertEquals(1, businessFlight.getPassengers().size()); //Comparando 1 con el tamaño de la lista de pasajeros del vuelo de negocios(cesar)
            assertEquals(false, businessFlight.removePassenger(cesar)); //Comparando false con que se pueda remover el pasajero VIP cesar del vuelo de negocios
            assertEquals(1, businessFlight.getPassengers().size()); //Comparando 1 con el tamaño de la lista de pasajeros del vuelo de negocios(cesar)

        }
    }
}