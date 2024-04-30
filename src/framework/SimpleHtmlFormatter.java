package framework;

public class SimpleHtmlFormatter extends HtmlFormatter{
    //使用响应式设计，responsive为true时，添加css样式
    private boolean responsive;

    public SimpleHtmlFormatter(){
        super();
        this.responsive = false;
    }

    @Override
    public String formatSales(Sales sales){
        String html = super.formatSales(sales);
        if(responsive){
            String css = "<style>@media screen and (max-width: 600px) {body { font-size: 18px; }}</style>";
            html = html.replace("</style>", css + "</style>");
        }
        return html;
    }
}