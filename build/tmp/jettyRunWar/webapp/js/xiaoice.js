$(document).ready(
function () {
	
	var autoReceiveMsg = true;
	var pic_me = "img/meH50.jpg";
	var pic_ice = "img/iceH50.jpg";
	var ice_name = "Robot:";
	var myname = "我";
	$('input:text:first').focus();

	//chat
    function sendMessage() {
        var time = getTime();
        var ask = $("#textarea").val();
        var url = "./chat/send";
        var para = '{"text":"'+ask+'"}';
        
        $.post(url,eval("(" + para + ")"),function(data){
        	var jsonSend = eval('(' + data + ')');
        	var i = null;
        	if(jsonSend.result == "success")
    		{
    			 i = "<div class='time'>"+time+"</div><div class='message clearfix'><div class='user-logo'><img src='" + pic_me + "'/>"  + "</div>" 
    			 	 + "<div class='wrap-text'>" 
					 + "<h5 class='clearfix'>"+ myname +":</h5>" 
					 + "<div>" + ask + "</div>" 
					 + "</div>" 
					 + "<div style='clear:both;'></div>" 
					 + "</div>" ;
				null != data && "" != data ? appendMsg(i,true) : alert("\u8bf7\u8f93\u5165\u804a\u5929\u5185\u5bb9!");      		
    		}
        	else
    		{
   
    			 i = "<div class='time'>"+time+"</div><div class='message clearfix'>" + "<div class='user-logo'>" + "<img src='" + pic_ice + "'/>" + "</div>" 
    			 + "<div class='wrap-text'>" + "<h5 class='clearfix'>" + ice_name + ":</h5>" 
    			 + "<div>" + data + "</div>" 
    			 + "</div>" 
    			 + "<div style='clear:both;'></div>";
    			null != data && "" != data ? appendMsg(i,true) : alert("\u8bf7\u8f93\u5165\u804a\u5929\u5185\u5bb9!");       		
    		}
        });
        
        setTimeout(
            function() 
            {
                getMessage();
            }, 2000);
    }
    
    //get
    function getMessage() {
        
        var time = getTime();    
        var url = "./chat/get";
        var para = '{"account":"hello"}';

        $.post(url,eval("(" + para + ")"),function(data){
        	var jsonGet = eval('(' + data + ')');
        	var messages = jsonGet.Message;
			data = messages;
			var i = "<div class='time'>"+time+"</div><div class='message clearfix'>" 
				
				+ "<div class='wrap-text2'>" 
				+ "		<h5 class='clearfix'>" + ice_name + "</h5>" 
				+ "		<div>" + data + "</div>" 
				+ "</div>" 
                + "     <div class='user-logo2'>" 
                + "         <img src='" + pic_ice + "'/>" 
                + "     </div>" 
				+ "<div style='clear:both;'></div></div>";
			null != data && "" != data ? appendMsg(i,false) : alert("\u8bf7\u8f93\u5165\u804a\u5929\u5185\u5bb9!");       		       				                   				 		
					
        });                
    }
    
    function appendMsg(msg , IsClear)
    {
    	$(".mes" ).append(msg);
    	
    	$(".chat01_content").scrollTop($(".mes" ).height());
    	
    	if(IsClear)
    		{
        		$("#textarea").val("");
    		}
    }
  
    
    function getTime()
    {
    	var e = new Date;
        var time = e.getFullYear() + "-" + (e.getMonth() + 1) + "-" + e.getDate() + " " + e.getHours() + ":" + e.getMinutes() + ":" + e.getSeconds();
        return time;
    }

    
    //**********************************For chat.jsp**********************************
    $("#sendMsgBtn").click(function () {
    	sendMessage();
    });
});
