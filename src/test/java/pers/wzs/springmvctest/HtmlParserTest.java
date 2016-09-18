package pers.wzs.springmvctest;

import org.apache.commons.lang3.StringEscapeUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;
import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @author wangzhongshan
 * @description html解析器测试
 * @created 2016-08-18 18:44
 */
public class HtmlParserTest {

    @Test
    public void testHtmlParser() {
        //String content = "<p>\n" +
        //        "\tA：「为什么你每次都是打- -\" 而不是打= =\"？」\n" +
        //        "</p>\n" +
        //        "<p>\n" +
        //        "\tB：「因为我是单眼皮.....」\n" +
        //        "</p>\n" +
        //        "<p>\n" +
        //        "\tOS：<span>那么一单一双是不是要</span>打- =\" ? 假睫毛不就 山_山\"\n" +
        //        "</p>\n" +
        //        "<p>\n" +
        //        "\t&nbsp; &nbsp; &nbsp; &nbsp;美曈加强版 美瞳前&gt;&gt;&gt;&gt;．_． 美曈后&gt;&gt;&gt;&gt;◎_◎&nbsp;\n" +
        //        "</p>\n" +
        //        "<p>\n" +
        //        "\t&nbsp; &nbsp; &nbsp; &nbsp;还有卸妆前O_O &gt;&gt;&gt;&gt; 卸妆后o_o\n" +
        //        "</p>";


        //System.out.println("<p>\n" +
        //        "\t#DB0819早报#\n" +
        //        "</p>\n" +
        //        "<p>\n" +
        //        "\t&nbsp;1、雷军辞去欢聚时代主席职务\n" +
        //        " 全部精力抓小米；\n" +
        //        "</p>\n" +
        //        "<p>\n" +
        //        "\t&nbsp;2、滴滴涨价后再出招\n" +
        //        ":司乘分开计价 司机称\n" +
        //        "</p>");
        String content = "<p>\n" +
                "\t#DB0819早报#\n" +
                "</p>\n" +
                "<p>\n" +
                "\t&nbsp;1、<span>雷军</span>辞去欢聚时代<br/>主席职务\n" +
                " 全部精力抓小米；\n" +
                "</p>\n" +
                "<p>\n" +
                "\t&nbsp;2、滴滴涨价后再出招\n" +
                ":司乘分开计价 司机称\n" +
                "</p>";

        Document document = Jsoup.parse(content);
        Element body = document.body();
        Elements allElements = body.children();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < allElements.size(); i++) {
            Element element = allElements.get(i);
            String text = element.text();
            stringBuilder.append(text + "\n");
        }

        System.out.println(stringBuilder.toString());

        //
        //System.out.println(content);
        //content = content.replaceAll("div>", "div>%NEWLINE%").replaceAll("p>", "p>%NEWLINE%").replaceAll("br>", "br>%NEWLINE%");
        //Document document = Jsoup.parse(content);
        //String text = document.text();
        //System.out.println(text.replaceAll("%NEWLINE%","\n"));




        //content=Jsoup.clean(content.replaceAll("div>","div>%newline%").replaceAll("p>", "p>%newline%").replaceAll("br>","br>%newline%"), Whitelist.none());
        //content=content.replaceAll("%newline%","\n").replaceAll("&copy;","");
        //content=replaceSpecialChar(content);
        //System.out.println(content);

        //System.out.println(content.replaceAll("div>","div>"+System.getProperty("line.separator")).replaceAll("p>", "p>"+System.getProperty("line.separator")).replaceAll("br>","br>"+System.getProperty("line.separator")).replaceAll("nbsp;"," "));
        //
        //
        //String clean = Jsoup.clean(content.replaceAll("div>", "div>%newline%").replaceAll("p>", "p>%newline%").replaceAll("br>", "br>%newline%").replaceAll("nbsp;", " "), Whitelist.none());
        //System.out.println("######################"+clean);
        //System.out.println(clean.replaceAll("%newline%",System.getProperty("line.separator")));
    }

    private String replaceSpecialChar(String content) {
        String result = content;
        if (result != null && result.length() > 0) {
            if (result.contains("&ensp;")) {
                result = result.replaceAll("&ensp;"," ");
            }
            if (result.contains("&amp;")) {
                result = result.replaceAll("&amp;","&");
            }
            if (result.contains("&lt;")) {
                result = result.replaceAll("&lt;","<");
            }
            if (result.contains("&gt;")) {
                result = result.replaceAll("&gt;",">");
            }
            if (result.contains("&quot;")) {
                result = result.replaceAll("&quot;","\"");
            }
            if (result.contains("&nbsp;")) {
                result = result.replaceAll("&nbsp;"," ");
            }
            if (result.contains("&copy;")) {
                result = result.replaceAll("&copy;","");
            }
            if (result.contains("&reg;")) {
                result = result.replaceAll("&reg;","");
            }
        }

        return result;
    }

    @Test
    public void testTrim() throws Exception {
        String context = "<p>\n" +
                "        我一直在幻想的一个场景就是，我跟一个富二代好上了，他妈来找我，把一张支票扔在我面前。\n" +
                "</p>\n" +
                "<p>\n" +
                "        “给你五百万，离开&gt;&gt;&gt;&gt;我儿子！”\n" +
                "</p>\n" +
                "<p>\n" +
                "        “好的阿姨！！！”\n" +
                "</p>\n";

        System.out.println("原始:############"+context);

        Document doc = Jsoup.parse(context);
        String text = doc.text();
        System.out.println("#############"+text+"############");

        context=Jsoup.clean(context.replaceAll("<div>","<div>%newline%").replaceAll("<p>", "<p>%newline%").replaceAll("<br/>","<br/>%newline%"), Whitelist.none());
        context=context.replaceAll("%newline%","\n");
        System.out.println("过滤后:############"+context+"########");
        context = context.trim();
        System.out.println("trim后:############"+context+"########");
    }
}
