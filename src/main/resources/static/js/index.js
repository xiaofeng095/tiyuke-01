$('.form').find('input, textarea').on('keyup blur focus', function (e) {
  
  var $this = $(this),
      label = $this.prev('label');

	  if (e.type === 'keyup') {
			if ($this.val() === '') {
          label.removeClass('active highlight');
        } else {
          label.addClass('active highlight');
        }
    } else if (e.type === 'blur') {
    	if( $this.val() === '' ) {
    		label.removeClass('active highlight'); 
			} else {
		    label.removeClass('highlight');   
			}   
    } else if (e.type === 'focus') {
      
      if( $this.val() === '' ) {
    		label.removeClass('highlight'); 
			} 
      else if( $this.val() !== '' ) {
		    label.addClass('highlight');
			}
    }

});

$('.tab a').on('click', function (e) {
  
  e.preventDefault();
  
  $(this).parent().addClass('active');
  $(this).parent().siblings().removeClass('active');
  
  target = $(this).attr('href');

  $('.tab-content > div').not(target).hide();
  
  $(target).fadeIn(600);
  
});

//列表页面上点击删除按钮弹出删除框
$(function () {
    $('.delete').click(function () {
        //灰背景遮挡效果
        $('.zhezhao').css('display', 'block');
        $('#removeProv').fadeIn();
        $("#deleteForm").attr("action", $(this).attr("del_uri"));
    });
    //点击 确定
    $('#yes').click(function () {
        $("#deleteForm").submit();
        $('.zhezhao').css('display', 'none');
        $('#removeProv').fadeOut();
    });
    //点击 取消
    $('#no').click(function () {
        $('.zhezhao').css('display', 'none');
        $('#removeProv').fadeOut();
    });
});
