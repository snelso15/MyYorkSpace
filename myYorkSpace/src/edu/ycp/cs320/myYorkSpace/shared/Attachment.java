package edu.ycp.cs320.myYorkSpace.shared;

import java.io.File;
import java.io.Serializable;

public class Attachment implements Serializable {

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
