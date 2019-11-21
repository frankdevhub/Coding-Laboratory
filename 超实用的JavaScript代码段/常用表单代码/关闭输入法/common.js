window.onload = function(){
	
	//通用浏览器均支持
    //事件文本过滤
	
	var getElement = function(str){
		return document.getElementById(str);
	};
	
	var bannInput = function(str){
		var elem = getElement(str);	 
		console.log(elem);
	
		elem.style.imeModw = 'disabled';
	
		var banInputMethod = elem.getAttribute("banInputMethod");
		console.log(banInputMethod);
		
		if(banInputMethod){
			console.log("invoke define{}");
			var clearChinese = function(elem){
				var _v = elem.value;
				console.log(_v);
				elem.value = _v.replace(/[\u4e00-\u9fa5]/g,"");
			}
			
			elem.onkeyup = function(){
				 clearChinese(elem);
			}
			elem.blur = function(){
				clearChinese(elem);
			}
			
		}
		
	};
	
	bannInput("banInputMethodCommon");
	console.log("invoke banInputMethodCommon{}");
}