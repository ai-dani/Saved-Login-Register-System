package AnimeList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//UNIVERSAL LOG REGISTER CLASS
public class LogRegister implements Serializable 
{
	//initialize variables
	private static final long serialVersionUID = 5147814673718695707L;
	private String username;
	private String password;
	private String name;
	private String dataFile;
	private int indexFile;
	
	//Store username, password, and file in an array list data structure
	//such that 0,0,0 respectively is one user
	List<String> nameList = new ArrayList();
	List<String> usernameList = new ArrayList();
	List<String> passwordList = new ArrayList();
	List<String> fileList = new ArrayList();
	
	//constructor to access both login and register
	public LogRegister()
	{
		username = "";
		password = "";
		dataFile = "";
	}
	
	//PREFERRED NAME TO BE CALLED
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		int i = usernameList.indexOf(username);
		return nameList.get(i);														//BAD CODE
	}
	
	public boolean findLogin(String user, String pass)
	{
		//int fileIndex = 0;
		boolean found = false;
		
		for(int i = 0; i < usernameList.size(); i++)
		{
			if(usernameList.get(i).equals(user) && passwordList.get(i).equals(pass))
			{
				username = user;
				password = pass;
				setFileIndex(i+1); //fix problem for some reason?
				found = true;
				break;
			}
			else
				found = false;
		}
		return found;
	}
	
//SPECIFIC FOR FILE DATA METHOD - will use to access data files
	public void setFileIndex(int i) //mutator method
	{
		indexFile = i;
	}
	
	public int getFileIndex()
	{
		return indexFile;
	}
	
//REGISTER__________________________________________________________________
	public void register(String name, String user, String pass)
	{
		username = user;
		password = pass;
		this.name = name;
		usernameList.add(user);
		passwordList.add(pass);
		nameList.add(name);
		
		//create a file
		dataFile = user + "_" + pass + ".dat";
		fileList.add(dataFile);
	}
	
//ACCESSING USERNAME/PASSWORD/FILE METHODS_______________________________________
	public String getCurrentUsername()
	{
		return username;
	}
	
	public String getCurrentPassword()
	{
		String hidden = password.substring(0,1) + "***";
		return hidden;
	}
	
	public String getCurrentFile()
	{
		int i = usernameList.indexOf(username);										//BAD CODE
		return fileList.get(i);
	}

	
//PRIVATE MASTER CONTROL FOR KEEPING DATA

	public void getAllData()
	{
		System.out.println("\n---------NAMES---------");
		for(int i = 0; i < nameList.size(); i++)
		{
			System.out.print(nameList.get(i));
			System.out.print(" | ");
		}
		System.out.println("\n---------USERNAMES---------");
		for(int i = 0; i < usernameList.size(); i++)
		{
			System.out.print(usernameList.get(i));
			System.out.print(" | ");
		}
		
		System.out.println("\n---------PASSWORDS---------");
		for(int i = 0; i < passwordList.size(); i++)
		{
			System.out.print(passwordList.get(i));
			System.out.print(" | ");
		}
		
		System.out.println("\n---------FILES---------");
		for(int i = 0; i < fileList.size(); i++)
		{
			System.out.print(fileList.get(i));
			System.out.print(" | ");
		}
	}
	public void deleteData() //BE CAUTIOUS
	{
		nameList.clear();
		usernameList.clear();
		passwordList.clear();
		fileList.clear();
	}
	
	
	
}
