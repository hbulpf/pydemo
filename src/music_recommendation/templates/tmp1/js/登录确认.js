// JavaScript Document
 			
function isEmpty(s){ 
	var whitespace = " \t\n\r";  
 	var i;
   	if((s == null) || (s.length == 0)) {
      		return true;
	}

   	for (i = 0; i < s.length; i++) {   
      		var c = s.charAt(i);
      		if (whitespace.indexOf(c) == -1) 
        		return false;
    		}
    		return true;
	}

	function validate(){    
  		if (isEmpty(document.frmlogin.userName.value)){
        		alert("请输入用户名！"); 
        		document.frmlogin.userName.focus();
        		return false;
    		}
  		if (isEmpty(document.frmlogin.pwd.value)){ 
        		alert("请输入密码！");  
        		document.frmlogin.pwd.focus(); 
        		return false;
    		}
				
		alert("登录成功!");

		location.href="login.html";
		
  		return true;
	}