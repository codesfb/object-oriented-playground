package LogiTrack;

public non-sealed class ExpressDelivery extends Delivery{
    private final Double priorityTax;

    private ExpressDelivery(String id, String destination, Double priorityTax) {
        super(id, destination);
        this.priorityTax = priorityTax;
    }

    public ExpressDelivery of(String id, String destination, Double priorityTax) {
        return new ExpressDelivery(id,destination, priorityTax);
    }

    @Override
    public Double calculateCost() {
        //fee plus tax
        return priorityTax + 20.0;
    }

    public Double getPriorityTax() {
        return priorityTax;
    }
}
