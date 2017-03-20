package com.quantum.jiraAPI;

 import org.testng.*;

/**
 * Created by uzie on 2/21/17.
 */
public class jiraListener implements IInvokedMethodListener {



     public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        String[]  groups = method.getTestMethod().getGroups();

        for (String group:groups)
        {

            if (group.toLowerCase().contains("jira"))
            {
                String jid[] = group.split(":");
                String JiraID = jid[1];
                String status = jiraUtils.getIssueStatus(JiraID);
                 if (status.equals("In Progress") || status.equals("To Do") )
                {
                    throw new SkipException("open issue in JIRA related to this test: "+JiraID);
                }

            }
        }

    }

     public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

    }
}
