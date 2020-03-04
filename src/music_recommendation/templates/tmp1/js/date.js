// JavaScript Document// JavaScript Document

function getSysTime(){
	var now = new Date();		// 英文系统日期	
	var y = now.getFullYear();	// 年
	var m = now.getMonth()+1;	// 月
	var d = now.getDate();		// 日
	var h = now.getHours();		// 时
	var mm = now.getMinutes();	// 分
	var ss = now.getSeconds();	// 秒
	var e = now.getDay();		// 星期
	var ds = y + "年" + m + "月" + d + "日" + h + 
			"时" + mm + "分" + ss + "秒 星期" + e;
			
	document.getElementById("p1").innerHTML 
			="当前时间：" + ds;
	setTimeout("getSysTime()", 1000);
}
