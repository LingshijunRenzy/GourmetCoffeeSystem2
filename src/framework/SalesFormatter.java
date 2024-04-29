package framework;


/**
 * The interface SalesFormatter provides a method for formatting a sales report.
 *
 * @version 1.0.0
 * @see Sales
 */
public interface SalesFormatter {

    /**
     * Formats a sales report.
     *
     * @param sales the sales to be formatted.
     * @return a formatted sales report.
     */
    String formatSales(Sales sales);
}
