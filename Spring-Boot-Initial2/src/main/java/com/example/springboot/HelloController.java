package com.example.springboot;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@RestController
public class HelloController {

	@GetMapping("/Translate/{string}/{Language}")
	public String index(@PathVariable("string") String string , @PathVariable("Language") String Language) throws UnirestException {
		Scanner sc = new Scanner(System.in);
		String Lang1 = sc.nextLine();

		HttpResponse<String> response2 = Unirest.post("https://google-translate1.p.rapidapi.com/language/translate/v2/detect")
				.header("content-type", "application/x-www-form-urlencoded")
				.header("accept-encoding", "application/gzip")
				.header("x-rapidapi-host", "google-translate1.p.rapidapi.com")
				.header("x-rapidapi-key", "0b6e28a197mshf3136520fe48378p112732jsn8fb07fbd35d8")
				.body("q=Hello")
				.asString();

		HttpResponse<String> response1 = Unirest.get("https://google-translate1.p.rapidapi.com/language/translate/v2/languages")
				.header("accept-encoding", "application/gzip")
				.header("x-rapidapi-host", "google-translate1.p.rapidapi.com")
				.header("x-rapidapi-key", "0b6e28a197mshf3136520fe48378p112732jsn8fb07fbd35d8")
				.asString();
		HttpResponse<String> response3 = Unirest.post("https://google-translate1.p.rapidapi.com/language/translate/v2")
				.header("content-type", "application/x-www-form-urlencoded")
				.header("accept-encoding", "application/gzip")
				.header("x-rapidapi-host", "google-translate1.p.rapidapi.com")
				.header("x-rapidapi-key", "0b6e28a197mshf3136520fe48378p112732jsn8fb07fbd35d8")
				.body("q="+string+"&target="+Lang1+"&source="+Language)
				.asString();

		return response3.getBody();
	}
}
