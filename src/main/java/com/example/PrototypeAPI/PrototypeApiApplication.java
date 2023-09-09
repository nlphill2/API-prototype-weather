package com.example.PrototypeAPI;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrototypeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrototypeApiApplication.class, args);
		weather();
		System.exit(0);
	}

	private static void weather() {
		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create("https://weatherapi-com.p.rapidapi.com/current.json?q=53.1%2C-0.13"))
			.header("X-RapidAPI-Key", "c41a32b8d9msha2acbbb9c337af5p1e724ajsn58270f39041f")
			.header("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com")
			.method("GET", HttpRequest.BodyPublishers.noBody())
			.build();
		HttpResponse<String> response = null;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException ex) {
			Logger.getLogger(PrototypeApiApplication.class.getName()).log(Level.SEVERE, null, ex);
		}
		System.out.println(response.body());
	}
	
}
