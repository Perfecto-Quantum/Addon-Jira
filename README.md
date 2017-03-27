# Addon-Jira
This add-on supports the capbility to skip test if there is an open bug related to it.

### How does it work?
In order to connect between the test and Jira bug the user should add tag to the test.<br />
The tag name is __@JIRA:{BUG_ID}__.<br />
If the Jira tag added befroe the execution the frawork will execute it olny if the Jia bug been closed.

## How to use it ?
### Install
Add the following dependency to your .pom file <br/>
        \<dependency>        
             \<groupId>com.quantum.addons\</groupId>            
              \<artifactId>jira\</artifactId>            
             \<version>1.0-SNAPSHOT\</version>            
        \</dependency>
        
        
### Config

Add your Jira account data to the __application.properties__<br />
  jiraWeb = https://MYJIRA.atlassian.net/<br />
  jirauser= myuser<br />
  jirapassword = password<br />
  
Add this listner to the testNG.xml file/<br />
__\<listener class-name="com.quantum.jiraAPI.jiraListener"/>__<br />

### Example
  @Test(description="CI", groups={"@ci","@JIRA:TEST-2"})<br />
    public void testJira() {<br />
        getDriver().get("http://nxc.co.il/stab.php");<br />
        getDriver().findElement("restet").waitForPresent(30000);<br />
        .<br />
        The test code <br />
        .<br />
        .<br />
  
  
  

        
        

