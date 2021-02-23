package pl.javastart.lookout;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;


public class LookOutWebScrap {



    public class JsoupTest {
        public  void main(String[] args) throws IOException {
            Connection connect = Jsoup.connect("http://www.onet.pl/");
            Document document = connect.get();
            Elements allH1 = document.select("h1");
            for(Element elem: allH1) {
                System.out.println(elem.text());
            }
        }
    }
}
