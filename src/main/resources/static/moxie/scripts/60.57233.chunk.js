webpackJsonp([60],{810:function(e,t,a){try{(function(){"use strict";function t(e){return e&&e.__esModule?e:{default:e}}function n(e,t){if(!(e instanceof t))throw new TypeError("Cannot call a class as a function")}function r(e,t){if("function"!=typeof t&&null!==t)throw new TypeError("Super expression must either be null or a function, not "+typeof t);e.prototype=Object.create(t&&t.prototype,{constructor:{value:e,enumerable:!1,writable:!0,configurable:!0}}),t&&(Object.setPrototypeOf?Object.setPrototypeOf(e,t):e.__proto__=t)}var i=function(){function e(e,t){for(var a=0;a<t.length;a++){var n=t[a];n.enumerable=n.enumerable||!1,n.configurable=!0,"value"in n&&(n.writable=!0),Object.defineProperty(e,n.key,n)}}return function(t,a,n){return a&&e(t.prototype,a),n&&e(t,n),t}}(),l=function(e,t,a){for(var n=!0;n;){var r=e,i=t,l=a;n=!1,null===r&&(r=Function.prototype);var o=Object.getOwnPropertyDescriptor(r,i);if(void 0!==o){if("value"in o)return o.value;var s=o.get;if(void 0===s)return;return s.call(l)}var u=Object.getPrototypeOf(r);if(null===u)return;e=u,t=i,a=l,n=!0,o=u=void 0}},o=a(2),s=t(o),u=a(16),c=a(4),f=t(c),d=a(6),m=t(d),p=a(7),h=(t(p),a(18)),v=t(h),y=a(11),g=t(y),b=a(1),E=a(8),N=(t(E),a(9)),P=a(10),w=t(P),x=a(39),k=a(12),I=t(k),O=null,T=null,q=function(e){function t(e,t){n(this,a),l(Object.getPrototypeOf(a.prototype),"constructor",this).call(this,e,t),this.renderNavi=this.renderNavi.bind(this),this.handleNext=this.handleNext.bind(this),this.state={fail:!1,configList:null}}r(t,e),i(t,[{key:"componentDidMount",value:function(){var e=this;O?this.setState({configList:O}):T=(0,N.fetchCategoryList)().then(function(t){O=t.body,e.setState({configList:t.body})}).catch(function(e){e&&e.body&&e.body.detail?alert(e.body.detail):alert("网络异常，请稍后再试！"+e)});var t=b.qsParams.mainTitle&&void 0!=b.qsParams.mainTitle?b.qsParams.mainTitle:"魔蝎数据认证";f.default.refreshTitle(t),b.qsParams.icoUrl&&"undefined"!=b.qsParams.icoUrl&&(document.getElementById("icoImg").href=b.qsParams.icoUrl)}},{key:"componentWillUnmount",value:function(){T&&T.cancel()}},{key:"render",value:function(){if(!this.state.configList)return s.default.createElement("div",{className:"centered"},s.default.createElement(g.default,{size:"44",color:"#999"}));var e=this.renderNavi,t=b.qsParams.mainTitle&&void 0!=b.qsParams.mainTitle?b.qsParams.mainTitle:"魔蝎数据认证",a=e()||s.default.createElement("div",{className:"centered"},s.default.createElement(g.default,{size:"44",color:"#999"}));return this.state.fail&&(a=s.default.createElement("div",{className:"centered"},"网络异常,请稍后再试")),s.default.createElement("div",{className:"mx-view bank-list-page"},"NO"==b.qsParams.showTitleBar||0==b.qsParams.showTitleBar||f.default.Device.SDK?null:s.default.createElement("div",{style:{height:"NO"==b.qsParams.showTitleBar||f.default.Device.SDK?0:44}},s.default.createElement(m.default,{title:t})),s.default.createElement(v.default,{style:{background:"#f1f1f1",padding:"10px 0"}},a))}},{key:"renderNavi",value:function(){var e=(this.handleNext,this.renderNavList.bind(this));return s.default.createElement("div",{className:"navList"},I.default.userBaseInfoNecessary&&I.default.userBaseInfo?s.default.createElement(w.default,{onTap:function(){I.default.showBaseInfoView=!0}},s.default.createElement("div",{className:"personInfo-section"},s.default.createElement("div",{className:"personInfo-section-info"},s.default.createElement("div",{className:"personInfo-section-image"}),s.default.createElement("div",{className:"personInfo-section-name"},I.default.userBaseInfo.name),s.default.createElement("div",{className:"personInfo-section-right"})))):null,e())}},{key:"handleError",value:function(e){var t=arguments.length<=1||void 0===arguments[1]?"任务提交失败":arguments[1];try{t=e&&e.body&&e.body.detail||t}catch(e){}if("任务提交失败"==t){if(e&&e.message&&e.message.indexOf("the network is offline")!=-1)return void f.default.alert("网络开小差啦，请稍后再试");f.default.alert(t+"\n"+e)}else f.default.alert(t);this.setState({isStart:!1})}},{key:"handleNext",value:function(e){if("zhengxinapply"==e)return void(window.location.href="https://api.51datakey.com/h5/credit/index.html?apiKey="+I.default.apiKey+"&userId="+I.default.userId+"&token="+b.qsParams.token);var t=this.context.history.pushState;t({},"/"+e,b.qsParams)}},{key:"transformKey",value:function(e){switch(e){case"mail":return"email";default:return e}}},{key:"renderNavList",value:function(){var e=this;return s.default.createElement("div",null,this.state.configList.map(function(t,a){return t.content.length%2==1&&t.content.push({name:"",icon:"",route:""}),s.default.createElement("div",{key:a,className:"navList-div",style:{width:"100%",background:"#fff"}},s.default.createElement("h6",{style:{margin:0,padding:"10px 10px",fontSize:"16px"}},t.title),s.default.createElement("ul",{style:{width:"100%"}},t.content.map(function(t,a){return s.default.createElement("li",{style:{position:"relative",float:"left",height:"60px",width:"50%",borderBottom:"none",borderTop:"1px solid #f1f1f1"},key:a},s.default.createElement(w.default,{onTap:function(){return e.handleNext(t.route)}},s.default.createElement("div",null,s.default.createElement("i",{className:"icon i-navi-"+t.icon}),s.default.createElement("span",{style:{display:"block",lineHeight:"60px",marginLeft:"50px"},className:"tit"},t.name),"OFFLINE"==b.qsParams.authMode&&"succ"==storage.getItem(e.transformKey(t.icon)+"ImportStatus")?s.default.createElement("span",{className:"importSucc-icon"}):null,"OFFLINE"==b.qsParams.authMode&&"fail"==storage.getItem(e.transformKey(t.icon)+"ImportStatus")?s.default.createElement("span",{className:"importFailed-icon"}):null)))})))}))}}]);var a=t;return t=(0,x.observer)(t)||t}(s.default.Component);q.contextTypes={history:u.PropTypes.history},e.exports=q}).call(this)}finally{}}});