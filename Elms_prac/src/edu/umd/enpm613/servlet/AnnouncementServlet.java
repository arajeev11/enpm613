package edu.umd.enpm613.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.umd.enpm613.dto.MessagesDTO;
import edu.umd.enpm613.impl.MessagesImpl;

/** Servlet class for announcements.
 * 
 * @author arajeev
 *
 */
public class AnnouncementServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public int			id;
	public String		title;
	public String		message;
	public Date			dateCreated;
	public Date			dateLastModified;
	public Date			datePosted;
	public boolean		create;
	public boolean		update;
	public boolean		delete;
	public MessagesDTO	announcement;

	public AnnouncementServlet()
	{
		//empty constructor
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException 
	{
		MessagesImpl msgImpl = new MessagesImpl();
		SimpleDateFormat simpDateFormat = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		int result = 0;

		try
		{
			//Create/Edit/Delete or display an error
			if (Boolean.parseBoolean(request.getParameter("create")) && 
					!Boolean.parseBoolean(request.getParameter("update")) &&
					!Boolean.parseBoolean(request.getParameter("delete")))
			{
				result = msgImpl.createAnnouncement(request.getParameter("title"), 
						request.getParameter("message"), 
						simpDateFormat.parse(request.getParameter("dateCreated")),
						simpDateFormat.parse(request.getParameter("datePosted")));
			} else if (Boolean.parseBoolean(request.getParameter("update")) && 
					!Boolean.parseBoolean(request.getParameter("create")) &&
					!Boolean.parseBoolean(request.getParameter("delete")))
			{
				result = msgImpl.editAnnouncement(Integer.parseInt(request.getParameter("id")),
						request.getParameter("title"), 
						request.getParameter("message"), 
						simpDateFormat.parse(request.getParameter("dateCreated")),
						simpDateFormat.parse(request.getParameter("Posted")));
			} else if (Boolean.parseBoolean(request.getParameter("delete")) && 
					!Boolean.parseBoolean(request.getParameter("update")) &&
					!Boolean.parseBoolean(request.getParameter("create")))
			{
				result = msgImpl.deleteAnnouncement(Integer.parseInt(request.getParameter("id")));
			} else {
				//TODO: Find out why we do this
				request.setAttribute("error", "Invalid query specified for announcements");
			}
			determineResponse(response, result);
		} catch (ParseException pe)
		{
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, 
					"The specified action could not be completed.");
		}
	}
	
	/** Utility method to determine whether to send back a success response or an error
	 * 
	 * @param response - {@link HttpServletResponse}
	 * @param result - the result returned from the database query
	 * @throws IOException 
	 */
	private static void determineResponse(HttpServletResponse response, int result) throws IOException
	{
		if (result == 1)
		{
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, 
					"The specified action could not be completed.");
		}
	}
}
