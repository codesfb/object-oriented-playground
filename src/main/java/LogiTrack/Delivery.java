package LogiTrack;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract  sealed  class Delivery permits StandardDelivery, ExpressDelivery {
    private  String id;
    private String destination;
    private DeliveryStatus status;
    private  LocalDateTime creationDate;

    //can i create many constructors ?
    public Delivery() {
        this.creationDate =LocalDateTime.now() ;
        this.status =DeliveryStatus.PENDING;
    }

    public Delivery(String id, String destination) {
        this.id = id;
        this.destination = destination;
    }

    public abstract Double calculateCost();
    public void completeDelivery(){
        status = DeliveryStatus.DELIVERED;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return Objects.equals(id, delivery.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public String getId() {
        return id;
    }

    public String getDestination() {
        return destination;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}
