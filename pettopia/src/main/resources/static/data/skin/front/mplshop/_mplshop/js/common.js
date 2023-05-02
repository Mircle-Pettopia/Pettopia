$(function() {
	if( $( window ).width() > 1024){$('.headerMember > ul > li > a ').hoverdir({ lightEvent:true });}
	categoryCurrent();
	$(window).load(function(){
		$(".headerGnb .categorySlide .gnbMenuBox").categorySlide();
	});

	$('#scrollRight').contentsSlide();
	$('.mypageSide').contentsSlide({direction: "left"});

	allCategoryFunction();

	$("#scrollRight .quickRight").niceScroll({cursorwidth:"0",cursorcolor:"#000",cursorborder:"",boxzoom:false});
	$("#aside .inner").niceScroll({cursorwidth:"0",cursorcolor:"#000",cursorborder:"",boxzoom:false});

	$(document).ready(function(){	
		PerCentFixPrice();
	});

	quickFunction();

	$(".headerCsBoard").mouseover(function(){
		$(this).parent(".headerCs").find('.lineBg').css("left","0");
	}).mouseout(function(){
		$(this).parent(".headerCs").find('.lineBg').css("left","-100%");
	});

	asideAction();

	$(".categoryMobile .categoryMore").click(function() {
		$(this).toggleClass("close");
		$(".mobileAddMenu").fadeToggle(200).toggleClass("nowShow");
	});

	$(".headerSearchButton").click(function() {
		$(".headerSearchMobile").slideToggle(200);
	});
	
	$(window).resize(function(){
		$(".search_cont").hide();

		if( $( window ).width() > 1024){
			$(".headerSearchMobile").hide();
		}
	});

	var didScroll,
		lastScrollTop = 0,
		delta = 100,
		navbarHeight = $('#header_warp').outerHeight() - $('.topFixd').outerHeight() + 50;

	$(window).scroll(function(event){
		didScroll = true;
	});

	setInterval(function() {
		if (didScroll) {
			hasScrolled();
			didScroll = false;
		}
	}, 0);

	function hasScrolled() {
		var st = $(this).scrollTop();
		
		if(Math.abs(lastScrollTop - st) <= delta){return;}

		if (st > lastScrollTop && st > navbarHeight){
			$('.topFixd').removeClass('nav-down').addClass('nav-up');			
		} else {			
			if(st + $(window).height() < $(document).height()) {
				$('.topFixd').removeClass('nav-up').addClass('nav-down');
			}
		}
		if(st < navbarHeight){$('.topFixd').removeClass('nav-down');}
		
		lastScrollTop = st;
	}

	if ($('.js_add_favorite').length > 0) {
        if (/Android/i.test(navigator.userAgent) === true) {
            $('.js_add_favorite').show();
            // 데이터 타이틀에 클릭 엘리먼트에 data-title="{=gMall.companyNm}" 이걸 넣어줄 것
            $('.js_add_favorite').click(function(e) {
                e.preventDefault();
                gd_add_favorite_launcher($(this).data('title'));
            });
        }else if(/iPhone|iPad|iPod/i.test(navigator.userAgent) === true){
			$('.js_add_favorite').show();

			$('.js_add_favorite').click(function(e) {
                e.preventDefault();
                addToHomescreen();
            });
		}else {
            $('.js_add_favorite').remove();
        }
    }
	if($(".goods_timeSale").length > 0){

		var listTime = new Array();
		var listTimeEndDt = new Array();
		$(".goods_timeSale").each(function(){
			var timesaleenddt = $(this).data('timesaleenddt'),
				timesalesno = $(this).data('timesalesno');			
			if (listTime.indexOf(timesalesno) < 0) {
				listTime.push(timesalesno);
				listTimeEndDt.push(timesaleenddt);
			}
		});

		if(listTime.length > 0){
			$.each(listTime, function (index, item) {
				gd_dailyListTimer(listTimeEndDt[index],listTime[index]);
			});
		}
	}	
});

