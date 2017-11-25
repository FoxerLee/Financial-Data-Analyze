import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

public class GithubRepoPageProcessor implements PageProcessor {
    int myid = 0;
    int size =10;
    // 抓取网站的相关配置，可以包括编码、抓取间隔1s、重试次数等
    private Site site = Site.me().setCharset("utf8").setRetryTimes(1000).setSleepTime(1000);

    @Override
    public Site getSite() {
        return site;
    }

    @Override
    public void process(Page page) {
        Html html = page.getHtml();
        size++;
        String hahawebname = html.xpath("//div[@class=\"odd_anim_title_tnew\"]/div[@class=\"tvversion\"]/a/span[@class=\"anim_title_text\"]/h1/text()").get();//得分
        String goal = html.xpath("//div[@class=\"anim_star\"]/ul/li[@id=\"anim_score_info\"]/span[@class=\"points_text\"]/text()").get();//得分
        String mentotalold = html.xpath("//div[@class=\"anim_star\"]/ul/li[@id=\"score_statistics\"]/span[@id=\"score_count_span\"]/text()").get();//人数
        String mentotal = mentotalold.replaceAll("人评分","");
        String content = html.xpath("//div[@class=\"odd_anim_title_mnew\"]/p/span[@id=\"gamedescshort\"]/text()").get();//内容
        String contentdetail = html.xpath("//div[@class=\"odd_anim_title_mnew\"]/p/span[@id=\"gamedescall\"]/text()").get();//内容
        String url = "http://donghua.dmzj.com/donghua_info/"+size+".html";
        System.out.println("hahawebname: "+ hahawebname);
        System.out.println("goal: "+goal);
        System.out.println("mentotal: "+ mentotal);
        System.out.println("content: "+ content);
        System.out.println("url:  "+ url);
        System.out.println("contentdetail: "+ contentdetail);
    }
    public static void main(String[] args) {
        int username = 10;
        GithubRepoPageProcessor my = new GithubRepoPageProcessor();
        long startTime, endTime;
        System.out.println("开始爬取...");
        for(;username<=15000;username++) {
            startTime = System.currentTimeMillis();
            Spider.create(my).addUrl("http://donghua.dmzj.com/donghua_info/" + username + ".html").addPipeline(new JsonFilePipeline("/Users/liyuan/Desktop/test/")).thread(5).run();
            endTime = System.currentTimeMillis();
            System.out.println("爬取结束，耗时约" + ((endTime - startTime) / 1000) + "秒");
        }
    }
}