package pl.javastart.lookout;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetDetails {


    //        public void main(String[] args) throws IOException {
    static public List<String> getVslDetails(String vslNameAndIMO) throws IOException {
        Connection connect = Jsoup.connect("https://www.vesselfinder.com/vessels/" + vslNameAndIMO);
        Document document = connect.get();
        List<String> fullVslDescription = new ArrayList<>();
        Elements n3Elements = document.getElementsByClass("n3");
        Elements v3Elements = document.getElementsByClass("v3");
        Elements posElements = document.getElementsByClass("text2");
        fullVslDescription.add(posElements.text());
        for (int i = 1; i <= v3Elements.size(); i++) {
            fullVslDescription.add(n3Elements.get(i-1).ownText());
            fullVslDescription.add(v3Elements.get(i-1).ownText());
        }


//        Elements coordinatesLatElements=document.getElementsByClass("coordinate lat");
//        Elements coordinatesLonElements=document.getElementsByClass("coordinate lon");
//
//        for (int i = 0; i < coordinatesLatElements.size(); i++) {
//            fullVslDescription.add(coordinatesLatElements.get(i).ownText());
//            fullVslDescription.add(coordinatesLonElements.get(i).ownText());
//        }
        System.out.println("Vessel: " + vslNameAndIMO);
        System.out.println("Coordinates Lat: " + fullVslDescription.get(0));
        System.out.println("Coordinates Long: " + fullVslDescription.get(1));
        System.out.printf(posElements.text());

        return fullVslDescription;
    }

}


