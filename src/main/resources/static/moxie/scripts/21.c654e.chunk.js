webpackJsonp([21],{75:function(e,t,a){e.exports=a.p+"assets/dce45f5d.download.gif"},76:function(e,t,a){e.exports=a.p+"assets/a44566d4.invalid.png"},219:function(e,t,a){try{(function(){"use strict";function n(e){return e&&e.__esModule?e:{default:e}}Object.defineProperty(t,"__esModule",{value:!0});var r=a(2),s=n(r),o=a(9),l=a(15),i=n(l),u=a(1),d=a(40),p=a(4),c=n(p),m=a(217),f=n(m),g=a(10),h=n(g),y=a(13),_=n(y),k=a(5),E=n(k),v=a(11),C=(n(v),a(41)),w=n(C),b=a(12),T=n(b),x="#58B5EB",I="https://api.51datakey.com/h5/static/bank_icon/bank_icon_{bankMark}.png",P=s.default.createClass({displayName:"ImportForm",getInitialState:function(){return{loginTypeIndex:0,login:!1,Type:"password",bgImg:"url("+a(20)+")",qrcodeTimeout:!1,qrcodeValue:null,showQRCodeInstruction:!1,gettingCode:!1,cardType:this.props.cardType,bankId:this.props.bankId,frontConf:this.props.frontConf}},componentDidMount:function(){var e=this;this.onSubmitTaskDone,document.activeElement.blur();var t=this.props,a=t.pageConfig,n=(t.poll,(0,d.getParams)("loginParams"));n&&"undefined"!=n&&n[a.login_type]&&(n[a.login_type].username&&n[a.login_type].password&&!n[a.login_type].username1||n[a.login_type].username1&&n[a.login_type].username&&n[a.login_type].password)&&(this.timer=setInterval(function(){n[a.login_type].username1?""!=e.refs[a.login_type+"input0"].getValue()&&""!=e.refs[a.login_type+"input1"].getValue()&&""!=e.refs[a.login_type+"input2"].getValue()&&(clearInterval(e.timer),e.handleImport()):""!=e.refs[a.login_type+"input0"].getValue()&&""!=e.refs[a.login_type+"input2"].getValue()&&(clearInterval(e.timer),e.handleImport())},100)),"QRCODE"==a.login_type,this.isMounted=!0;var r=0;this.setState({loginTypeIndex:r})},componentWillUnmount:function(){this.isMounted=!1,clearInterval(this.timer)},render:function(){var e=this,t=this.handleImport,a=this.renderLoginTypeTabs,n=this.renderInputs,r=this.tryGetCachedValue,o=(r("password"),this.props.pageConfig),l=a(),i=n();if(this.props.pageConfig.notice)var d=JSON.parse(this.props.pageConfig.notice).content,p=JSON.parse(this.props.pageConfig.notice).title;var c=s.default.createElement("div",{className:"config-import-page"},this.props.pageConfig.notice?s.default.createElement("div",{style:{fontSize:"12px",marginBottom:"30px"}},s.default.createElement(f.default,{content:d,height:"30px",top:"0px",title:p})):null,l,i.length>0?s.default.createElement("div",{className:"form",style:{width:"100%"}},i):null,"QRCODE"!=o.login_type?s.default.createElement("div",null,s.default.createElement("div",{className:"login-other-items"},s.default.createElement(w.default,{ref:"agreementField",uid:o.login_type,frontConf:this.state.frontConf}),s.default.createElement("div",{style:{float:"right",fontSize:"12px",color:u.qsParams.themeColor?"#"+u.qsParams.themeColor:"#5e82fb",padding:"0 15px"}},(this.props.pageConfig.mx_forget_password_url||this.props.pageConfig.forget_password_url)&&"1"==this.state.frontConf.showMoreInformation?s.default.createElement(h.default,{onTap:function(){return e.handleLink(3)}},s.default.createElement("span",null,"找回密码")):null,(this.props.pageConfig.mx_forget_password_url||this.props.pageConfig.forget_password_url)&&"1"==this.state.frontConf.showMoreInformation&&(this.props.pageConfig.mx_forget_username_url||this.props.pageConfig.forget_username_url)?s.default.createElement("span",null," / "):null,(this.props.pageConfig.mx_forget_username_url||this.props.pageConfig.forget_username_url)&&"1"==this.state.frontConf.showMoreInformation?s.default.createElement(h.default,{onTap:function(){return e.handleLink(4)}},s.default.createElement("span",null,"找回用户名")):null)),s.default.createElement("div",{className:"page-wrapper"},s.default.createElement(h.default,{onTap:t},s.default.createElement(E.default,{types:"full",disable:this.state.login,state:this.state.login,onTap:function(){},getState:function(e){switch(e){case!1:return"提交";case!0:return"登录中...";default:return"提交"}}}))),s.default.createElement("div",{style:{color:u.qsParams.themeColor?"#"+u.qsParams.themeColor:"#5e82fb"},className:"link-wrapper"},this.props.pageConfig.login_url&&"1"==this.state.frontConf.showMoreInformation?s.default.createElement("div",{onClick:function(){e.handleLink(2)}},s.default.createElement("span",{className:"ion-ios-world"}),s.default.createElement("a",{style:{color:u.qsParams.themeColor?"#"+u.qsParams.themeColor:"#5e82fb"}},"前往官网")):null,this.props.pageConfig.mx_register_url&&"1"==this.state.frontConf.showMoreInformation?s.default.createElement("div",{onClick:function(){e.handleLink(1)}},s.default.createElement("span",{className:"ion-ios-redo-outline"}),s.default.createElement("a",{style:{color:u.qsParams.themeColor?"#"+u.qsParams.themeColor:"#5e82fb"}},"开通网银")):null)):null);return s.default.createElement("div",null,c,"QRCODE"==o.login_type?s.default.createElement("div",null,this.state.showQRCodeInstruction?s.default.createElement("div",{style:{position:"fixed"},className:"vcode-tips-bg",onClick:function(){e.setState({showQRCodeInstruction:!1})}},s.default.createElement("div",{className:"iknow-button"},"我知道了"),this.renderInstructionView()):null):null)},handleLink:function(e){var t=this.context.history.pushState,a=window.location.protocol+"//"+window.location.host+window.document.location.pathname+"#",n=this.props.pageConfig.register_url,r=this.props.pageConfig.forget_password_url,s=this.props.pageConfig.forget_username_url,o=function(){return(T.default.apiToken?"apitoken="+T.default.apiToken:"apikey="+T.default.apiKey)+"&userId="+u.qsParams.userId+"&themeColor="+u.qsParams.themeColor};switch(this.props.pageConfig.mx_register_url&&(n=a+this.props.pageConfig.mx_register_url+"?"+o()),this.props.pageConfig.mx_forget_password_url&&(r=a+this.props.pageConfig.mx_forget_password_url+"?"+o()),this.props.pageConfig.mx_forget_username_url&&(s=a+this.props.pageConfig.mx_forget_username_url+"?"+o()),e){case 1:c.default.openWebView("开通网银",n,"","");break;case 2:c.default.openWebView("网银登录",this.props.pageConfig.login_url,"","");break;case 3:c.default.openWebView("找回密码",r,"","");break;case 4:c.default.openWebView("找回用户名",s,"","");break;case 5:"1"==this.state.frontConf.showHelpInIframe?(u.qsParams.url=encodeURIComponent(this.props.pageConfig.help_url),t({title:"帮助"},"/otherView",u.qsParams)):c.default.openWebView("帮助",this.props.pageConfig.help_url,"","")}},renderLoginTypeTabs:function(){var e=(this.selectLoginType,this.state.loginTypeIndex,this.props.pageConfig,null),t=100..toFixed(2);return{backgroundColor:u.qsParams.themeColor?"#"+u.qsParams.themeColor:x,width:t+"%",borderRight:"1px solid #"+u.qsParams.themeColor},{color:"#"+u.qsParams.themeColor,backgroundColor:"white",width:t+"%",borderRight:"1px solid #"+u.qsParams.themeColor},{borderColor:"#"+u.qsParams.themeColor},e},renderInputs:function(){var e,t=this,a=this.tryGetCachedValue,n=this.wrapValidator,r=(this.getPasswordCache,this.state.loginTypeIndex,this.props.pageConfig),o=a("username"),l=a("password");if(r.username1_desc){e=o;var i=o.indexOf(",");o=o.substring(0,i),e=e.substring(i+1)}var p=!1,c=(0,d.getParams)("loginParams")?(0,d.getParams)("loginParams"):{};c[r.login_type]&&(p=!0);var m=[];if("QRCODE"!=r.login_type)for(var f=0;f<3;f++){var g=null;g=0==f?s.default.createElement("div",{className:"input-item",key:r.login_type+"input"+f},s.default.createElement(_.default,{key:r.login_type+"input"+f,type:"text",ref:r.login_type+"input"+f,defaultValue:p&&c[r.login_type].username?c[r.login_type].username:o,placeholder:r.username_desc+("("+r.username_tips+")"),validator:n(r.username_regex),disabled:!!p&&!!c[r.login_type].username}),f>0?null:this.props.pageConfig.help_url?s.default.createElement("div",{onClick:function(){return t.handleLink(5)},className:"d-tiao"},"帮助",s.default.createElement("span",{style:{fontSize:"18px",color:u.qsParams.themeColor?"#"+u.qsParams.themeColor:"#5e82fb"},className:"ion-ios-help-outline"})):null):1==f?r.username1_desc?s.default.createElement("div",{className:"input-item",key:r.login_type+"input"+f},s.default.createElement(_.default,{key:r.login_type+"input"+f,type:"text",ref:r.login_type+"input"+f,defaultValue:p&&c[r.login_type].username1?c[r.login_type].username1:e,placeholder:r.username1_desc+("("+r.username1_tips+")"),validator:n(r.username1_desc),disabled:!!p&&!!c[r.login_type].username1})):null:s.default.createElement("div",{className:"input-item",key:r.login_type+"input"+f},s.default.createElement(_.default,{key:r.login_type+"input"+f,type:this.state.Type,ref:r.login_type+"input"+f,defaultValue:p&&c[r.login_type].password?c[r.login_type].password:l,placeholder:r.password_desc+("("+r.password_tips+")"),validator:n(r.password_regex),disabled:!!p&&!!c[r.login_type].password}),s.default.createElement("div",{onClick:this.showPwd,className:"tex_box"},s.default.createElement("span",{style:{backgroundImage:this.state.bgImg},className:"password password_show"}))),m.push(g)}else{var h=this.renderQRCode();m.push(h)}return m},renderQRCode:function(){var e=this,t=this.props,n=t.qrcodeValue,r=t.qrcodeTimeout,o=t.getQrcodeError,l=t.bankId;return s.default.createElement("div",null,s.default.createElement("div",{className:"qrcode-login"},s.default.createElement("div",{className:"qrcode-title"},function(){return null==n?e.state.gettingCode?r?o?"获取二维码失败":"二维码超时":"正在获取二维码":"点击图片获取二维码":"扫码授权"}()),s.default.createElement("div",{className:"qrcode-content"},this.state.gettingCode?null:s.default.createElement(h.default,{onTap:function(){e.createBankQrcodeTask()}},s.default.createElement("div",null,s.default.createElement("img",{className:"qrcode-center",src:I.replace("{bankMark}",l)}))),n?s.default.createElement(h.default,{onPress:function(t){e.onPressImg(n),t.preventDefault()}},s.default.createElement("div",null,s.default.createElement("img",{className:"qrcode-image",src:"data:image/png;base64,"+n}))):s.default.createElement(h.default,{onTap:function(){r&&e.createBankQrcodeTask()}},s.default.createElement("div",{className:"qrcode-image"},r?s.default.createElement("div",{className:"qrcode-retry-button"},"点击重新获取"):null)),function(){return null==n&&e.state.gettingCode?r?s.default.createElement(h.default,{onTap:function(){r&&e.createBankQrcodeTask()}},s.default.createElement("img",{className:"qrcode-center",src:a(76)})):s.default.createElement("img",{className:"qrcode-center",src:I.replace("{bankMark}",l)}):null}(),n||r||!this.state.gettingCode?null:s.default.createElement("img",{className:"qrcode-center-circle",src:a(75)})),s.default.createElement("div",{className:"qrcode-instruction"},s.default.createElement("div",{className:"qrcode-instruction-text"},c.default.Device.Mobile?!c.default.Device.Wechat&&u.BankApplink[l]&&u.BankApplink[l].link?"1.长按或截图保存二维码\r\n2.请点击扫一扫进行扫码授权\r\n3.扫码后请稍作等待":'1.长按或截图保存二维码\r\n2.打开APP"'+u.BankApplink[l].appName+'"进行扫码授权\r\n3.扫码后请稍作等待':'1.请打开手机APP"'+u.BankApplink[l].appName+'"扫码\r\n2.扫码后请稍作等待')),n?s.default.createElement("div",{className:"vcode-dialog-body-operation",style:{padding:0}},s.default.createElement("div",{className:"operation-main"},s.default.createElement(E.default,{types:"small outline",onTap:function(){e.setState({showQRCodeInstruction:!0})}},"查看指引"),c.default.Device.Mobile&&!c.default.Device.Wechat&&u.BankApplink[l]&&u.BankApplink[l].link?s.default.createElement(E.default,{types:"small outline",onTap:function(){c.default.mxOpenUrl({url:u.BankApplink[l].link})}},"扫一扫"):null)):null))},handleImport:function(){function e(){i.default.set("bank",s,m,r.login_type,{loginParamAccount:p,loginFail:!0})}var t=this,a=this.onSubmitTaskDone,n=this.props,r=n.pageConfig,s=n.bankId;if(n.onImport,this.state.loginTypeIndex,!this.refs.agreementField.isChecked(C.AGREEMENT_TYPE.MOXIE))return void setTimeout(function(){return c.default.alert("请勾选同意《用户使用协议》","")});if(!this.refs.agreementField.isChecked(C.AGREEMENT_TYPE.TENANT))return void setTimeout(function(){return c.default.alert("请勾选同意《用户使用协议》","")});var l=this.refs.agreementField.isChecked(C.AGREEMENT_TYPE.PASSWORD),d={username:this.refs[r.login_type+"input0"].getValue(),password:this.refs[r.login_type+"input2"].getValue()},p={username:this.refs[r.login_type+"input0"].getValue()};if(d.account=d.username,!new RegExp(r.username_regex).test(d.account))return void setTimeout(function(){return c.default.alert("请输入正确的账号")});if(!new RegExp(r.password_regex).test(d.password))return void setTimeout(function(){return c.default.alert("请输入正确的密码")});if(r.username1_desc&&(d.username1=this.refs[r.login_type+"input1"].getValue(),d.account=d.account+","+d.username1,!new RegExp(r.username1_regex).test(d.username1)))return void setTimeout(function(){return c.default.alert("请输入正确的卡号")});this.setState({login:!0});var m=this.props.cardType||u.qsParams.cardType;(0,o.submitTaskHelper)({taskType:"bank",taskSubType:s,loginTarget:m,loginType:r.login_type,username:d.account,password:d.password,rmbPwd:l?"1":"0"}).then(function(e){if(t.setState({login:!1}),e.body.task_id){c.default.refreshStatus("2","创建任务成功"),c.default.mxSaveTaskId(e.body.task_id);var n={taskId:e.body.task_id,bankId:s,loginTarget:m,loginType:r.login_type,taskType:"bank",loginParam:{username:d.account}};a(n)}}).catch(function(a){t.setState({login:!1}),c.default.refreshStatus("-3","服务异常，创建任务失败"),e(),t.handleError(a)})},getLastLogin:function(){var e=this.props.cardType||u.qsParams.cardType,t=this.props,a=t.pageConfig,n=t.bankId;return i.default.get("bank",n,e,a.login_type)},showPwd:function(){"text"==this.state.Type?this.setState({Type:"password",bgImg:"url("+a(20)+")"}):this.setState({Type:"text",bgImg:"url("+a(37)+")"})},handleError:function(e){var t=e&&e.body&&e.body.detail||"网络异常，请稍后再试!\n"+e;c.default.alert(t)},onPressImg:function(e){try{"function"==typeof window.mxPostMessage&&window.mxPostMessage(JSON.stringify({type:"mxSaveImg",value:e,succText:"保存成功，请点击扫一扫进行扫码",failText:"保存失败，请截图后进行扫码"}))}catch(e){}},renderInstructionView:function(){var e=this.props.bankId;return c.default.Device.Mobile?s.default.createElement("div",{className:"instruction-view"},s.default.createElement("div",{className:"instruction-view-card"},s.default.createElement("div",{className:"text1"},"第一步"),s.default.createElement("div",{className:"text2"},"长按或截图保存二维码",s.default.createElement("br",null),"点击扫一扫跳转APP"),s.default.createElement("img",{src:a(266)})),c.default.Device.Wechat?s.default.createElement("div",{className:"instruction-view-card"},s.default.createElement("div",{className:"text1"},"第二步"),s.default.createElement("div",{className:"text2"},"打开APP的扫一扫功能"),s.default.createElement("img",{src:u.BankApplink[e]?u.BankApplink[e].instructionImg:""})):s.default.createElement("div",{className:"instruction-view-card"},s.default.createElement("div",{className:"text1"},"第二步"),s.default.createElement("div",{className:"text2"},"打开APP的扫一扫功能"),s.default.createElement("img",{src:u.BankApplink[e]?u.BankApplink[e].instructionImg:""})),s.default.createElement("div",{className:"instruction-view-card"},s.default.createElement("div",{className:"text1"},"第三步"),s.default.createElement("div",{className:"text2"},"打开相册，扫描二维码"),s.default.createElement("img",{src:a(265)}))):s.default.createElement("div",{className:"instruction-view",style:{width:"100%"}},s.default.createElement("div",{className:"instruction-view-card",style:{width:"100%"}},s.default.createElement("div",{className:"text2"},"打开APP的扫一扫功能进行扫描"),s.default.createElement("img",{src:u.BankApplink[e]?u.BankApplink[e].instructionImg:""})))},createBankQrcodeTask:function(){var e=this,t=this.onSubmitTaskDone,a=this.props,n=(a.pageConfig,a.bankId),r=(a.onImport,a.changeQRcodeTimeout);this.state.loginTypeIndex,r();var s=void 0,l=this.props.cardType||u.qsParams.cardType;this.setState({gettingCode:!0}),(0,o.submitTaskHelper)({taskType:"bank",taskSubType:n,loginTarget:l,loginType:"QRCODE",username:"QRCODE",password:"QRCODE"}).then(function(e){if(s=e,e.body.task_id){var a={taskId:e.body.task_id,bankId:n,loginTarget:l,taskType:"bank",loginType:"qrcode"};storage.setItem(n+"-"+l+"-bankQRCodeTask",JSON.stringify(a)),t(a)}}).catch(function(t){var a=t&&t.response&&t.response.body||{};a.errors&&a.errors[0]&&(10220011===a.errors[0].code||10220012===a.errors[0].code)?(c.default.refreshStatus("-2",a.errors[0].message),e.showUnsupport(a.errors[0].message)):(c.default.refreshStatus("-3","服务异常，创建二维码任务失败"),e.handleError(t,a.detail))})},selectLoginType:function(e){this.setState({loginTypeIndex:e})},onSubmitTaskDone:function(e){return e.importResult={},this.props.onSubmitTaskDone(e),!0},tryGetCachedValue:function(e){var t=this.getLastLogin();return t&&t.loginParam&&t.loginParam[e]?t.loginParam[e]:""},wrapValidator:function(e){return function(t){return""===t||new RegExp(e).test(t)}}});P.contextTypes={history:r.PropTypes.history},t.default=P,e.exports=t.default}).call(this)}finally{}},265:function(e,t,a){e.exports=a.p+"assets/c074743e.bankScanCode.jpg"},266:function(e,t,a){e.exports=a.p+"assets/35417770.zhiyinStep1.jpg"}});