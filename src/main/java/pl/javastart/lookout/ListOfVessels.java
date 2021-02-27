package pl.javastart.lookout;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class ListOfVessels {
    public static void main(String[] args) throws IOException {

        String vslName = "Dolphin";
        Connection connect = Jsoup.connect("https://www.shiplocation.com/vessels?page=1&vessel=" + vslName + "&sort=none&direction=none&flag=none");
        Document document = connect.get();
        Elements vElements = document.getElementsByClass("vessel_td");
        List<String> listOfVessels = new ArrayList<>();
        List<String> listOfVessels2 = new ArrayList<>();
        System.out.println("");
        System.out.println("Szukasz statku: "+vslName);
        System.out.println("*******************************");
        System.out.println("Znalazłeś: ");
        for (Element e : vElements
        ) {
            //sprawdz czy element zawiera w ownText()
            // nazwe szukanego statku
            String testString = vslName.substring(0, vslName.length());
            if (!e.select("a").text().equals("")) {
                listOfVessels.add(e.select("a").text());
            }
        }
        int i=1;
        for (String s : listOfVessels
        ) {
            if (!s.equals("")) {
                System.out.println(i+":"+s); i++;           }
        }
        System.out.println("*******************************");
        System.out.println("Wybierz nr.");
    }
}
