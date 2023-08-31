package co.dc.example.notice.service;

import java.sql.Date;

import lombok.Data;

@Data
public class ReplyVO {
	
	private int replyId;
	private int noticeId;
	private String reply;
	private String replyer;
	private Date replyDate;

}


