$(function(){
	$("#good_xdd").Validform({
		tiptype:3,
		btnSubmit:".queding", 
		datatype:{"enterAddress":enterAddress,"acountM":acountM,"time":time},
		ajaxPost:{
			
		    },
			success:function(data,obj){
	            
	        },
	        error:function(data,obj){
	            
	        }
		});
});

$(function(){
	//�ϴ���ʼ��
	var uploader1 = WebUploader.create({
		auto: true,														//ѡ���ļ����Ƿ��Զ��ϴ���
	    swf: 'plugs/webuploader/0.1.5/Uploader.swf',					//swf�ļ�·��
	    server: '',	//�ļ����շ���ˡ�
	    // ѡ���ļ��İ�ť����ѡ��
	    pick: '#filePicker1',											//�ڲ����ݵ�ǰ�����Ǵ�����������inputԪ�أ�Ҳ������flash.
	    fileNumLimit: 1,												//��������
		//[��ѡ] [Ĭ��ֵ��undefined] ��֤�����ļ���С�Ƿ񳬳�����, ���������������С�
	    fileSingleSizeLimit: 1024*512,
	    accept: {														//ֻ����ѡ��ͼƬ�ļ�
	        title: 'Images',
	        extensions: 'gif,jpg,jpeg,bmp,png',
	        mimeTypes: 'image/*'
	    },
	    resize: false													//��ѹ��image, Ĭ�������jpeg���ļ��ϴ�ǰ��ѹ��һ�����ϴ���
	});
	
	// �����ļ���ӽ�����ʱ��
	uploader1.on( 'fileQueued', function( file ) {
	    var $li = $(
	            '<div id="' + file.id + '" class="file-item thumbnail">' +
	                '<img>' +
	                '<div class="info">' + file.name + '</div>' +
	            '</div>'
	            ),
	        	$del = $del = $('<div class="file-panel"><span class="cancel">ɾ��</span></div>'),
		        $img = $li.find('img');
	
	
	    // $listΪ����jQueryʵ��
	    $list = $("#fileList1");
	    $list.append( $li );
	    $del.appendTo( $li );
	    
	    //Ԥ��ʱ�����������
	    $("#fileList1 .file-item").each(function(){
			$(this).mouseenter(function(){
				$(this).parent().find(".file-panel").animate({height:30},"fast");
			}).mouseleave(function(){
				$(this).parent().find(".file-panel").animate({height:0},"fast");
			});
	    });
		
	    //����
		$del.on('click', 'span', function() {
			removeFile(file);
		});
		
		// ����view������
		function removeFile(file) {
			var $li = $('#' + file.id);
			uploader1.removeFile(file, true);
			$li.off().find('.file-panel').off().end().remove();
		}
		
	
	    // ��������ͼ
	    // ���Ϊ��ͼƬ�ļ������Բ��õ��ô˷�����
	    // thumbnailWidth x thumbnailHeight Ϊ 100 x 100
	    // �Ż�retina, ��retina�����ֵ��2
        ratio = window.devicePixelRatio || 1,
        thumbnailWidth = 200 * ratio,
        thumbnailHeight = 184 * ratio,
	    
	    uploader1.makeThumb( file, function( error, src ) {
	        if ( error ) {
	            $img.replaceWith('<div>����Ԥ��</div>');
	            return;
	        }
	
	        $img.attr( 'src', src );
	    }, thumbnailWidth, thumbnailHeight );
	});
	
	// �ļ��ϴ������д���������ʵʱ��ʾ��
	uploader1.on( 'uploadProgress', function( file, percentage ) {
	    var $li = $( '#'+file.id ),
	        $percent = $li.find('.progress span');
	
	    // �����ظ�����
	    if ( !$percent.length ) {
	        $percent = $('<p class="progress"><span></span></p>')
	                .appendTo( $li )
	                .find('span');
	    }
	
	    $percent.css( 'width', percentage * 100 + '%' );
	});
	
	// �ļ��ϴ��ɹ�����item��ӳɹ�class, ����ʽ����ϴ��ɹ���
	uploader1.on( 'uploadSuccess', function( file ) {
	    $( '#'+file.id ).addClass('upload-state-done');
	});
	
	// �ļ��ϴ�ʧ�ܣ���ʾ�ϴ�����
	uploader1.on( 'uploadError', function( file ) {
	    var $li = $( '#'+file.id ),
	        $error = $li.find('div.error');
	
	    // �����ظ�����
	    if ( !$error.length ) {
	        $error = $('<div class="error"></div>').appendTo( $li );
	    }
	
	    $error.text('�ϴ�ʧ��');
	});
	
	// ����ϴ����ˣ��ɹ�����ʧ�ܣ���ɾ����������
	uploader1.on( 'uploadComplete', function( file ) {
	    $( '#'+file.id ).find('.progress').remove();
	});
});
