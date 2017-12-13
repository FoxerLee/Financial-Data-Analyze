<!--定义UserMgt Ajs模块，模块依赖ngRoute-->
var umService = angular.module('pathcontroller', ['ngRoute']);

<!--路由定义-->
umService.config(
    function ($routeProvider) {
        $routeProvider
    .when('/', {
            controller: ListController,
            templateUrl: '../home.html'
        })

    .when('/get/:id', {
            <!--定义绑定的控制器-->
            controller: GetController,
            <!--定义跳转的页面-->
            templateUrl: "../detail.html"
        })
            .otherwise({
                <!--其他情况，指定url跳转-->
                redirectTo: '/'
            });
    }
)


function ListController($scope, $http) {
    <!--获取本地json资源文件-->
    $http.get('../conf/user.json').success(function (data) {
        <!--浏览器console端口打印读取的数据-->
        console.log(data);
        $scope.users = data;
    });
}

<!--GetController控制器定义-->
function GetController($scope, $http, $routeParams) {
    var id = $routeParams.id;
    <!--获取本地json资源文件-->
    $http.get('../conf/user.json').success(function (data) {
        console.log(data);
        $scope.item = data[id];
    });
}

function newsController($scope, $http) {
    <!--获取本地json资源文件-->
    $http.get("http://192.168.0.126:8080/news/user?code=601888").success(function (data) {
        <!--浏览器console端口打印读取的数据-->
        console.log(data);
        $scope.news = data;
    });
}