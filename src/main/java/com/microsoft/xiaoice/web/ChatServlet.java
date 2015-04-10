package com.microsoft.xiaoice.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class ChatServlet extends BaseServlet
{
	private static final Logger logger = Logger.getLogger(ChatServlet.class);



	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChatServlet()
	{
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException
	{
		String pathInfo = request.getPathInfo();
		String result = null;
		try
		{
			if ("/send".equalsIgnoreCase(pathInfo))
			{
				boolean sendResult = doSend(request, response);
				if (sendResult)
				{
					result = "{\"result\":\"success\",\"Message\":null}";
				}
				else
				{
					result = "{\"result\":\"fail\",\"Message\":null}";
				}
			}
			else if ("/get".equalsIgnoreCase(pathInfo))
			{
				result = getMessage(request, response);
			}
			else
			{
				
			}
		}
		catch (Exception e)
		{
			result = "{\"result\":\"error\",\"Message\":\"" + e.getMessage() + "\"}";
		}
		finally
		{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println(result);
			out.flush();
			out.close();
		}

	}

	protected boolean doSend(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException
	{
		String text = request.getParameter("text");

		

		boolean result = true;

		return result;
	}

	protected String getMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException
	{
		String returnMessage = "{\"result\":\"success\",\"Message\":\"Please Wait.\"}";;

		return returnMessage;
	}
}
