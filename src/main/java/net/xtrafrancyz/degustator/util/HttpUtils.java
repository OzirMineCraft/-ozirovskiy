package net.xtrafrancyz.degustator.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import net.xtrafrancyz.degustator.Degustator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author xtrafrancyz
 */
public class HttpUtils {
    public static String get(String url) throws IOException {
        HttpGet request = new HttpGet(url);
        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null)
            result.append(line);
        return result.toString();
    }
    
    public static String apiGet(String query) throws IOException {
        HttpGet request = new HttpGet("http://api.vime.world/" + query);
        request.addHeader("Access-Token", Degustator.instance().config.vimeApiToken);
        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null)
            result.append(line);
        return result.toString();
    }
}
