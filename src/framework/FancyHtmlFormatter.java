package framework;

public class FancyHtmlFormatter extends HtmlFormatter{
    private boolean responsive;
    private String animation;


    public FancyHtmlFormatter(){
        super();
        this.responsive = true;
        this.animation = "mymove 5s infinite";
    }


    @Override
    public String formatSales(Sales sales){
        String html = super.formatSales(sales);
        if(responsive){
            String css = "<style>@media screen and (max-width: 600px) {body { font-size: 18px; }}</style>";
            html = html.replace("</style>", css + "</style>");
        }
        if(!animation.isEmpty()){
            String css = "<style>@keyframes mymove {from {top: 0px;}to {top: 200px;}}</style>";
            html = html.replace("</style>", css + "</style>");
            html = html.replace("<h2>Order</h2>", "<h2 style=\"animation:" + animation + "\">Order</h2>");
        }
        return html;
    }
}