package LogiTrack;

public non-sealed class StandardDelivery extends Delivery {
    private final Double weight   ;

    private StandardDelivery(String id, String destination, Double weight) {
        super(id, destination);
        this.weight = weight;
    }



    @Override
    public Double calculateCost() {
        return weight * 5.0;
    }

    public Double getWeight() {
        return weight;
    }
}
