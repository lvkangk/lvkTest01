package JsoupTest;

import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lvkang on 16-5-18.
 */
public class JsoupTest {

    @Test
    //盛大游戏&ats 爬测评成绩   2016-09-29
    public void test02() throws IOException {
        String url = "https://weicewang.com/user/detail/index/1001600166/bf838fc0bcc501afd11933a536b32973";
        //url = "http://www.baidu.com";
        Document doc = Jsoup.connect(url).get();
        Element scoreTable = doc.select("tbody.tablelist").first(); //只有第一个tablelist是分数的
        Elements trs = scoreTable.select("tr");
        long score = 0l;
        for (Element tr : trs){
            Element scoreTd = tr.select("td").get(3);               //第4个td是分数
            String scoreStr = scoreTd.text();
            if(!StringUtil.isBlank(scoreStr) && !scoreStr.equals("0")){
                String project = tr.select("td").get(0).text();     //第1个td是科目
                score += Long.valueOf(scoreStr);
                System.out.println(project+":"+scoreStr+"分");
            }
        }
        System.out.println("总分:"+score+"分");
    }

    @Test
    //拉钩菜单爬虫   2016-05-18
    public void test01() throws IOException {
        Document doc = Jsoup.connect("https://www.lagou.com/").get();
        Elements elements = doc.select("div.mainNavs > div.menu_box");
        Map<String,Map<String,List<String>>> map = new HashMap<String, Map<String, List<String>>>();
        for (int i=0;i<elements.size();i++){
            String parentStr = elements.get(i).select("div.menu_main>h2").text();
            Elements dls = elements.get(i).select("div.menu_sub>dl");
            Map<String,List<String>> dlMap = new HashMap<String, List<String>>();
            for (int j=0;j<dls.size();j++){
                List<String> ddList = new ArrayList<String>();
                String dlKey = dls.get(j).select("dt>a").text();
                String[] ddArry = dls.get(j).select("dd>a").text().split(" ");
                for (String dd:ddArry){
                    ddList.add(dd);
                }
                dlMap.put(dlKey, ddList);
            }
            map.put(parentStr, dlMap);
        }
        System.out.println(map);
    }

}
