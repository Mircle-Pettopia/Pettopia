$(function(){
	var $basicContainer = $("#basicInfo"),
		$basicCS = $basicContainer.find(".basicShopInfo"),
		$basicBank = $basicContainer.find(".basicShopBank"),
		$addCategory1 = $basicContainer.find(".addCategory1"),
		$addCategory2 = $basicContainer.find(".addCategory2");


	var $quickContent = $(".quickContent"),
		$quickBank = $quickContent.find(".quickBank"),
		$quickCs = $quickContent.find(".quickCs"),

		$footer = $("#footer"),
		$footerCs = $footer.find(".footerCs"),
		$footerBank = $footer.find(".footerBank"),

		$bannerCategory = $(".categorySlide .gnbMenuBox .menuCategory").children("li"),

		$mobileAddMenu = $(".mobileAddMenu .mobileAddMenuContainer"),
		$mobileAddMenuAdd1 = $mobileAddMenu.find(".addCategory1"),
		$mobileAddMenuAdd2 = $mobileAddMenu.find(".addCategory2"),
			
		$headerCsBoard = $(".headerCsBoard"),
		$allCategoryDim = $("#allCategoryDim").find(".menuCategory"),
		$serviceLink = $(".serviceLink"),
		$BoardLink = $(".BoardLink"),
		$FavoriteLink = $(".FavoriteLink"),
		$asideCommunity = $("#aside .asideCommunity"),
		$boardAddGroup = $headerCsBoard.add($serviceLink).add($asideCommunity).add($BoardLink);


	var centerOpen = undefineRemove($basicCS.find(".centerOpen").html()),
		centerLunch = undefineRemove($basicCS.find(".centerLunch").html()), 
		centerOff = undefineRemove($basicCS.find(".centerOff").html()),
		centerAdd = $basicCS.find("div").not(".centerOpen,.centerLunch,.centerOff"),
		csArray = [centerOpen,centerLunch,centerOff],
		csLunchCheck = true,

		accountHolder = undefineRemove($basicBank.find(".bankAccountHolder").html()),
		accountNumber = $basicBank.find(".bankAccountNumber"),

		basicFavoriteContent = $basicContainer.find(".basicFavorite").html(),
		basicBoardContent = $basicContainer.find(".basicBoard").html(),

		addCategory1Content = $addCategory1.html(),
		addCategory2Content = $addCategory2.html();
		if($addCategory1.length < 1 && $addCategory2.length < 1){ $('#header .headerGnb .categoryMobile .categoryMore').hide(); }
	
	accountNumber.each(function( index ){
		var $this = $(this),
			html = undefineRemove($this.html());

		$quickBank.add($footerBank).append('<li class="contents">'+html+'</li>');
	});

	$quickBank.add($footerBank).append('<li class="contents2">'+accountHolder+'</li>');


	if( csArray[1] != "" ){
		$footerCs.append('<li class="contents">'+csArray[0]+' / '+ csArray[1] +'</li>');
		$footerCs.append('<li class="contents">'+csArray[2]+'</li>');
		csLunchCheck = false;
	}

	$.each(csArray, function(index, item){
		$quickCs.append('<li class="contents">'+item+'</li>');
		if ( csLunchCheck ) $footerCs.append('<li class="contents">'+item+'</li>');
	});

	centerAdd.each(function( index ){
		var $this = $(this),
			html = undefineRemove($this.html());

		$quickCs.add($footerCs).append('<li class="contents">'+html+'</li>');
	});

	$boardAddGroup.append(basicBoardContent);
	$FavoriteLink.append(basicFavoriteContent);
	$allCategoryDim.append(addCategoryStructure(basicBoardContent));

	$mobileAddMenuAdd1.append(addCategory1Content);
	$mobileAddMenuAdd2.append(addCategory2Content);

	$bannerCategory.each(function( index ){
		var $this = $(this),
			$child = $this.children(".subCategory"),
			checkChild = ( $child.length > 0 ) ? true : false,
			$bannerContainer = $(".categoryBannerArea"),
			banner = $bannerContainer.children().eq(index).html();

		if( banner ){
			if( checkChild ){
				$child.append("<div class='categoryBanner'>"+banner+"</div>");
			}else{
				$this.addClass("hasChild").append("<div class='subCategory depth1'><div class='categoryBanner'>"+banner+"</div></div>");
			}
		}
	});

	joinPointFunction( useJoinPoint, joinPoint );
	if ( goodsThumb == true ){$("body").addClass("productEffect");}

	var mpl_copy = [];
	mpl_copy[0] = 'padding:4px 17px 3px 13px; font-family:tahoma; line-height:15px; font-size:10px; background: #fafafa; color: #555';
	mpl_copy[1] = 'padding:4px 17px 3px 13px; font-family:tahoma; line-height:15px; font-size:10px; background: #9dc6f7; color: #fff';
	console.log('%c  ', '');
	console.log('%c  Designed by MPLSHOP  ', 'font-family:tahoma; font-size:20px; padding:2px 0; background: #d9fde6; color: #555');
	console.log('%c website : http://mplshop.co.kr', mpl_copy[0]);
	console.log('%c contact us :     chima2003@nate.com', mpl_copy[0]);
	console.log('%c COPYRIGHT - MPLSHOP. ALL RIGHTS RESERVED', mpl_copy[1]);
	console.log('%c  ', '');
});

function addCategoryStructure( boardContents ){
	var categoryHtml = '<li><a href="../service/index.php">고객센터</a><div class="subCategory depth1">'+ boardContents +'</div></li>';
	return categoryHtml;
};

function undefineRemove( text ){
	var retunrDom = text ? text : "";
	return retunrDom;
};

function joinPointFunction( useJoinPoint, joinPoint ){
	var $pointContainer = $("#header .headerTop .headerMember .accent");

	if ( useJoinPoint == true ){
		$pointContainer.show().find("strong").html(joinPoint);
	}else{
		$pointContainer.remove();
	}
};
