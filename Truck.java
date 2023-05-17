import java.util.Stack;

public class LogisticsCompany {
    private Stack<Truck> truckStack;

    public LogisticsCompany() {
        truckStack = new Stack<>();
    }

    public void addTruck(Truck truck) {
        truckStack.push(truck);
    }

    public void removeTruck() {
        if (!truckStack.isEmpty()) {
            truckStack.pop();
        }
    }

    public void addDelivery(Truck truck, Delivery delivery) {
        if (truck.canLoad()) {
            truck.load(delivery);
        } else {
            System.out.println("Truck " + truck.getLicensePlate() + " cannot load more deliveries.");
        }
    }

    public Delivery removeDelivery(Truck truck) {
        return truck.removeDelivery();
    }

    public Truck getTopTruck() {
        return truckStack.peek();
    }

    public static void main(String[] args) {
        LogisticsCompany company = new LogisticsCompany();

        // Criando alguns caminhões
        Truck truck1 = new Truck("ABC123");
        Truck truck2 = new Truck("DEF456");

        // Adicionando os caminhões à frota
        company.addTruck(truck1);
        company.addTruck(truck2);

        // Criando algumas entregas
        Delivery delivery1 = new Delivery("Item A", 1, "Destino 1");
        Delivery delivery2 = new Delivery("Item B", 2, "Destino 2");
        Delivery delivery3 = new Delivery("Item C", 3, "Destino 3");

        // Adicionando as entregas aos caminhões
        company.addDelivery(truck1, delivery1);
        company.addDelivery(truck2, delivery2);
        company.addDelivery(truck2, delivery3);

        // Removendo a entrega do topo do caminhão 2
        Delivery removedDelivery = company.removeDelivery(truck2);
        System.out.println("Delivery removed: " + removedDelivery.getContent());

        // Obtendo o caminhão do topo
        Truck topTruck = company.getTopTruck();
        System.out.println("Top Truck: " + topTruck.getLicensePlate());
    }
}
