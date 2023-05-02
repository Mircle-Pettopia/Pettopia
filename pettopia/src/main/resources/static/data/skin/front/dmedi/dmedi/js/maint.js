   (function(){ 
        var $this=$('#header .lnb');
        var $li=$this.find('li');
        var $sub=$this.find('.sub');
        var $bg=$this.find('.bg');
        var $header=$('#header');
        var speed=200;

        $this.bind('mouseenter',function(){
            $sub.stop(true,true).slideDown(speed) ;
            $bg.stop(true,true).slideDown(speed);

            $header.addClass('on');
        }).bind('mouseleave',function(){
            $sub.stop(true,true).slideUp(speed) ;
            $bg.stop(true,true).slideUp(speed);
            if(isScroll==0){
                $header.removeClass('on');
            }
        }); 
        $li.bind('mouseenter',function(){
            $(this).addClass('on');
        }).bind('mouseleave',function(){
            $(this).removeClass('on');
        });
        //
        var scrollTop=0;
        var isScroll=0;
        $(window).scroll(function(){
            scrollTop=$(this).scrollTop();
            if(scrollTop>0){
                $header.addClass('on');
                isScroll=1;
            }else{
                $header.removeClass('on');
                isScroll=0;
            }
        });
        //
        var $full=$('#full');
        $('.full_btn , #full .close').bind('click',function(){
            $full.toggleClass('on');
        });
    })();