package framework;

public class SalesInfo {
    private SalesFormatter formatter;
    private String sales;

    public void setSalesFormatter(SalesFormatter newFormatter) {
        this.formatter = newFormatter;
    }

    public void displaySales() {
        if (this.formatter != null) {
            if (this.sales != null) {
                String formattedSales = this.formatter.formatSales(sales);
                System.out.println(formattedSales);
            } else {
                System.out.println("Sorry, no sales data");
            }
        } else {
            System.out.println("Sorry, no sales formatter set");
        }
    }

    public void setSalesFormatterByNumber(int number) {
        switch (number) {
            case 1:
                setSalesFormatter(new PlainTextFormatter());
                break;
            case 2:
                setSalesFormatter(new FancyHtmlFormatter());
                break;
            case 3:
                setSalesFormatter(new SimpleHtmlFormatter());
                break;
            case 4:
                setSalesFormatter(new XMLSalesFormatter());
                break;
            default:
                System.out.println("Error number for formatter set");
                break;
        }
    }
}