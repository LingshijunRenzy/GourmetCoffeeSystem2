package framework;

public class FancyHtmlFormatter extends HtmlFormatter{
    private String animation;



    public FancyHtmlFormatter(){
        super();
        this.animation = "animation: rotate 2s linear infinite;";
    }



    public String formatSales(Sales sales){
        return super.formatSales(sales);
    }
}