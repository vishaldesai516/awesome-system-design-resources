package com.example.apichatexplorer;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

/**
 * Simple tool that fetches repository information from the public GitHub API.
 */
public class GitHubRepoInfoTool {
    private final HttpClient client = HttpClient.newHttpClient();

    /**
     * Fetch basic repository information.
     *
     * @param owner repository owner
     * @param repo repository name
     * @return JSON representation of the repository
     * @throws IOException if the request fails
     * @throws InterruptedException if the request is interrupted
     */
    public JSONObject fetchRepo(String owner, String repo) throws IOException, InterruptedException {
        String url = String.format("https://api.github.com/repos/%s/%s", owner, repo);
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("Accept", "application/vnd.github+json")
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new IOException("GitHub API returned status: " + response.statusCode());
        }
        return new JSONObject(response.body());
    }
}
