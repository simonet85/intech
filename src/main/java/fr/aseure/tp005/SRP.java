package fr.aseure.tp005;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class SRP {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create("https://en.wikipedia.org/wiki/Recursion_(computer_science)");
        HttpRequest req = HttpRequest.newBuilder(uri).build();
        HttpResponse<String> res = client.send(req, BodyHandlers.ofString());
        String[] split = res.body().split("\n");
        int count = 0;
        int max = 0;
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            int index = 0;
            s = s.toLowerCase();
            while (index != -1) {
                index = s.indexOf("recursion", index);
                if (index != -1) {
                    count++;
                    index += "recursion".length();
                }
            }
            if (s.length() > max) {
                max = s.length();
            }
        }
        System.out.println(count);
        System.out.println(max);
        System.exit(0);
    }
}
