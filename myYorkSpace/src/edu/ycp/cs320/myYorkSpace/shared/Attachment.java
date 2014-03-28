package edu.ycp.cs320.myYorkSpace.shared;

import java.io.File;

public class Attachment {

	private File attach;
	
	public Attachment(File attach)
	{
		this.attach = attach;
	}
	
	public void setAttachFile(File attach)
	{
		this.attach = attach;
	}
	
	public File getAttachFile()
	{
		return attach;
	}
}
