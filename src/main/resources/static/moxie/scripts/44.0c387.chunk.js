webpackJsonp([44],{238:function(e,t,a){try{(function(){"use strict";function r(e){return e&&e.__esModule?e:{default:e}}Object.defineProperty(t,"__esModule",{value:!0});var n=function(){function e(e,t){var a=[],r=!0,n=!1,o=void 0;try{for(var l,s=e[Symbol.iterator]();!(r=(l=s.next()).done)&&(a.push(l.value),!t||a.length!==t);r=!0);}catch(e){n=!0,o=e}finally{try{!r&&s.return&&s.return()}finally{if(n)throw o}}return a}return function(t,a){if(Array.isArray(t))return t;if(Symbol.iterator in Object(t))return e(t,a);throw new TypeError("Invalid attempt to destructure non-iterable instance")}}(),o=a(2),l=r(o),s=a(1),u=a(9),i=a(8),d=(r(i),a(4)),f=r(d),c=a(15),m=r(c),p=a(13),h=r(p),y=a(5),g=r(y),v=a(11),b=(r(v),a(18)),w=r(b),E=a(6),P=(r(E),a(7)),k=(r(P),l.default.createClass({displayName:"ImportForm",getInitialState:function(){return{phoneInfo:null,unsupport:!1,showUnsupport:!1,isStart:!1,defaultUsername:""}},componentDidMount:function(){},componentWillUnmount:function(){this.unmount=!0},render:function(){var e=this.handleImport,t=this.handleProtocol,a=this.state,r=a.unsupport,n=a.showUnsupport,o=a.isStart,u=(a.defaultUsername,void 0!=s.qsParams.agreementEntryText?s.qsParams.agreementEntryText:"同意《用户使用协议》"),i=m.default.get("alipay",0,0,0),d="";i&&i.loginParam&&(d=i.loginParam.phone);var f=n?l.default.createElement("div",{className:"carrier-unsupport"},l.default.createElement("i",null),l.default.createElement("p",null,r)):l.default.createElement("div",null,l.default.createElement("div",{className:"input-item"},l.default.createElement(h.default,{type:"text",ref:"username",id:"zxUsername",placeholder:"请\b输入支付宝账号/邮箱/手机号",label:"账户名",defaultValue:d})),l.default.createElement("div",{className:"input-item"},l.default.createElement(h.default,{type:"password",ref:"password",id:"zxPassword",placeholder:"请输入登录密码",label:"密码"})),l.default.createElement("div",{style:{display:"NO"==s.qsParams.showAgreement||0==s.qsParams.showAgreement?"none":"block"},className:"protocol"},l.default.createElement("input",{id:"protocol",ref:"protocol",type:"checkbox",defaultChecked:!0}),l.default.createElement("label",{htmlFor:"protocol"},l.default.createElement("span",{style:{background:s.qsParams.themeColor?"#"+s.qsParams.themeColor:"rgb(126, 195, 235)"}})),l.default.createElement("a",{onClick:t},u)),s.qsParams.tenantAgreementUrl&&"undefined"!=s.qsParams.tenantAgreementUrl?l.default.createElement("div",{className:"protocol"},l.default.createElement("input",{id:"tanent_protocol",ref:"tanent_protocol",type:"checkbox",defaultChecked:!0}),l.default.createElement("label",{htmlFor:"tanent_protocol"},l.default.createElement("span",{style:{background:s.qsParams.themeColor?"#"+s.qsParams.themeColor:"rgb(126, 195, 235)"}})),l.default.createElement("a",{onClick:this.handleTanentProtocol},s.qsParams.tenantAgreementEntryText||"同意《用户使用协议》")):null,l.default.createElement("div",{className:"page-wrapper"},l.default.createElement(g.default,{types:"full",onTap:e,disable:o,state:o,getState:function(e){switch(e){case!1:return"提交";case!0:return"登录中...";default:return"提交"}}})));return l.default.createElement("div",null,l.default.createElement(w.default,null,f))},handleTanentProtocol:function(){var e=s.qsParams.tenantAgreementUrl&&"undefined"!=s.qsParams.tenantAgreementUrl?s.qsParams.tenantAgreementUrl:"";f.default.openWebView("用户使用协议",e,"","agreement")},handleImport:function(){var e=this,t=this.props.onSubmitTaskDone,a=(this.state.phoneInfo,this.refs.username.getValue()),r=this.refs.password.getValue();if(!a)return void setTimeout(function(){return f.default.alert("请输入正确的登录名","")});if(!r)return void setTimeout(function(){return f.default.alert("请输入正确的登录密码","")});if(!this.refs.protocol.checked)return void setTimeout(function(){return f.default.alert("请勾选同意《用户使用协议》","")});if(this.refs.tanent_protocol&&!this.refs.tanent_protocol.checked)return void setTimeout(function(){return f.default.alert("请勾选同意《用户使用协议》","")});if(this.refs.tanent_protocol&&!this.refs.tanent_protocol.checked)return void setTimeout(function(){return f.default.alert("请勾选同意《用户使用协议》","")});this.setState({isStart:!0});var n=void 0;(0,u.submitTaskHelper)({taskType:"alipay",loginType:"pwd",username:a,password:r}).then(function(r){if(n=r,r.body.task_id){e.setState({isStart:!1}),f.default.refreshStatus("2","创建任务成功"),f.default.mxSaveTaskId(r.body.task_id);var o={taskId:r.body.task_id,username:a,mappingId:r.body.mapping_id,taskType:"alipay",loginType:"pwd",loginParam:{phone:a}};t(o)}}).catch(function(t){e.setState({isStart:!1});var a=t&&t.response&&t.response.body||{};a.errors&&a.errors[0]&&(10220011===a.errors[0].code||10220012===a.errors[0].code)?(f.default.refreshStatus("-2",a.errors[0].message),e.showUnsupport(a.errors[0].message)):(f.default.refreshStatus("-3","服务异常，创建任务失败"),e.handleError(t,a.detail))})},handleError:function(e){var t=arguments.length<=1||void 0===arguments[1]?"任务提交失败":arguments[1];try{t=e&&e.body&&e.body.detail||t}catch(e){}if("任务提交失败"==t){if(e&&e.message&&e.message.indexOf("the network is offline")!=-1)return void f.default.alert("网络开小差啦，请稍后再试");f.default.alert(t+"\n"+e)}else f.default.alert(t);this.setState({isStart:!1})},handleProtocol:function(){var e=f.default.Device.SDK?0:s.qsParams.showTitleBar,t=s.qsParams.themeColor,a=s.qsParams.agreementUrl&&"undefined"!=s.qsParams.agreementUrl?s.qsParams.agreementUrl:"https://api.51datakey.com/h5/agreement.html?showTitleBar="+e+"&themeColor="+t;f.default.openWebView("用户使用协议",a,"","agreement")},handleForgetSMS:function(e){var t=n(e,3),a=t[0],r=t[1],o=t[2];f.default.confirm(r,"","取消,发送",function(e){2==e&&((0,s.isIOS)()?window.location.href="sms:"+o+"&body="+a:window.location.href="sms:"+o+"?body="+a)})},showUnsupport:function(e){this.setState({unsupport:e||this.state.unsupport,showUnsupport:!0})}}));t.default=k,e.exports=t.default}).call(this)}finally{}}});