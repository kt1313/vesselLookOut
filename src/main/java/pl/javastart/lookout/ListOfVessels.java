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

public class ListOfVessels {

private List<String> listOfVesselsNames = new ArrayList<>();
private List<String> listOfVesselsIMOs = new ArrayList<>();


public ListOfVessels(List<String> listOfVesselsNames , List<String> listOfVesselsIMOs){

    this.listOfVesselsNames=listOfVesselsNames;
    this.listOfVesselsIMOs=listOfVesselsIMOs;
}

    public List<String> getListOfVesselsNames() {
        return listOfVesselsNames;
    }
    public List<String> getListOfVesselsIMOs() {
        return listOfVesselsIMOs;
    }

    //metoda tworzy liste nazw statkow z nr IMO na podstawie podanej nazwy
    static public ListOfVessels getVslsList(String vslName) throws IOException {

          List<String> listOfVesselsNames = new ArrayList<>();
          List<String> listOfVesselsIMOs = new ArrayList<>();

        Connection connect = Jsoup.connect("https://www.shiplocation.com/vessels?page=1&vessel=" + vslName + "&sort=none&direction=none&flag=none");
        Document document = connect.get();
        Elements vElements = document.getElementsByClass("vessel_td");
        System.out.println("");
        System.out.println("Szukasz statku: " + vslName);
        System.out.println("*******************************");
        System.out.println("Znalazłeś: ");
        for (Element e : vElements
        ) {
            //sprawdz czy element nie jest pusty i dodaj do listOfVessels
            //znajdz IMO nr, polacz z nazwa statku i dodaj do listy
            if (!e.select("a").text().equals("")) {
                listOfVesselsNames.add(e.select("a").text().replace(" ","-"));
                listOfVesselsIMOs.add(e.parent().getElementsByClass("vessel_td td_imo").text());
            }
        }
        for (int i = 0; i < listOfVesselsNames.size(); i++) {
            System.out.println(i + 1 + ": " + listOfVesselsNames.get(i) + " nr IMO: " + listOfVesselsIMOs.get(i));
        }
        System.out.println("*******************************");
        System.out.println("Wybierz nr.");
        return new ListOfVessels( listOfVesselsNames,listOfVesselsIMOs);
    }
}
