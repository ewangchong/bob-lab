package com.codergray.util;

import java.sql.Timestamp;

public class SQLGenerator {

	public static void main(String[] args) {
		String voicemail_id = "7f000001-30-13c2852e19d-390e499b-";
		String subscriber_id = "7f000001-04-13c1e8de5d7-9a635eec-0f4";
		String folder_name="7f000001-07-13f1d72894c-5d9468cb-83b/2013/6/7/16";
		String mailbox_id="7f000001-07-13c1e8de679-9a7c170f-0f4";
		String mailbox_name="Inbox";
		String ani="bob";
		String link= "7f000001-30-13c2852e19d-390e458b-778.wav";
		String domain_name="Voicemail";
		String page_name="New Voicemail Page";
		String is_new="1";
		String sql = "insert into voicemails (voicemail_id, subscriber_id, folder_name, mailbox_id, mailbox_name, ani, link, domain_name, page_name, is_new, created) values (";
		StringBuffer sb = new StringBuffer();
		for(int i = 201; i<500; i++){
			sb.append(sql+"'"+voicemail_id+i+"','"+subscriber_id+"','"+folder_name+"','"+mailbox_id+"','"+mailbox_name+"','"+ani+"','"+link+"','"+domain_name+"','"+page_name+"','"+is_new+"',"+"sysdate);\n");
		}
		System.out.println(sb.toString());
	}
}
