import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
	public static void main(String[] args) {
		Document doc = null;

		String uri = "http://www.diningcode.com/list.php?query=송파구 뼈다귀해장국";

		try {
			doc = Jsoup.connect(uri).get();
		} catch (IOException e1) {

		}

		Elements restaurants = doc.select("div#search_list dc-restaurant");
		for (Element restaurant : restaurants) {
			Elements contentElements = restaurant.select("dc-restaurant-contents");
			Elements infoElements = restaurant.select("dc-restaurant-info");

			Elements nameTag = contentElements.select("div.dc-restaurant-name");
			Elements categorieTag = contentElements.select("div.dc-restaurant-category");
			Elements infoTag = infoElements.select("div.dc-restaurant-info");

			String name = nameTag.text();
			String link = nameTag.select("a").attr("abs:href");
			String category = categorieTag.text();
			String addr = infoTag.get(1).select("div.dc-restaurant-info-text").text();
			String phone = infoTag.get(2).select("div.dc-restaurant-info-text").text();

			System.out.println("가게이름 : " + name);
			System.out.println("링   크 : " + link);
			System.out.println("카테고리 : " + category);
			System.out.println("주   소 : " + addr);
			System.out.println("전화번호 : " + phone);
			System.out.println("###################################");
		}
		System.out.println("complete");
	}
}
