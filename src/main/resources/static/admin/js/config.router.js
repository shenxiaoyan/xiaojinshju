'use strict';

/**
 * Config for the router
 */
angular.module('app')
    .run(
        [          '$rootScope', '$state', '$stateParams',
            function ($rootScope,   $state,   $stateParams) {
                $rootScope.$state = $state;
                $rootScope.$stateParams = $stateParams;
            }
        ]
    )
    .config(
        [          '$stateProvider', '$urlRouterProvider', 'JQ_CONFIG', 'MODULE_CONFIG',
            function ($stateProvider,   $urlRouterProvider, JQ_CONFIG, MODULE_CONFIG) {
                $urlRouterProvider.otherwise('/dashboard');

                // 个人风控
                $stateProvider
                // dashboard
                    .state('dashboard', {
                        url: '/dashboard',
                        templateUrl: '../admin/tpl/app_dashboard_v1.html',
                        resolve:load(['../admin/js/controllers/chart.js'])
                    });


                // 工作台
                $stateProvider
                    // 公司管理
                    .state('companyManagement',{
                    url:'/companyManagement',
                    templateUrl:'../admin/layouts/workDesk/companyManagement.html'
                    })
                    // 供应商
                    .state('supplier',{
                        url:'/supplier',
                        templateUrl:'../admin/layouts/workDesk/supplier.html'
                    })
                    // // 企业认证
                    // .state('approve',{
                    //     url:'/approve',
                    //     templateUrl:'../fengkongweishi/pages/approve.html'
                    // })
                    //公司积分消费
                    // 供应商
                    .state('company',{
                        url:'/company',
                        templateUrl:'../admin/layouts/Report/company.html'
                    })
                    .state('company.page',{
                        url:'/{view_type}',
                        templateUrl:function ($stateParams) {
                            return 'entities/' + $stateParams.view_type + ".html";
                        }
                    })
                    //API
                    .state('API',{
                        url:'/API',
                        templateUrl:'../admin/layouts/workDesk/API.html',
                        controller: 'XeditableCtrl',
                        resolve: load(['xeditable','js/controllers/xeditable.js'])
                    })
                    // 充值记录
                    .state('rechargeRecord',{
                        url:'/rechargeRecord',
                        templateUrl:'../admin/layouts/workDesk/rechargeRecord.html',
                    })
                    //用户管理
                    .state('userDetail',{
                        url:'/userDetail',
                        templateUrl:'../admin/layouts/workDesk/userDetail.html',
                        controller: 'XeditableCtrl',
                        resolve: load(['xeditable','js/controllers/xeditable.js'])
                    })
                    .state('recharge',{
                        url:'/recharge',
                        templateUrl:'../admin/layouts/workDesk/recharge.html'
                    });
                function load(srcs, callback) {
                    return {
                        deps: ['$ocLazyLoad', '$q',
                            function( $ocLazyLoad, $q ){
                                var deferred = $q.defer();
                                var promise  = false;
                                srcs = angular.isArray(srcs) ? srcs : srcs.split(/\s+/);
                                if(!promise){
                                    promise = deferred.promise;
                                }
                                angular.forEach(srcs, function(src) {
                                    promise = promise.then( function(){
                                        if(JQ_CONFIG[src]){
                                            return $ocLazyLoad.load(JQ_CONFIG[src]);
                                        }
                                        angular.forEach(MODULE_CONFIG, function(module) {
                                            if( module.name == src){
                                                name = module.name;
                                            }else{
                                                name = src;
                                            }
                                        });
                                        return $ocLazyLoad.load(name);
                                    } );
                                });
                                deferred.resolve();
                                return callback ? promise.then(function(){ return callback(); }) : promise;
                            }]
                    }
                }


            }
        ]
    );
