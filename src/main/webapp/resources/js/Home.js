/**
 * 
 */

var jsonArray='';

$("#imgSrc").click(function(){
	
	
	var src=$("#imgSrc").attr('src');
	
	 $("#popup").dialog(
			 {
			    	width:600,
			    	height:600
			    }		 
	 );
		$("#popupImage").attr('src',src);

	
	 
});

function loadDetails1(selectCategory)
{
	$.ajax({
		url:'getHomedata?selectCategory='+selectCategory,
		async:false,
		success:function(json)
		{
			$("#shortDiv").empty();
			 jsonArray=json.data;
			 if(json.data=='')
			 {
				 $("#shortDiv").append('No Data');
				 $("#imgSrc").attr('src','');
				 $("#description").empty();
				 $("#titleDetails").empty();
			 }
			$.each(jsonArray,function(i,item){
				if(i==0) {
				$("#imgSrc").attr('src',item.fileName);
				$("#description").empty();
				$("#description").append(item.description);
				$("#titleDetails").empty();
				$("#titleDetails").append(item.title);
				
				}
				
				
				
				$("#shortDiv").append('<a href="#" class="list-group-item listL"'+'lang='+item.id+
						' data-toggle="tooltip" data-html="true" data-placement="right"'
						+'style="text-decoration: none; cursor: default;">'
                        +'<img class="img-square" src='+item.fileName+' width="35" height="40">' 
						+'<strong> '+item.title+' </strong>'
                        +'<p class="list-group-item-text" style="margin-left:30px;">'+item.shortDescription+'</p></a>');
			});
				
		}
		});
}

loadDetails1(1);

$("#menu-top li").unbind("click").click(function(){
	
	$("#heading").empty();
	$("#heading").append(this.innerText);
	$("#menu-top li").removeClass("menu-top-active");
	$(this).addClass("menu-top-active");
	loadDetails1(this.id);

});

$("#shortDiv").on("click",'a',function(){
	
	var id=this.lang;
	
	
	 $.each(jsonArray,function(i,item){
		
		if(item.id==id)
			{
			$("#imgSrc").attr('src',item.fileName);
			$("#description").empty();
			$("#description").append(item.description);
			$("#titleDetails").empty();
			$("#titleDetails").append(item.title);
			return ;
			}
		
	});
	 
	
	 
});
