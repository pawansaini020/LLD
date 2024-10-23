package com.pawan.LLD.interview;

/**
 * @author Pawan Saini
 * Created on 18/10/24.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class test4 {

    public static List<String> showsInProduction(int startYear, int endYear) {
        List<String> showsList = new ArrayList<>();
        int page = 1;

        try {
            while (true) {
                String apiUrl = "https://jsonmock.hackerrank.com/api/tvseries?page=" + page;
                HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Accept", "application/json");
                connection.connect();

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder jsonResponse = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    jsonResponse.append(line);
                }
                reader.close();

                JSONObject response = new JSONObject(jsonResponse.toString());
                JSONArray data = response.getJSONArray("data");

                // Process each show in the current page
                for (int i = 0; i < data.length(); i++) {
                    JSONObject show = data.getJSONObject(i);
                    String name = show.getString("name");
                    String runtime = show.getString("runtime_of_series");

                    // Extract start and end years from runtime
                    int showStartYear = extractStartYear(runtime);
                    int showEndYear = extractEndYear(runtime);

                    // Check if the show meets the criteria
                    if (isShowInProduction(showStartYear, showEndYear, startYear, endYear)) {
                        showsList.add(name);
                    }
                }

                // Check if there are more pages
                if (page < response.getInt("total_pages")) {
                    page++;
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Sort the shows list alphabetically
        Collections.sort(showsList);
        return showsList;
    }

    // Helper method to extract the start year from runtime
    private static int extractStartYear(String runtime) {
        String[] parts = runtime.replaceAll("\\(I\\)", "").replaceAll("\\(II\\)", "").trim().split("-");
        if (parts.length > 0) {
            return Integer.parseInt(parts[0].replaceAll("[^\\d]", ""));
        }
        return -1; // Default value if parsing fails
    }

    // Helper method to extract the end year from runtime
    private static int extractEndYear(String runtime) {
        String[] parts = runtime.replaceAll("\\(I\\)", "").replaceAll("\\(II\\)", "").trim().split("-");
        if (parts.length > 1) {
            return Integer.parseInt(parts[1].replaceAll("[^\\d]", ""));
        } else if (parts.length == 1) {
            return Integer.parseInt(parts[0].replaceAll("[^\\d]", ""));
        }
        return -1; // Default value if parsing fails
    }

    // Check if the show is within the desired production years
    private static boolean isShowInProduction(int showStartYear, int showEndYear, int startYear, int endYear) {
        return (showStartYear >= startYear) && (endYear == -1 || showEndYear <= endYear);
    }

    public static void main(String[] args) {
        // Example usage
        List<String> result = showsInProduction(2006, 2011);
        System.out.println("Shows in production between 2006 and 2011:");
        for (String show : result) {
            System.out.println(show);
        }
    }
}

}
