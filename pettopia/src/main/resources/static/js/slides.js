var slides = document.querySelector('.slides'),
    slide = document.querySelectorAll('.slides li'),
    currentIdx = 0,
    slideCount = slide.length,
    slideWidth = 370,
    slideMargin = 30,
    prevBtn = document.querySelector('.prev'),
    nextBtn = document.querySelector('.next');

console.log(slideCount);

makeClone();

function makeClone(){
    for(var i = 0 ; i < slideCount ; i++){
        //a.cloneNode(), a.cloneNode(true)
        var cloneSlide = slide[i].cloneNode(true);
        cloneSlide.classList.add('clone');
        //a.appendChild(b)
        slides.appendChild(cloneSlide);
    };

    for(var i = slideCount - 1 ; i >= 0 ; i--){
        var cloneSlide = slide[i].cloneNode(true);
        cloneSlide.classList.add('clone');
        //a.prepend(b)
        slides.prepend(cloneSlide);
    };

    updateWidth();

    setInitialPos();

    setTimeout(function(){
        slides.classList.add('animated');
    }, 100);
};

//전체개수를 구하고 그 개수에다가 슬라이드 하나와 하나의 마진까지 곱한다?
function updateWidth(){
    var currentSlides = document.querySelectorAll('.slides li');
    var newSlideCount = currentSlides.length;

    var newWidth = (slideWidth + slideMargin) * newSlideCount - slideMargin + 'px';
    slides.style.width = newWidth;
};

function setInitialPos(){
    var initalTranslateValue = - (slideWidth + slideMargin) * slideCount;
    //slides {transform : translateX(-1000px);}
    slides.style.transform = 'translateX(' + initalTranslateValue + 'px)';
};

function moveSlide(num){
    slides.style.left = - num * (slideWidth + slideMargin) + 'px';
    currentIdx = num;
    
    // console.log(currentIdx, slideCount);
    
    if(currentIdx == slideCount || currentIdx == -slideCount){
        //이 모든건 시간이 지난 다음에 진행되어야 한다.
        setTimeout(() => {
            //움직이는 과정이 안보이게 해야한다.
            slides.classList.remove('animated');
            slides.style.left = '0px';
            currentIdx = 0;
        }, 500);
        //시간이 지난 다음에 애니메이션을 보여줘야한다.
        setTimeout(() => {
            slides.classList.add('animated');
        }, 600);
    };
};

nextBtn.addEventListener('click',function(){
    moveSlide(currentIdx + 1);
    stopSlide();
    autoSlide();
});

prevBtn.addEventListener('click',function(){
    moveSlide(currentIdx - 1);
    stopSlide();
    autoSlide();
});

//clearInterval(timer);
var timer = undefined;

function autoSlide(){
    if(timer == undefined){
        timer = setInterval(function(){
            moveSlide(currentIdx + 1);
        }, 3000);
    };
};

autoSlide();

//https://www.youtube.com/watch?v=xjhvTZTNEKA&list=PL-qMANrofLyvzqz2yYzNectJnYo5ZifE7&index=54
//마우스를 올렸을 때 멈춰라
function stopSlide(){
    clearInterval(timer);
    timer = undefined;
};

slides.addEventListener('mouseenter',function(){
    stopSlide();
});

slides.addEventListener('mouseleave',function(){
    autoSlide();
})