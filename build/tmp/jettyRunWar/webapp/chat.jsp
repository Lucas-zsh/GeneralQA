<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>与小冰聊天</title>
		<link rel="stylesheet" type="text/css" href="/GeneralQA/css/xiaoice.css" />
		<script type="text/javascript" src="/GeneralQA/js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="/GeneralQA/js/xiaoice.js"></script>
	</head>
	<body>
	    <h3><a href="javascript:history.back(-1)">返回主菜单</a></h3>
	    <hr/>
	    <div class="content">
	        <div class="chatBox">
	          <div class="chatLeft">
	                <div class="chat01">
	                    <div class="chat01_title">
	                       	自动问答机器人
	                    </div>
	                    <div class="chat01_content">
	                        <div class="message_box mes" style="display: block;"></div>
	                    </div>
	                </div>
	                <div class="chat02">
	                    <div class="chat02_title">
	                    	
	                    </div>
	                    <div class="chat02_content">
	                    	<table>
          			            <tr>
          			            	<td>
          			            		<img src='img/talk_icon.png'/>
          			            	</td>
          			            	<td>
          			            		<textarea id="textarea"></textarea>
          			            	</td>
          			            </tr>
	                    	</table>
	                        
	                    </div>
	                    <div class="chat02_bar">
	                        <ul>
	                            <li style="right: 5px; top: 5px;">
	                            	<a href="javascript:;">
	                            		<img id="sendMsgBtn" src="/GeneralQA/img/send_btn.jpg">
	                            	</a>
	                            </li>
	                        </ul>
	                    </div>
	                </div>
	            </div>
	          <div class="chatRight">  
	          <br>
	          	<div>小图</div>
	          	<div class="chatPic">
	          		<img src="/GeneralQA/img/iceH.jpg" class="img_head">
	          		<p><span>有什么问题都可以问哦</span></p>
	          	</div>       
                <div>
                </div>
	          </div>
	          <div style="clear: both;"></div>
	        </div>
	    </div>
	</body>
</html>