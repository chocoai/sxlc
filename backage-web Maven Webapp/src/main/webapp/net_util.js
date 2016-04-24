/**
 * 防篡改js封装
 */
var NetUtil = {
    postRequest: function (str_Url, json_Data,sign,fnOnSuccess,fnBefore, fnComplete) {
    	json_Data.sign = sign;
        if (str_Url) {
            $.ajax({
                type: 'post',
                url: str_Url,
                data: json_Data,
                timeout: 8000,
                success: fnOnSuccess,
                beforeSend: fnBefore,
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                	layer.alert("服务器异常，请联系管理员",{icon:2});  
                }, 
                complete:fnComplete
            });
        } else {
            alert("url参数是必须的.");
        }
    },
    //创建秘钥
    createSign: function (params) {
        if (params) {
            var code ="";
            var keys = [];
            for (var x in params) {
                keys.push(x);
            }
            keys.sort();
            for (var i = 0; i < keys.length; i++) {
                var key = keys[i];
                code += key;
                code += params[key];
            }
           
            var md5_value = hex_md5(code).toUpperCase();
            return md5_value;
        }
        return null;
    },
    //签名（复杂算法用）
    signData: function (dataJson) {
        var args =JSON.stringify(dataJson);
        var sign = NetUtil.createSign(args);
        return sign;
    },
    ajax: function (url,data,fnOnSuccess,fnBefore, fnComplete) {
//        var sign = NetUtil.signData(data);//复杂算法
        var sign = NetUtil.createSign(data);//简单算法
        NetUtil.postRequest(url,data,sign, fnOnSuccess,fnBefore, fnComplete);
    }
};