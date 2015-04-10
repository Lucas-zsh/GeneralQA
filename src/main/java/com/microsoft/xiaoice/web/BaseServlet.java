package com.microsoft.xiaoice.web;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class BaseServlet extends HttpServlet
{
	private static final Logger logger = Logger.getLogger(BaseServlet.class);
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}
	
	protected static final byte[] readBytes(InputStream is, int contentLen)
	{
		if (contentLen > 0)
		{
			int readLen = 0;

			int readLengthThisTime = 0;

			byte[] message = new byte[contentLen];

			try
			{
				while (readLen != contentLen)
				{
					readLengthThisTime = is.read(message, readLen, contentLen - readLen);

					if (readLengthThisTime == -1)
					{
						break;
					}

					readLen += readLengthThisTime;
				}

				return message;
			}
			catch (IOException e)
			{
				logger.error("Error occured when parsing the content.", e);
			}
		}

		return new byte[] {};
	}
	
	protected String toString(List<?> objects)
	{
		StringBuilder result = new StringBuilder();
		
		if (objects != null)
		{
			boolean isFirst = true;
			for (Object obj : objects)
			{
				if (isFirst)
				{
					isFirst = false;
				}
				else
				{
					result.append(",");
				}
				
				result.append(obj.toString());
			}
		}
		
		return result.toString();
	}

}
