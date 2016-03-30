$(function () {
    $('#fileupload').fileupload({
        dataType: 'json',
        
        done: function (e, data) {
        	$("tr:has(td)").remove();
            $.each(data.result, function (index, image) {
            	
            	
                $("#uploaded-files").append(
                		$('<tr/>')
                		.append($('<td/>').html('<a href="/MasterNodeServer/image/' + image.hash +'">'+ image.name+'</a>'))
                		.append($('<td/>').text(image.fileSize))
                		.append($('<td/>').text(image.fileType))
                		.append($('<td/>').html('<a href="/MasterNodeServer/controller/get/' + image.hash +'" class="thumbnail">' 
                				+ "<img src='/MasterNodeServer/controller/thumbnail/getImage/" + image.hash + "' alt="+ image.fileName +"/>" + 
                				'</a>'))
                		.append($('<td/>').html('<a href="/MasterNodeServer/image/' + image.hash +'">Show</a>'))
                		.append($('<td/>').html('<a href="/MasterNodeServer/image/delete/' + image.deleteHash +'">Delete</a>'))
                		)//end $("#uploaded-files").append()
            }); 
        },
        
        progressall: function (e, data) {
	        var progress = parseInt(data.loaded / data.total * 100, 10);
	        $('.progress-bar').css(
	            'width',
	            progress + '%'
	        );
	        $('.progress-bar').text(progress + "%")
	        
   		},
   		
		dropZone: $('#dropzone')
    });
});