webpackJsonp([54],{229:function(e,t,a){try{(function(){"use strict";function r(e){return e&&e.__esModule?e:{default:e}}Object.defineProperty(t,"__esModule",{value:!0});var n=function(){function e(e,t){var a=[],r=!0,n=!1,l=void 0;try{for(var o,s=e[Symbol.iterator]();!(r=(o=s.next()).done)&&(a.push(o.value),!t||a.length!==t);r=!0);}catch(e){n=!0,l=e}finally{try{!r&&s.return&&s.return()}finally{if(n)throw l}}return a}return function(t,a){if(Array.isArray(t))return t;if(Symbol.iterator in Object(t))return e(t,a);throw new TypeError("Invalid attempt to destructure non-iterable instance")}}(),l=a(2),o=r(l),s=a(1),u=a(9),i=a(8),d=r(i),f=a(4),c=r(f),m=a(15),p=r(m),h=a(13),y=r(h),g=a(5),v=r(g),b=a(11),E=(r(b),a(18)),P=r(E),w=a(6),k=r(w),S=a(7),T=r(S),q="linkedin",U="领英",_=o.default.createClass({displayName:"ImportForm",propTypes:{setTaskStore:l.PropTypes.func},getInitialState:function(){return{phoneInfo:null,unsupport:!1,showUnsupport:!1,isStart:!1,defaultUsername:""}},componentDidMount:function(){},componentWillUnmount:function(){this.unmount=!0},render:function(){var e=this.handleImport,t=this.handleProtocol,a=this.state,r=a.unsupport,n=a.showUnsupport,l=a.isStart,u=(a.defaultUsername,p.default.get(q,0,0,0)),i="";u&&u.loginParam&&(i=u.loginParam.phone);var f=void 0!=s.qsParams.agreementEntryText?s.qsParams.agreementEntryText:"同意《用户使用协议》",c=o.default.createElement(T.default,{onTap:d.default.bind(this,null)},o.default.createElement("i",{className:"ion-chevron-left"})),m=("YES"==this.props.isWeb?o.default.createElement(k.default,{title:U,left:c}):null,n?o.default.createElement("div",{className:"carrier-unsupport"},o.default.createElement("i",null),o.default.createElement("p",null,r)):o.default.createElement("div",null,o.default.createElement("div",{className:"input-item"},o.default.createElement(y.default,{type:"text",ref:"username",id:"zxUsername",placeholder:"请输入领英用户名",label:"账户名",defaultValue:i})),o.default.createElement("div",{className:"input-item"},o.default.createElement(y.default,{type:"password",ref:"password",id:"zxPassword",placeholder:"请输入登录密码",label:"密码"})),o.default.createElement("div",{style:{display:"NO"==s.qsParams.showAgreement||0==s.qsParams.showAgreement?"none":"block"},className:"protocol"},o.default.createElement("input",{id:"protocol",ref:"protocol",type:"checkbox",defaultChecked:!0}),o.default.createElement("label",{htmlFor:"protocol"},o.default.createElement("span",{style:{background:s.qsParams.themeColor?"#"+s.qsParams.themeColor:"rgb(126, 195, 235)"}})),o.default.createElement("a",{onClick:t},f)),s.qsParams.tenantAgreementUrl&&"undefined"!=s.qsParams.tenantAgreementUrl?o.default.createElement("div",{className:"protocol"},o.default.createElement("input",{id:"tanent_protocol",ref:"tanent_protocol",type:"checkbox",defaultChecked:!0}),o.default.createElement("label",{htmlFor:"tanent_protocol"},o.default.createElement("span",{style:{background:s.qsParams.themeColor?"#"+s.qsParams.themeColor:"rgb(126, 195, 235)"}})),o.default.createElement("a",{onClick:this.handleTanentProtocol},s.qsParams.tenantAgreementEntryText||"同意《用户使用协议》")):null,o.default.createElement("div",{className:"page-wrapper"},o.default.createElement(v.default,{types:"full",onTap:e,disable:l,state:l,getState:function(e){switch(e){case!1:return"提交";case!0:return"登录中...";default:return"提交"}}}))));return o.default.createElement("div",null,o.default.createElement(P.default,null,m))},handleImport:function(){var e=this,t=this.props.onSubmitTaskDone,a=(this.state.phoneInfo,this.refs.username.getValue()),r=this.refs.password.getValue();if(!a)return void setTimeout(function(){return c.default.alert("请输入正确的用户名","")});if(!r)return void setTimeout(function(){return c.default.alert("请输入正确的登录密码","")});if(!this.refs.protocol.checked)return void setTimeout(function(){return c.default.alert("请勾选同意《用户使用协议》","")});if(this.refs.tanent_protocol&&!this.refs.tanent_protocol.checked)return void setTimeout(function(){return c.default.alert("请勾选同意《用户使用协议》","")});this.setState({isStart:!0});var n=void 0;(0,u.submitTaskHelper)({taskType:"linkedin",username:a,password:r}).then(function(r){if(n=r,r.body.task_id){e.setState({isStart:!1}),c.default.refreshStatus("2","创建任务成功"),c.default.mxSaveTaskId(r.body.task_id);var l={taskId:r.body.task_id,username:a,mappingId:r.body.mapping_id,taskType:q,loginParam:{phone:a}};t(l)}}).catch(function(t){e.setState({isStart:!1}),console.log(t);var a=t&&t.response&&t.response.body||{};a.errors&&a.errors[0]&&(10220011===a.errors[0].code||10220012===a.errors[0].code)?(c.default.refreshStatus("-2",a.errors[0].message),e.showUnsupport(a.errors[0].message)):(c.default.refreshStatus("-3","服务异常，创建任务失败"),e.handleError(t,a.detail))})},handleError:function(e){var t=arguments.length<=1||void 0===arguments[1]?"任务提交失败":arguments[1];try{t=e&&e.body&&e.body.detail||t}catch(e){}if("任务提交失败"==t){if(e&&e.message&&e.message.indexOf("the network is offline")!=-1)return void c.default.alert("网络开小差啦，请稍后再试");c.default.alert(t+"\n"+e)}else c.default.alert(t)},handleTanentProtocol:function(){var e=s.qsParams.tenantAgreementUrl&&"undefined"!=s.qsParams.tenantAgreementUrl?s.qsParams.tenantAgreementUrl:"";c.default.openWebView("用户使用协议",e,"","agreement")},handleProtocol:function(){var e=c.default.Device.SDK?0:s.qsParams.showTitleBar,t=s.qsParams.themeColor,a=s.qsParams.agreementUrl&&"undefined"!=s.qsParams.agreementUrl?s.qsParams.agreementUrl:"https://api.51datakey.com/h5/agreement.html?showTitleBar="+e+"&themeColor="+t;c.default.openWebView("用户使用协议",a,"","agreement")},handleForgetSMS:function(e){var t=n(e,3),a=t[0],r=t[1],l=t[2];c.default.confirm(r,"","取消,发送",function(e){2==e&&((0,s.isIOS)()?window.location.href="sms:"+l+"&body="+a:window.location.href="sms:"+l+"?body="+a)})},showUnsupport:function(e){this.setState({unsupport:e||this.state.unsupport,showUnsupport:!0})}});t.default=_,e.exports=t.default}).call(this)}finally{}}});