function gd_dailyListTimer(duration,sno){

	var now = new Date(),
		dday = new Date(duration.replace(/\s/, 'T')),
		selectTime = $('.goods_time_'+sno),
		timer = parseInt(dday - now);
	var days,hours, minutes, seconds;

	days = parseInt(timer / 1000 / 60 / 60 / 24); 
	hours = parseInt(timer / 1000 / 60 / 60 - (24 * days)); 
	minutes = parseInt(timer / 1000 /60 - (24 * 60 * days) - (60 * hours)); 
	seconds = parseInt(timer / 1000 - (24 * 60 * 60 * days) - (60 * 60 * hours) - (60 * minutes)); 

	if(days <= 0) {
		selectTime.find('.dayTxt').hide();
		selectTime.find('.goods_timeDay').hide();
	} else {
		selectTime.find('.goods_timeDay').html("");

		days 	= days < 10 ? "0" + days : days;
		for(i = 0; i < days.toString().length; i++) {
			selectTime.find('.goods_timeDay').append(days.toString().substr(i,1));
		}
	}

	hours 	= hours < 10 ? "0" + hours : hours;
	minutes = minutes < 10 ? "0" + minutes : minutes;
	seconds = seconds < 10 ? "0" + seconds : seconds;

	selectTime.find('.goods_timeHour').text(hours.toString().substr(0,2));
	selectTime.find('.goods_timeMin').text(minutes.toString().substr(0,2));
	selectTime.find('.goods_timeSec').text(seconds.toString().substr(0,2));

	if(timer > 0){
		$('.goods_timeSale').addClass("on");
		newtime = window.setTimeout("gd_dailyListTimer('"+duration+"','"+sno+"');", 1000); 
	}else{
		$('.goods_timeSale').removeClass("on");
	}
}

function PerCentFixPrice(){
	$('.dcPrice').each(function(){		
		var price, custom, dc_price="";
		price = $(this).attr('custom');
		custom = $(this).attr('price');
		
		if(price){
			price = Math.ceil(price);
		}
		if(custom){
			custom = Math.ceil(custom);			
		}
		if(custom > 0 && price > 0){
			dc_price = ( ( parseInt(price) -  parseInt(custom)) * 100) / parseInt(price);
			dc_price = Math.ceil(dc_price);

			if (dc_price > 0){
				$(this).text(+dc_price+'%').show();
			}
		}
	});
}

function categoryCurrent(){
	var $categoryContainer = $("#header .categorySlide .menuCategory"),
		$categoryOrigin = $categoryContainer.children("li"), 
		$categoryAdd = $categoryContainer.children("li").not(".originCategory"), 
		urlParams = getUrlParams();

	if( urlParams.cateCd ){
		var cateCd = urlParams.cateCd.substring( 0, 3 ),
			href = "../goods/goods_list.php?cateCd="+cateCd;

		$categoryOrigin.children("a[href='"+href+"']").addClass("currentCategory");
	}else{
		var locationPathname = window.location.pathname,
			locationSearch = window.location.search,
			url = locationPathname + locationSearch;

		$categoryAdd.each(function( ){
			var $this = $(this),
				$thisAnchor = $this.children("a"),
				$thisAnchorSelect = $this.children("a[href*='"+url+"']"),
				$thisChildAnchorSelect;

			if( $thisAnchorSelect.length > 0 && url != '/'){				
				$thisAnchorSelect.addClass("currentCategory");
				return false;
			}else{
				$thisChildAnchorSelect = $this.find("ul").find("a[href*='"+url+"']");
				if( $thisChildAnchorSelect.length > 0 && url != '/'){
					$thisAnchor.addClass("currentCategory");
					return false;
				}
			}
		});
	}
}
function addfavorites(url,tit) {
	var bookmarkURL = location.protocol+"//"+ url; 
	var bookmarkTitle = tit; 
	
	var triggerDefault = false; 
		if (window.sidebar && window.sidebar.addPanel) { 
			window.sidebar.addPanel(bookmarkTitle, bookmarkURL, ''); 
		} else if ((window.sidebar && (navigator.userAgent.toLowerCase().indexOf('firefox') > -1)) || (window.opera && window.print)) {
			var $this = $(this); 
			$this.attr('href', bookmarkURL); 
			$this.attr('title', bookmarkTitle); 
			$this.attr('rel', 'sidebar'); $this.off(e); 
			triggerDefault = true; 
		} else if (
			window.external && ('AddFavorite' in window.external)) {
			window.external.AddFavorite(bookmarkURL, bookmarkTitle); 
		} else { 
			alert((navigator.userAgent.toLowerCase().indexOf('mac') != -1 ? 'Cmd' : 'Ctrl') + '+D 키를 눌러 즐겨찾기에 등록하실 수 있습니다.'); 
		} 
	return triggerDefault;
}
/*
function getQueryString(sKey)
{
    var sQueryString = document.location.search.substring(1);
    var aParam       = {};

    if (sQueryString) {
        var aFields = sQueryString.split("&");
        var aField  = [];
        for (var i=0; i<aFields.length; i++) {
            aField = aFields[i].split('=');
            aParam[aField[0]] = aField[1];
        }
    }
    aParam.page = aParam.page ? aParam.page : 1;
    return sKey ? aParam[sKey] : aParam;
};
*/
function getUrlParams() {
	var params = {};
	window.location.search.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(str, key, value) { params[key] = value; });
	return params;
}

