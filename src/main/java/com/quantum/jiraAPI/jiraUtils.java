package com.quantum.jiraAPI;


import org.apache.commons.codec.binary.Base64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by uzie on 2/21/17.
 */
public class jiraUtils {
    static String  jirauser= "admin";
    static String jirapassword = "Perfecto1";


    public static String getIssueStatus(String issue) {
        String jira = "https://uzitest.atlassian.net/";
        String jiraIssues = "rest/api/2/issue/%1$s?fields=status";
        String url = jira + String.format(jiraIssues,issue);


        jiraIssue i = new jiraIssue();

        i.parse( simpleGet(url));

        return i.getStatus();
    }

    private static String simpleGet(String target) {

        HttpURLConnection con = null;
        try {
            URL obj = new URL(target);

            con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", "Basic " + getAuth(jirauser,jirapassword));

            int responseCode = con.getResponseCode();
             if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                return response.toString();
            } else {
                return "GET request not worked";
            }
        } catch (IOException e) {
            return e.getMessage();
        }

    }


    private static String  getAuth(String user,String Password) {
         String authString = user + ":" + Password;
          byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
         String authStringEnc = new String(authEncBytes);
         return authStringEnc;
     }
}
