/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamPortal;

/**
 *
 * @author MOHAMED SHABEER KP
 */
public class ExamSubject {

    int exam_state;
    String exam_link;
    String exit_password;
    String sub_name;
    int stud_count;
    String login_password;
    int exam_mode;

    public void setExamMode(int exam_mode) {
        this.exam_mode = exam_mode;
    }

    public int getExamMode() {
        return exam_mode;
    }

    public void setSubName(String sub_name) {
        this.sub_name = sub_name;
    }

    public String getSubName() {
        return sub_name;
    }

    public void setAppState(int exam_state) {
        this.exam_state = exam_state;
    }

    public int getAppState() {
        return exam_state;
    }

    public void setExamLink(String exam_link) {
        this.exam_link = exam_link;
    }

    public String getExamLink() {
        return exam_link;
    }

    public void setExitPassword(String exit_password) {
        this.exit_password = exit_password;
    }

    public String getExitPassword() {
        return exit_password;
    }

    public void setLoginPassword(String login_password) {
        this.login_password = login_password;
    }

    public String getLoginPassword() {
        return login_password;
    }

    void setStudCount(int stud_count) {
        this.stud_count = stud_count;
    }

    int getStudCount() {
        return stud_count;
    }

}
