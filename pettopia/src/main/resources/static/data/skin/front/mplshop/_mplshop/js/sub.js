$(document).ready(function(){	
	if(getHost('n') == 'samplemplshop16.godomall.com'){
		$(".NaverBtn_area").show();
	}
	/*
	if($("#subTopImgSlider .js-smart-img").length > 0 && subTopBannerUse == true){
		var subTopBannerImg = "";
		$("#subTopImgSlider").find("img.js-smart-img").each(function(){
			if($(this).parent('a').length > 0){
				subTopBannerImg += "<div>"+$(this).parent('a').wrap('<div/>').parent().html()+"</div>";
			}else{
				subTopBannerImg += "<div>"+$(this).wrap('<div/>').parent().html()+"</div>";
			}
		});
		$("#subTopImgSlider").find('p,div,span,br').remove();
		$("#subTopImgSlider").append(subTopBannerImg);

		$("#subTopImgSlider").slick({
			speed: 400,
			autoplaySpeed:6000,
			autoplay: true,
			dots: true
		});
	}
	*/
	if($(".MemoContent").length > 0){
		$(".MemoContent").find('a').each(function(){
			$(this).attr("target","_blank");
		});
	}

	/*
	$ ( '.list_item_category ul li'). on ({
        'mouseover': function () {
            $ (this) .find ( '> ul'). stop (true, true) .fadeIn ( 'fast');
        },
        'mouseleave': function () {
            $ (this) .find ( '> ul'). stop (true, true) .fadeOut ( 'fast');
        }
    });
	
	$(".list_item_category ul.depth1,.list_item_category ul.depth2").each(function(){
		 if($ (this).length > 0){
			if($ (this).find('li').length > 0){
				$ (this).addClass('bd');
				$ (this).closest('li').addClass('la');
			}
		 }
	});	
	*/

	var main_t = $(".best_item_view .goods_list_cont .item_gallery_type ul > li").length;
	for(var i=0;i<main_t;i++){
			
		$(".best_item_view .goods_list_cont .item_gallery_type ul > li .mpl_best").show();
		$(".best_item_view .goods_list_cont .item_gallery_type ul > li:eq(" + i + ") .mpl_best").html("BEST "+(i+1));
	}

	$("#detail .item_goods_tab, #delivery .item_goods_tab, #exchange .item_goods_tab, #reviews .item_goods_tab, #qna .item_goods_tab").find('a').click(function(e){
		e.preventDefault();
		var naviLink = $(this).attr("href");
		var naviLinktop = $(naviLink).offset().top;
		$("body, html").stop().animate({scrollTop:naviLinktop-10}, 500);
	});	
	
});

function getHost(stype) {
	var cmaDns; 
	cmaDns=location.href; 
	cmaDns=cmaDns.split("//"); 
	if(stype == "n") {
		cmaDns = cmaDns[1].substr(0,cmaDns[1].indexOf("/")); 
	} else {
		cmaDns = "http://"+cmaDns[1].substr(0,cmaDns[1].indexOf("/"));
	}
	return cmaDns; 
} 
$(window).load(function() {
	$(".list_item_category").css("visibility","visible");
});