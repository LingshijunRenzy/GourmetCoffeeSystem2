package framework;

import java.util.*;

/**
 * This class implements a method that obtains an XML representation of a
 * {@link Sales} object.
 *
 * @author author name
 * @version 1.0.0
 * @see OrderItemsFormatter
 * @see Sales
 * @see OrderItem
 * @see OrderItem
 * @see OrderItem
 */
public class XMLSalesFormatter implements SalesFormatter {

	/**
	 * Line separator.
	 */
	private final static String NEW_LINE = System.getProperty("line.separator");

	/**
	 * Single instance of this class.
	 */
	static private XMLSalesFormatter singletonInstance = null;

	/**
	 * Obtains the single instance of class <code>XMLOrderItemsFormatter</code>
	 *
	 * @return the single instance of class <code>XMLOrderItemsFormatter</code>
	 */
	static public XMLSalesFormatter getSingletonInstance() {

		if (singletonInstance == null) {
			singletonInstance = new XMLSalesFormatter();
		}

		return singletonInstance;
	}

	/**
	 * Obtains an XML representation of the specified order database.
	 *
	 * @param sales the order database.
	 * @return a XML representation of the specified {@link Sales}
	 *         object.
	 */
	public String formatOrderItems(Sales sales) {

		String out = "<Sales>" + NEW_LINE;

		for (Iterator<Order> i = sales.getOrdersIterator(); i.hasNext();) {

			Order order = (Order) i.next();

			out += "  <OrderItem id=\"" + order.getItemsIterator() + "\">" + NEW_LINE;

			OrderItem items = (OrderItem) order.getItemsIterator();

			if (items.getQuantity() > 0) {
				out += "    <OrderItem>" + NEW_LINE;

				for (Iterator<Product> j = items.getItemsIterator(); j.hasNext();) {

					Product item = (Product) j.next();

					out += "      <OrderItem id=\"" + item.getCode() + "description=\">" + item.getDescription()+ "price=\">" + item.getPrice() + "</OrderItem>"
							+ NEW_LINE;
				}
				out += "    </OrderItem>" + NEW_LINE;
			}
			out += "  </OrderItem>" + NEW_LINE;
		}
		out += "</Sales>";

		return out;
	}

	@Override
	public String formatSales(Sales sale) {
		// TODO Auto-generated method stub
		return null;
	}
}
