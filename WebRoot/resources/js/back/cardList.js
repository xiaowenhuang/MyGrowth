/**
 * 调用后台删除
 */
function deleteCard(basePath,card_no,card_owner){
	$.ajax({
		url:basePath+"delete/delCard",
		data:{card_owner:card_owner,card_no:card_no},
		async:false, //false为同步 true为默认异步
		type:"get",
		dataType:"json",
		success:function(data){
			showIndex(basePath);
		},error:function(data) {
			alert(JSON.stringify(data));
            }
		
	});
}

function showIndex(basePath){
	$("#mainForm").attr("action",basePath+"card/doPost");
	$("#mainForm").submit();
}

function toEdit(basePath,card_no,card_owner){
	var card_owners = card_owner;
	var card_nos = card_no;
	window.open(basePath+"modify/edit?cardNo="+card_nos+"&cardOwner="+card_owners, 'edit',  'top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no');
	
}
/**跳转到新增页面**/
function addCard(basePath){
	$("#mainForm").attr("action",basePath+"add/newCard");
	$("#mainForm").submit();
}

/**全选与反全选**/
function selectAll(){
	//选中时全选否则全取消
	if($("#all").attr("checked")=="checked"){
		var id = document.getElementsByName("id")
		for(var i=0 ;i<id.length;i++){
			id[i].checked = true;
		}
	}else{
		var id = document.getElementsByName("id")
		for(var i=0 ;i<id.length;i++){
			id[i].checked = false;
		}
	}
}

/**分页处理**/
function paginationQuery(flag,basePath){
	var currentPage = parseInt($("#currentPage").val()); //当前页
    if(flag=="First") {
        $("#currentPage").val(1);//首页
    }else if(flag=="Previous") {
        $("#currentPage").val(currentPage-1);//上一页
        if(currentPage-1<=0){
        	 $("#currentPage").val(1);//首页
        	 return;
        }
    }else if(flag=="Next") {
        $("#currentPage").val(currentPage+1);//下一页
        return;
        if(currentPage+1>=$("#totalPageCount").val()){
        	alert(1);
        	 $("#currentPage").val($("#totalPageCount").val());//尾页
        	 return;
        }
    }else if(flag=="Last") {
        $("#currentPage").val($("#totalPageCount").val());//尾页
    }
    findUserInfoAll(parseInt($("#currentPage").val()),basePath);
}

/**分页显示**/
function findUserInfoAll(currentPage,basePath){
	$.ajax({
		cache: false,
		type: "GET",
		url: basePath+"card/doPost",
		data:"currentPage="+currentPage,
		dateType:"json",
		async: false,
		error: function(request){alert("失败");},
		success: function(data){
			alert("success");
			}
	});
}