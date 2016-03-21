package edu.usc.tcors.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import twitter4j.DirectMessage;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class TcorsTwitterSurvey {

	private HashMap<String,String> users = new HashMap<String,String>();
	
	public static void main(String[] args) {
		TcorsTwitterSurvey tts = new TcorsTwitterSurvey();
		TcorsTwitterUtils u = new TcorsTwitterUtils();
		TcorsMinerUtils tmu = new TcorsMinerUtils();
		// Connection conn = null;
		Twitter t = u.getInstance();
		
		String survey_msg = "";
		tts.sendMsg(t,"hello","gvegayon");
		
//		try {
//			conn = tmu.getDBConn("configuration.properties");
//		} catch (SQLException s) {
//			s.printStackTrace();
//		}
	}
	
	// retrieve survey message
	private void getSurveyMessage() {
		
	}
	
	// retreve names from file
	private void getNames(String file) {
		
	}
	
	// process multiple names via DM
	private void sendMsgs() {
		
	}
	
	// process single name via DM
	private void sendMsg(Twitter t, String msg, String user) {
		try {
			DirectMessage dm = t.sendDirectMessage(user, msg);
			// System.out.println("Sent to:" + dm.getRecipientScreenName());
			markUser(user, "success");
		} catch (TwitterException e) {
			e.printStackTrace();
			if(e.getErrorCode() == 150) {
				markUser(user, "block");
			} else {
				System.out.println("Failed message:" + e.getMessage());
			}
		}
		
	}
	
	// process multiple names via mention
	private void sendMentions() {
		
	}
	
	// process single name via mention
	private void sendMention(Twitter t, String msg) {
		try {
			t.updateStatus(msg);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}

	private void markUser(String user, String mark) {
		
	}
	
	public HashMap<String, String> getUsers() {
		return users;
	}

	// populate users to work with based on attributes from DB
	public void setUsers(HashMap<String, String> users) {
		this.users = users;
	}
}