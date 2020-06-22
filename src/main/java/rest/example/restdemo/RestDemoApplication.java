package rest.example.restdemo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import rest.example.restdemo.service.TourPackageService;
import rest.example.restdemo.service.TourService;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class RestDemoApplication implements CommandLineRunner{

	@Autowired
	private TourPackageService tourPackageService;
	@Autowired
	private TourService tourService;

	public static void main(String[] args) {
		SpringApplication.run(RestDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		tourPackageService.createTourPackage("BC", "Backpack Cal");
		tourPackageService.createTourPackage("CC", "California Calm");
		tourPackageService.createTourPackage("CH", "California Hot Spring");
		tourPackageService.createTourPackage("CY", "Cycle California");
		tourPackageService.createTourPackage("DS", "Desert Sea");
		tourPackageService.createTourPackage("KC", "Kids Cali");
		tourPackageService.createTourPackage("NW", "Nature Witch");
		tourPackageService.createTourPackage("SC", "Snowboard Cali");
		tourPackageService.createTourPackage("TC", "Taste of Cali Witch");

		tourPackageService.lookup().forEach(System.out::println);

		System.out.println("Number of tours " + tourPackageService.total());

	}

	static class TourFromFile{
		private String packageType, title, description, blurb,
				price, length, bullets, keywords, difficulty, region;

		static List<TourFromFile> importTours() throws IOException {
			return new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
					.readValue(TourFromFile.class.getResourceAsStream("/ExploreCalifornia.json"),
							new TypeReference<List<TourFromFile>>() {});
		}
	}
}
