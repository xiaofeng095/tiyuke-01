function imgPreview(fileDom){
    //判断是否支持FileReader
    if (window.FileReader) {
        var reader = new FileReader();
    } else {
        alert("您的设备不支持图片预览功能，如需该功能请升级您的设备！");
    }

    //获取文件
    var file = fileDom.files[0];
    var imageType = /^image\//;
    //是否是图片
    if (!imageType.test(file.type)) {
        alert("请选择图片！");
        return;
    }
    //读取完成
    reader.onload = function(e) {
        //获取图片dom
        var img = document.getElementById("preview");
        //图片路径设置为读取的图片
        img.src = e.target.result;
    };
    reader.readAsDataURL(file);
}

function uploadVideo(field,that) {
    var file = that.files[0];
    //视频截图
    windowURL = window.URL || window.webkitURL;
    videoURL = windowURL.createObjectURL(file);
    $('#videoarea').html('<video src="' + videoURL + '" width="100%" height="100%" style="object-fit:fill"   controls="controls" preload ="auto" ></video>');
    //

    var formdata = new FormData();
    formdata.append(field, file);
    XHR = new XMLHttpRequest();
    XHR.open('POST', 'baidu.addvideos?field='+field, true);
    XHR.onreadystatechange = function() {
        if (XHR.readyState == 4) {
            if (XHR.responseText.indexOf('|') >= 0) {
                //####
                //####
                //####

                //视频截图
                var scale = 0.25,
                    video = $('#videoarea').find('video')[0],
                    canvas = document.createElement("canvas"),
                    canvasFill = canvas.getContext('2d');
                canvas.width = video.videoWidth * scale;
                canvas.height = video.videoHeight * scale;
                canvasFill.drawImage(video, 0, 0, canvas.width, canvas.height);
            }
        }
    };
    XHR.send(formdata);
}