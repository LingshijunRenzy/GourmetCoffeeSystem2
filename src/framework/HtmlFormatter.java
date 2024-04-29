package framework;

import java.util.Iterator;

public class HtmlFormatter implements SalesFormatter{
    private final String cssStyle = "body { font-family: Arial, sans-serif; } h1, h2 { color: #333; }";


    //设置为protected，防止外部类创建实例
    protected HtmlFormatter() {
    }



    private static HtmlFormatter singletonInstance = null;



    public static HtmlFormatter getSingletonInstance() {
        if(singletonInstance == null)
            singletonInstance = new HtmlFormatter();

        return singletonInstance;
    }



    @Override
    public String formatSales(Sales sales) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><body><style>").append(cssStyle).append("</style>");
        sb.append("<h1>Sales Report</h1>");

        // Iterate over all orders
        Iterator<Order> ordersIterator = sales.getOrdersIterator();
        while (ordersIterator.hasNext()) {
            Order order = ordersIterator.next();
            sb.append("<h2>Order</h2>");
            sb.append("<ul>");

            Iterator<OrderItem> itemsIterator = order.getItemsIterator();
            while (itemsIterator.hasNext()) {
                OrderItem item = itemsIterator.next();
                sb.append("<li>");
                sb.append(item.getQuantity()).append(" x ").append(item.getProduct().getCode());
                sb.append(" (").append(item.getProduct().getPrice()).append(" each)");
                sb.append(" = ").append(item.getCost());
                sb.append("</li>");
            }

            sb.append("</ul>");
            sb.append("Total cost: ").append(order.getTotalCost());
        }

        sb.append("</body></html>");
        return sb.toString();
    }
}
