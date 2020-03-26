function addselect(typecode,positionid,name){
		//建立一个selected 对象	<select name="totalCount" id="currentPage">
			//往selected里面添加第一个首选项
			$.post(
			"${pageContext.request.contextPath}/Basedict",
			{"dict_type_code":typecode},
			function(data){
				var count="<select name='"+name+"'><option>----请选择------</option>"
				for(var i=0;i<data.length;i++){
					count+="<option value='"+data[i].dict_id+"'}>"+data[i].dict_item_name+"</option>"
				}
				count+="</select>"
				//插入到指定的位子
				$("#"+positionid).html(count);
			},"json"
			)
	}