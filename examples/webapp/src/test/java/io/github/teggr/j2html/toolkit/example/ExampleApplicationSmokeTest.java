package io.github.teggr.j2html.toolkit.example;

import io.github.teggr.j2html.toolkit.integration.bootstrap.BootstrapConfig;
import io.github.teggr.j2html.toolkit.integration.htmx.HtmxConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ExampleApplicationSmokeTest {

    private final HttpClient httpClient = HttpClient.newHttpClient();

    @Value("${local.server.port}")
    private int port;

    @Test
    void servesSpringResolvedJ2htmlPageWithBootstrapAssets() throws IOException, InterruptedException {
        HttpResponse<String> response = get("/");

        assertEquals(200, response.statusCode());
        assertTrue(response.body().contains("<title>Home</title>"));
        assertTrue(response.body().contains("Hello World"));
        assertTrue(response.body().contains("class=\"container\""));
        assertTrue(response.body().contains(BootstrapConfig.CDN_MIN_CSS_URL));
        assertTrue(response.body().contains(BootstrapConfig.CDN_BUNDLE_MIN_JS_URL));
    }

    @Test
    void servesHtmxAndBootstrapShowcasesWithIntegrationMarkup() throws IOException, InterruptedException {
        HttpResponse<String> htmxResponse = get("/htmx");
        HttpResponse<String> bootstrapResponse = get("/bootstrap");

        assertEquals(200, htmxResponse.statusCode());
        assertTrue(htmxResponse.body().contains("<title>HTMX Showcase</title>"));
        assertTrue(htmxResponse.body().contains("hx-get=\"/htmx/snippet\""));
        assertTrue(htmxResponse.body().contains("hx-target=\"#htmx-live-result\""));
        assertTrue(htmxResponse.body().contains(HtmxConfig.CDN_MIN_JS_URL));

        assertEquals(200, bootstrapResponse.statusCode());
        assertTrue(bootstrapResponse.body().contains("<title>Bootstrap Showcase</title>"));
        assertTrue(bootstrapResponse.body().contains("form-control"));
        assertTrue(bootstrapResponse.body().contains("btn-primary"));
        assertTrue(bootstrapResponse.body().contains("alert-primary"));
    }

    private HttpResponse<String> get(String path) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:" + port + path))
                .GET()
                .build();
        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
