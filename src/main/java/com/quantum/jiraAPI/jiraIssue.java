package com.quantum.jiraAPI;

import org.json.JSONObject;

/**
 * Created by uzie on 2/21/17.
 */
public class jiraIssue {

    String id ;
    String key ;
    String status = "unknown";
     public jiraIssue()
    {

    }

    public void parse( String json)
    {


        try {
            JSONObject obj = new JSONObject(json);
              id = obj.getString("id");
              key = obj.getString("key");

            JSONObject fields = obj.getJSONObject("fields");
            JSONObject statusObj = fields.getJSONObject("status");

            status=statusObj.getString("name");
        }catch (Exception e)
        {
            // can not parse the JIRA >> status unknown

        }

    }

    public String getKey() {
        return key;
    }

    public String getStatus() {
        return status;
    }
}
