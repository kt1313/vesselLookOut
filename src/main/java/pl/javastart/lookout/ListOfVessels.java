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
        String vslName = "Telford";
        Connection connect = Jsoup.connect("https://www.shiplocation.com/vessels?page=1&vessel=" + vslName + "&sort=none&direction=none&flag=none");
        Document document = connect.get();
        Elements vElements = document.getElementsByClass("vessel_td");
        List<String> listOfVesselsNames = new ArrayList<String>();
        List<String> listOfVesselsIMOs = new ArrayList<>();
        System.out.println("");
        System.out.println("Szukasz statku: " + vslName);
        System.out.println("*******************************");
        System.out.println("Znalazłeś: ");
        for (Element e : vElements
        ) {
            //sprawdz czy element nie jest pusty i dodaj do listOfVessels
            //znajdz IMO nr, polacz z nazwa statku i dodaj do listy
            if (!e.select("a").text().equals("")) {
//                String nameAndIMOString=e.select("a").text()+" IMO nr: "+e.parent().getElementsByClass("vessel_td td_imo").text();
                listOfVesselsNames.add(e.select("a").text());
                listOfVesselsIMOs.add(e.parent().getElementsByClass("vessel_td td_imo").text());
            }
        }
        for (int i = 0; i < listOfVesselsNames.size(); i++) {
            System.out.println(i + 1 + ": " + listOfVesselsNames.get(i) + " nr IMO: "+listOfVesselsIMOs.get(i));
        }
        System.out.println("*******************************");
        System.out.println("Wybierz nr.");
    }
}
