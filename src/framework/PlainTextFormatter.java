package framework;

import java.util.*;

/**
 * This class implements a method that obtains a plain text representation of a
 * {@link BorrowerDatabase} object.
 *
 * @author author name
 * @version 1.0.0
 * @see Formatter
 * @see BorrowerDatabase
 * @see Borrower
 * @see BorrowedItems
 * @see CatalogItem
 */
public class PlainTextFormatter implements SalesFormatter {

	/**
	 * Line separator.
	 */
	private final static String NEW_LINE = System.getProperty("line.separator");

	/**
	 * Single instance of this class.
	 */
	static private PlainTextFormatter singletonInstance = null;

	/**
	 * Obtains the single instance of class <code>PlainTextFormatter</code>
	 *
	 * @return the single instance of class <code>PlainTextFormatter</code>
	 */
	static public PlainTextFormatter getSingletonInstance() {

		if (singletonInstance == null) {
			singletonInstance = new PlainTextFormatter();
		}

		return singletonInstance;
	}

	/**
	 * Obtains a plain text representation of the specified borrower database.
	 *
	 * @param borrowerDB the borrower database.
	 * @return a plain text representation of the specified {@link BorrowerDatabase}
	 *         object.
	 */
	public String format(Sales sales) {

		String out = "Sales" + NEW_LINE;
		for (Iterator<Order> i = sales.getOrdersIterator(); i.hasNext();) {
			Order order = (Order) i.next();
			out += order.getItemsIterator();
			OrderItem items = (OrderItem) order.getItemsIterator();
			if (items.getQuantity() > 0) {
				for (Iterator<Product> j = items.getItemsIterator(); j.hasNext();) {
					out += "_" + ((Product) j.next()).getCode();
				}
				out += NEW_LINE;
			}
		}
		return out;
	}

	@Override
	public String formatSales(Sales sale) {
		// TODO Auto-generated method stub
		return null;
	}
}
