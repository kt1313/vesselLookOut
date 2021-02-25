package pl.javastart.lookout;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LookOutWebScrap {


    public void main(String[] args) throws IOException {
        Connection connect = Jsoup.connect("https://www.vesselfinder.com/vessels/TELFORD-28-IMO-8769638");
        Document document = connect.get();
        List<String> fullDescription = new ArrayList<>();
        Elements n3Elements = document.getElementsByClass("n3");
        Elements v3Elements = document.getElementsByClass("v3");
        for (int i = 0; i < v3Elements.size(); i++) {
            fullDescription.add(n3Elements.get(i).ownText());
            fullDescription.add(v3Elements.get(i).ownText());
        }
        for (int i = 0; i < fullDescription.size(); i++) {
            if (fullDescription.get(i).equals("Coordinates")) {
                System.out.println();
                System.out.println("Coordinates: " + fullDescription.get(i + 1));
                System.out.println("-----------------------");
            }
        }
        for (String s : fullDescription) {
            System.out.println(s);
        }
    }
}
