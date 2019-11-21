window.onload = function(){
	var _inhibitingInput = document.getElementById("inhibitingInput");
	console.log('value',_inhibitingInput.value);
	
	//第一种写法
	_inhibitingInput.onfocus = function(){
		_inhibitingInput.blur(); //控制失去焦点
	}
	
	//第二种写法(不推荐，可视化效果差)
	/*var noText = function(){
		_inhibitingInput.value = "";
	};
	
	_inhibitingInput.onkeyup = */
	
}