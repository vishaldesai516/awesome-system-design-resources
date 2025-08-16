package com.example.apichatexplorer;

import java.util.Scanner;
import org.json.JSONObject;

/**
 * Minimal CLI entry point demonstrating how the tool can be invoked.
 */
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter repository (owner/repo): ");
        String input = scanner.nextLine().trim();
        String[] parts = input.split("/");
        if (parts.length != 2) {
            System.out.println("Invalid input. Use owner/repo.");
            return;
        }

        GitHubRepoInfoTool tool = new GitHubRepoInfoTool();
        JSONObject repo = tool.fetchRepo(parts[0], parts[1]);

        System.out.println("Repository: " + repo.getString("full_name"));
        System.out.println("Description: " + repo.optString("description", "(no description)"));
        System.out.println("Stars: " + repo.getInt("stargazers_count"));
    }
}
