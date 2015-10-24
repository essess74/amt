app.controller('SearchCtrl', [
    '$scope', 'ArticlesService', '$routeParams', '$sce', '$location', '$anchorScroll', function ($scope, ArticlesService, $routeParams, $sce, $location, $anchorScroll) {
        $scope.keyWords = $routeParams.keyWords;

        $scope.trustSrc = function (url) {
            return $sce.trustAsResourceUrl(url);
        }
        $scope.articles = ArticlesService.getArticlesWithKeywords($scope.keyWords);

        $scope.saveEmail = function () {
            UserInfoService.save({'email': $scope.email}, function () {
                $scope.email = '';
            });
        };
        $location.hash('content');
        $anchorScroll();
    }]);
