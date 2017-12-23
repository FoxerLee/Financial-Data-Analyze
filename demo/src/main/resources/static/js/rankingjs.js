/**
 * Created by chenmingxi on 2017/12/16.
 */
var app = angular.module('myApp', []);
app.controller('siteCtrl', function($scope, $http) {
    $http.get("http://localhost:8080/winner/all")
        .then(function (response) {
            var temp2 = angular.fromJson(response.data);
            //var temp3 = temp2[0].data[0].name;
            $scope.rankings = temp2;
        });
    $scope.form_query = function () {
        var code = document.getElementById("code").value;
        window.location.href = "detail.html?code=" + code;
    }
    $scope.check_out = function () {
        window.location.href = "login.html";
        $http.get("http://localhost:8080/user/logout");
    }
});
