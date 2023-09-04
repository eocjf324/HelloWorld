package co.dc.example.ajax.service;

import lombok.Data;

@Data
public class TodoVO {
	int listNum;
	String title;
	String dueDate;
	String complete;
}
