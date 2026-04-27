package LogiTrack;

import java.util.ArrayList;
import java.util.List;

public class DeliveryRepository implements  Repository<Delivery,String>{
    private List <Delivery> elements = new ArrayList<>() ;
    private int count;

    public DeliveryRepository() {

    }

    @Override
    public void save(Delivery entity) {
        elements.add(entity);
        count++;
    }

    @Override
    public Delivery findById(String id) {
        for(Delivery delivery: elements){
            if(delivery.getId().equals(id))
                return delivery;

        }
        return null;
    }

    @Override
    public Delivery[] findAll() {
        return elements.toArray(new Delivery[0]);
    }
}
