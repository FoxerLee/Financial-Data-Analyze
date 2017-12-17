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

            // var top = "<tr>\n" +
            //     "\n" +
            //     "                    <th scope=\"col\" >股票代码</th>\n" +
            //     "                    <th scope=\"col\" >股票名称</th>\n" +
            //     "                    <th scope=\"col\" >收盘价（元）</th>\n" +
            //     "                    <th scope=\"col\" >涨幅</th>\n" +
            //     "                    <th scope=\"col\" >成交量（万股）</th>\n" +
            //     "                    <th scope=\"col\" >成交额（万元）</th>\n" +
            //     "                    <th scope=\"col\" >查看详情</th>\n" +
            //     "                </tr>\n" +
            //     "\n" +
            //     "                <tr>\n" +
            //     "                    <td colspan=\"7\" ></td>\n" +
            //     "                </tr>"
            //
            // var tabledata =
        });
});
