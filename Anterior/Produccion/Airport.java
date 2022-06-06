public class Airport {

    public static void main(String[] args) {
        Flight economyFlight = new Flight("1", "Economico");
        Flight businessFlight = new Flight("2", "Negocios");

        Passenger cesar = new Passenger("Cesar", true);
        Passenger jessica = new Passenger("Jessica", false);

        businessFlight.addPassenger(cesar);     //Agregando el pasajero VIP cesar
        businessFlight.removePassenger(cesar);  //Denegacion, no se puede remover un pasajero VIP
        businessFlight.addPassenger(jessica);   //Denegacion, no se puede agregar un pasajero noVIP al vuelo de negocios
        economyFlight.addPassenger(jessica);    //Agregando la pasajera regular jessica

        System.out.println("Lista de pasajeros de vuelos de negocios:");
        for (Passenger passenger : businessFlight.getPassengersList()) {
            System.out.println(passenger.getName());
        }

        System.out.println("Lista de pasajeros de vuelos economicos:");
        for (Passenger passenger : economyFlight.getPassengersList()) {
            System.out.println(passenger.getName());
        }
    }
}
