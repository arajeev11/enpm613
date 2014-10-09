package edu.umd.enpm613.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import edu.umd.enpm613.dto.MessagesDTO;

/**Class used to create/edit/delete announcements
 * 
 * @author arajeev
 *
 */
public class MessagesImpl
{
	MessagesDTO announcement = null;
	public int		id;
	public String	title;
	public String	message;
	public Date		dateCreated;
	public Date		dateLastModified;
	public Date		datePosted;
	Connection connection = null;
	Statement st = null;
	ResultSet rs = null;

	/** Method to create announcements
	 * 
	 * @param title - of the announcement
	 * @param message - contents of the announcement
	 * @param dateCreated - the date the announcement was created
	 * @param dateLastModified - the date the announcement was last modified (same as date created here)
	 * @param datePosted - the date the announcement should be posted
	 * @return result - 1 if inserted correctly; 0 otherwise
	 */
	public int createAnnouncement(String title, String message, 
			Date dateCreated, Date datePosted)
	{
		DatabaseHelper db = new DatabaseHelper();
		connection = db.makeConnection();
		int result = 0;
		
		try
		{
			st = connection.createStatement();
			result = st.executeUpdate("INSERT into announcements (title, message, "
					+ "dateCreated, dateLastModified,datePosted)" 
					+ "VALUES ("+ title + ", " + message + ", " 
					+ dateCreated + ", " + dateCreated + ", " + datePosted + ")");
		} catch(SQLException se)
		{
			se.printStackTrace();
		} finally
		{
			executeFinallyBlock(connection, st);
		}
		
		return result;
	}
	
	/** Method to edit an announcement
	 * 
	 * @param id - the primary key of the announcement in the db
	 * @param title - of the announcement
	 * @param message - contents of the announcement
	 * @param dateCreated - the date the announcement was created
	 * @param dateLastModified - the date the announcement was last modified
	 * @param datePosted - the date the announcement should be posted
	 * @return result - 1 if correctly updated; 0 otherwise
	 */
	public int editAnnouncement(int id, String title, String message, 
			Date dateLastModified, Date datePosted)
	{
		DatabaseHelper db = new DatabaseHelper();
		connection = db.makeConnection();
		int result = 0;
		
		try
		{
			st = connection.createStatement();
			result = st.executeUpdate("UPDATE announcements SET title = " + title +
					", message = " + message + ", dateLastModified = " 
					+ dateLastModified + ", datePosted = " + datePosted 
					+ "WHERE id = " + id);
		} catch(SQLException se)
		{
			se.printStackTrace();
		} finally
		{
			executeFinallyBlock(connection, st);
		}
		
		return result;
	}
	
	/** Method to delete announcements.
	 * 
	 * @param id
	 * @return result - 1 if correctly deleted; 0 otherwise
	 */
	public int deleteAnnouncement(int id)
	{
		DatabaseHelper db = new DatabaseHelper();
		connection = db.makeConnection();
		int result = 0;
		
		try
		{
			st = connection.createStatement();
			result = st.executeUpdate("DELETE FROM announcements WHERE id = " + id);
		} catch(SQLException se)
		{
			se.printStackTrace();
		} finally
		{
			executeFinallyBlock(connection, st);
		}
		
		return result;
	}
	
	/** Utility method to close the JDBC connection.
	 * 
	 * @param connection
	 * @param st
	 */
	private static void executeFinallyBlock(Connection connection, Statement st)
	{
		try
		{
			if (st != null)
			{
				connection.close();
			} else {
				//do nothing
			}
		} catch (SQLException se)
		{
			se.printStackTrace();
		}
	}
}
