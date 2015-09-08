/**
 * 调用后台删除
 */
function deleteCard(basePath,card_no,card_owner){
	alert(1);
	$.ajax({
		url:basePath+"delete/delCard",
		data:{card_owner:card_owner,card_no:card_no},
		async:false, //false为同步 true为默认异步
		type:"get",
		dataType:"json",
		success:function(data){
			//temp.delRowData(pkid);
			showIndex(basePath);
			alert(JSON.stringify(data));
			//alert("success");
		},error:function(data) {
			alert(JSON.stringify(data));
            }
		
	});
	//$("#mainForm").attr("action",basePath+"delete/delCard");
	//$("#mainForm").submit();			
}

function showIndex(basePath){
	$("mainForm").attr("action",basePath+"card/doPost");
	$("#mainForm").submit();
}

function toEdit(basePath,card_no,card_owner){
	var card_owners = card_owner;
	var card_nos = card_no;
	//alert(card_owners+","+card_nos);
	//return;
	window.open(basePath+"modify/edit?cardNo="+card_nos+"&cardOwner="+card_owners, 'edit',  'top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no');
	
}
/**跳转到新增页面**/
function addCard(basePath){
	window.open(basePath+"add/newCard", "newCard",'top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no');
}

/**保存新增的数据**//*
function saveCard(basePath){
	
}*/