function allCategoryFunction(){
	$("#allCategoryDim .categoryMore").click(function(){
		var $this = $(this),
			$parent = $this.parent();

		$parent.toggleClass("nowShow").children(".subCategory").toggleClass("nowShow");
	});

	$(".headerGnb").find(".categoryAll").find(".gnbAllBtn").click(function(){
		$("#allCategoryDim").toggleClass("nowShow");
	});

	$("#allCategoryDim .gnbAllCloseBtn").click(function(){
		$("#allCategoryDim").removeClass("nowShow").find(".nowShow").removeClass("nowShow");
	});
}

function quickFunction(){
	$(".moveScrollTop").click(function(e) {
		e.preventDefault();
		$("body, html").stop().animate({scrollTop:0}, 500);
	});
	$(".moveScrollBottom").click(function(e) {
		e.preventDefault();
		$("body, html").stop().animate({scrollTop:$('body').height()}, 500);
	});
}

function asideAction(){
	var $aside = $("#aside"),
		$categoryMore = $aside.find(".categoryMore"),
		$closeBtn = $aside.find(".asideClose"),
		$asideDim = $("#asideDim"),
		$asideBtn = $(".asideBtn"),
		$categoryAllBtn = $(".categoryAllBtn"),
		$displayEventGroup = $asideDim.add($closeBtn).add($asideBtn).add($categoryAllBtn);

	var display  = function(){
		var windowWidth = $( window ).width();

		if( windowWidth > 1024){
			$aside.removeClass("nowShow");
		}
	};

	$categoryMore.on('click', function(){
		var $this = $(this),
			$thisParent = $this.parent(),
			$thisChild = $this.siblings(".subCategory");

		if( !$thisChild.is(':animated') ) {
			$thisChild.stop(true,true).slideToggle("fast",function(){
				$("#aside .inner").getNiceScroll().resize();
			});
			$thisParent.toggleClass("nowShow");
			
		}
	});

	$displayEventGroup.on('click', function(){
		$aside.toggleClass("nowShow");
	});

	$(window).on( "resize", function() { display() });
}
function winPop(url,we,hi) {
	if(!we){we="600";}
	if(!hi){hi="600";}
    window.open(url, "popup", "width="+we+",height="+hi+",left=10px,top=10px,resizable=no,scrollbars=no");
}

function gd_mpl_recommend(bdId, sno) {
    $.get('../board/board_ps.php', {
        'mode': 'recommend',
        'bdId': bdId,
        'sno': sno
    }, function (data, status) {
        if (status == 'success') {
            alert(data['message']);
            $('#board_recommend_'+sno).find('strong').html(data['recommendCount']);
        }
        else {
            alert('request fail. ajax status (' + status + ')');
        }
    }, 'json');
}

