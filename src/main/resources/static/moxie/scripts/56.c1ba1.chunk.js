webpackJsonp([56],{228:function(e,t,a){try{(function(){"use strict";function l(e){return e&&e.__esModule?e:{default:e}}Object.defineProperty(t,"__esModule",{value:!0});var r=a(2),n=l(r),s=a(1),o=a(9),i=a(8),d=l(i),u=a(4),f=l(u),c=a(15),m=l(c),p=a(10),h=l(p),g=a(13),y=l(g),v=a(5),E=l(v),b=a(18),T=l(b),S=a(6),I=l(S),N=a(7),k=l(N),w=a(41),x=l(w),P=n.default.createClass({displayName:"ImportForm",propTypes:{pageConfig:r.PropTypes.object.isRequired},getInitialState:function(){return{phoneInfo:null,isStart:!1,defaultPolicyNum:"",defaultIdNo:"",Type:"password",bgImg:"url("+a(20)+")",frontConf:this.props.frontConf}},getDefaultProps:function(){return{title:""}},componentDidMount:function(){},componentWillUnmount:function(){this.unmount=!0},render:function(){var e=(this.handleForget,this.handleImport),t=this.state,a=t.isStart,l=(t.defaultIdNo,t.defaultPolicyNum,this.props.title),r=this.props.pageConfig,o=n.default.createElement(k.default,{onTap:d.default.bind(this,null)},n.default.createElement("i",{className:"ion-chevron-left"})),i=(n.default.createElement(I.default,{title:l,left:o}),this.props.params.code||s.qsParams.code),u=[];u=r.fields;var f=[];f.push(n.default.createElement("div",{className:"centerImgDiv-lifeinsr"},n.default.createElement("div",{className:"centerImg-type3 i-"+i})));for(var c=0;c<u.length;c++)if("text"==u[c].type){var p="",g=m.default.get("lifeinsr",0,0,i);g&&g.loginParam&&(p=g.loginParam[u[c].code]),f.push(n.default.createElement("div",{key:u[c].code,className:"input-item"},n.default.createElement(y.default,{type:"text",ref:u[c].code,id:u[c].code,defaultValue:p,placeholder:"请输入"+u[c].name,label:u[c].name}),n.default.createElement("div",{onClick:this.clearValue.bind(this,"#"+u[c].code),className:"tex_box name"},n.default.createElement("span",{className:"textt"}))))}else if("password"==u[c].type)f.push(n.default.createElement("div",{key:u[c].code,className:"input-item"},n.default.createElement(y.default,{type:this.state.Type,ref:u[c].code,id:u[c].code,placeholder:"请输入"+u[c].name,label:u[c].name}),n.default.createElement(h.default,{onTap:this.showPwd},n.default.createElement("div",{className:"tex_box name"},n.default.createElement("span",{style:{backgroundImage:this.state.bgImg},className:"password password_show"})))));else if("select"==u[c].type){var p="",g=m.default.get("lifeinsr",0,0,i);g&&g.loginParam&&(p=g.loginParam.idno);for(var v=u[c].name.split(","),b=u[c].value.split(","),S=[],N=0;N<v.length;N++)S.push(n.default.createElement("option",{value:b[N]},v[N]));var w=n.default.createElement("select",{defaultValue:b[0],id:"policynumSelect"},S);f.push(n.default.createElement("div",{key:u[c].code,className:"input-item"},n.default.createElement(y.default,{type:"text",ref:u[c].code,id:u[c].code,defaultValue:p,placeholder:"请输入"+u[c].name.replace(",","或"),label:w}),n.default.createElement("div",{onClick:this.clearValue.bind(this,"#"+u[c].code),className:"tex_box name"},n.default.createElement("span",{className:"textt"}))))}var P=n.default.createElement("div",null,n.default.createElement("div",{className:"form common-form"},f),n.default.createElement(x.default,{ref:"agreementField",uid:r.login_type,frontConf:this.state.frontConf}),n.default.createElement("div",{className:"page-wrapper"},n.default.createElement(h.default,{onTap:e},n.default.createElement(E.default,{types:"full",onTap:function(){},disable:a,state:a,getState:function(e){switch(e){case!1:return"提交";case!0:return"登录中...";default:return"提交"}}}))));return n.default.createElement("div",null,n.default.createElement(T.default,null,P))},clearValue:function(e){document.querySelector(e).parentNode.querySelector("input").value=""},handleImport:function(){var e=this;if(!this.refs.agreementField.isChecked(w.AGREEMENT_TYPE.MOXIE))return void setTimeout(function(){return f.default.alert("请勾选同意《用户使用协议》","")});if(!this.refs.agreementField.isChecked(w.AGREEMENT_TYPE.TENANT))return void setTimeout(function(){return f.default.alert("请勾选同意《用户使用协议》","")});for(var t=this.props,a=t.pageConfig,l=t.onSubmitTaskDone,r={},n=a.fields,i=a,d=i.fields.reduce(function(t,a){if("select"==a.type){var l=e.refs[""+a.code].getValue();0==a.required&&""==l||(t[""+a.code]=l)}else{var l=e.refs[""+a.code].getValue();0==a.required&&""==l||(t[""+a.code]=l)}return t},{}),u=0;u<n.length;u++)if(!this.refs[n[u].code].getValue())return setTimeout(function(){return f.default.alert("请填写完整的信息")}),!1;this.state.phoneInfo,this.setState({isStart:!0});var c="1";null!=document.getElementById("policynumSelect")&&(c=document.getElementById("policynumSelect").value);var m=this.props.params.code||s.qsParams.code,p=void 0;r.policynum=d.username,r.idno=d.password,r.name=d.name,r.taskSubType=m,r.loginType=c,r.loginTarget=a.login_type,r.taskType="lifeinsr",r.username=r.policynum,(0,o.submitTaskHelper)(r).then(function(t){if(p=t,t.body&&t.body.task_id){e.setState({isStart:!1}),f.default.refreshStatus("2","创建任务成功"),f.default.mxSaveTaskId(t.body.task_id);var a={taskId:t.body.task_id,mappingId:t.body.mapping_id,bankId:e.props.params.code,username:d.password,taskType:"lifeinsr",taskSubType:m,loginParam:{policynum:d.username,idno:d.password}};l(a)}}).catch(function(t){console.log(t),e.setState({isStart:!1});var a=t&&t.response&&t.response.body||{};a.errors&&a.errors[0]&&(10220011===a.errors[0].code||10220012===a.errors[0].code)?(f.default.refreshStatus("-2",a.errors[0].message),e.showUnsupport(a.errors[0].message)):(f.default.refreshStatus("-3","服务异常，创建任务失败"),e.handleError(t,a.detail))})},handleError:function(e){var t=arguments.length<=1||void 0===arguments[1]?"任务提交失败":arguments[1];try{t=e&&e.body&&e.body.detail||t}catch(e){}if("任务提交失败"==t){if(e&&e.message&&e.message.indexOf("the network is offline")!=-1)return void f.default.alert("网络开小差啦，请稍后再试");f.default.alert(t+"\n"+e)}else f.default.alert(t);this.setState({isStart:!1})},showPwd:function(){"text"==this.state.Type?this.setState({Type:"password",bgImg:"url("+a(20)+")"}):this.setState({Type:"text",bgImg:"url("+a(37)+")"})},autoImport:function(){this.props.auto&&this.handleImport()}});t.default=P,e.exports=t.default}).call(this)}finally{}}});