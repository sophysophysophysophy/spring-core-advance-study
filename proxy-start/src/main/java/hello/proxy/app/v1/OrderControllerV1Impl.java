package hello.proxy.app.v1;

public class OrderControllerV1Impl implements OrderControllerV1{

    private final OrderServiceV1 orderServiceV1;

    public OrderControllerV1Impl(OrderServiceV1 orderServiceV1) {
        this.orderServiceV1 = orderServiceV1;
    }

    @Override
    public String request(String itemid) {
        orderServiceV1.orderItem(itemid);
        return "ok";
    }

    @Override
    public String noLog() {
        return null;
    }
}