function gd_add_favorite_launcher(title) {

    // 안드로이드가 아닌 경우 실행하지 않는다.
    if (!/Android/i.test(navigator.userAgent)) {
        return false;
    }
    // 홈버튼 추가에 필요한 설정 초기화
    var favoriteData = {
        iframe: $('#ifrmAddFavoriteLauncher'),
        defaultIconName: 'defaultShopIcon.png',
        title: encodeURI(title),
        code: 'nstore',
        icon: '',
    };
    // link의 아이폰 아이콘 url 가져오기
    $('link').each(function(idx){
        if ($(this).prop('rel') === 'apple-touch-icon-precomposed') {
            // prop으로 href를 가져오는 경우 fullurl을 가져오며 https인 경우 http로 전환시킨다.
            favoriteData.icon = $(this).prop('href').replace('https', 'http');
            return false;
        }
    });
    // 아이콘이 없는 경우 네이버앱에서 메시지 없이 오류가 발생하기 때문에 반드시 아이콘 URL을 넣어 처리해야 한다.
    if (favoriteData.icon !== '') {
		
        // 앱설치 페이지 혹은 바탕화면 추가하기 (기획에 요청해서 메시지 변경하기)
        alert(__('%1$s을(를) 홈화면에 추가합니다.%2$s네이버앱이 없는 고객님께서는 네이버앱 설치페이지로 이동됩니다.', [decodeURI(favoriteData.title), '\n\n']));

        // 네이버앱 연결 url scheme (Intent로 하지 않는 경우 네이버 앱이 없을때 자동으로 이동하지 않는다)
        // var scheme = 'naversearchapp://addshortcut?url=' + encodeURI(document.domain) + '&icon=' + favoriteData.icon + '&title=' + favoriteData.title + '&serviceCode=' + favoriteData.code + '&version=7';
        var scheme = 'intent://addshortcut?url=' + encodeURI(gdGlobalHomeUri) + '&icon=' + favoriteData.icon + '&title=' + favoriteData.title + '&serviceCode=' + favoriteData.code + '&version=7#Intent;scheme=naversearchapp;action=android.intent.action.VIEW;category=android.intent.category.BROWSABLE;package=com.nhn.android.search;end';

        if (favoriteData.iframe.length > 0) {
            favoriteData.iframe.attr('src', scheme);
        } else {
            location.href = scheme;
        }
    }
}
function isMobile() {
    return /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent);
}
function make_layer_popup(url, title){
    var height = $('body').prop('scrollHeight');
    var fontSize = url ? 20 : 28;
    var _height = url ? 42 : 50;
    var margin = url ? 0 : '10px 0 0 0';
    var padding = 0;
    if (title) {
        padding = '42px 0 0 0';
    }
    if (!$('#layerSearch').length) {
        $('<div>', {
            css: {
                position: 'absolute',
                top: '0',
                left: '0',
                width: '100%',
                zIndex: '1001'
            },
            id: 'layerSearch'
        }).appendTo('body');
    }
    $('<div>', {
        css: {
            position: 'absolute',
            top: '0',
            left: '0',
            width: '100%',
            height: height + 'px',
            background: '#fff'
        },
        id: 'layerSearchArea'
    }).appendTo('#layerSearch');

    $('<div>', {
        css: {
            width: '100%',
            height: '100%',
            background: '#fff'
        },
        id: 'layerSearchInner'
    }).appendTo('#layerSearchArea')

    $('<iframe>', {
        css: {
            width: '100%',
            overflow: 'scroll',
            background: '#fff',
            padding: padding,
            height: '100%'
        },
        id: 'layerSearchFrame',
        name: 'layerSearchFrame',
        src: url,
        frameborder: 0
    }).appendTo('#layerSearchInner');
    if (title) {
        $('<div>', {
            class: 'ly_head',
            css: {
                height: _height + 'px',
            }
        }).appendTo('#layerSearch');

        $('<h1>', {
            html: title,
            class: 'h_tit elp',
            css: {
                'font-size': fontSize + 'px',
                'margin': margin
            }
        }).appendTo('.ly_head');

        $('<button>', {
            type: 'button',
            html: '<span class="sp">닫기</span>',
            css: {
                position: 'absolute',
                top: 0,
                right: 0,
                padding: '14px 9px 13px 20px'
            },
            class: 'bn_cls v2 lys_btn_close',
            onclick: 'layerSearchClose()'
        }).appendTo('.ly_head');
    }

    $('html, body').scrollTop(0);
}

function layerSearchClose()
{
    $("meta[name='viewport']").attr({"content":"user-scalable=yes, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"});
    $('#layerSearch').remove();
}