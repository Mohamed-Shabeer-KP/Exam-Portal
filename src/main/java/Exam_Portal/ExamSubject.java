/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exam_Portal;

/**
 *
 * @author MOHAMED SHABEER KP
 */
public class ExamSubject {
    int app_state;
    String exam_link;
    String exit_password;
    String sub_name;
    int sub_count;
    String login_password;
    
    public void setSubName(String sub_name)
    {
        this.sub_name = sub_name;
    }
    
    public String getSubName()
    {
        return sub_name;
    }
    
    public void setAppState(int app_state)
    {
        this.app_state = app_state;
    }
    
    public int getAppState()
    {
        return app_state;
    }
        
    public void setExamLink(String exam_link)
    {
        this.exam_link = exam_link;
    }
            
    public String getExamLink()
    {
        return exam_link;
    }
                
    public void setExitPassword(String exit_password)
    {
        this.exit_password = exit_password;
    }
    
    public String getExitPassword()
    {
        return exit_password;
    }
    
    public void setLoginPassword(String login_password)
    {
        this.login_password = login_password;
    }
    
    public String getLoginPassword()
    {
        return login_password;
    }
    
    public void setSubCount(int sub_count)
    {
        this.sub_count = sub_count;
    }
    
    public int getSubCount()
    {
        return sub_count;
    }

}
