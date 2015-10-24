app.controller('ArticleCtrl', [
    '$scope', 'ArticlesService', 'UserInfoService', '$routeParams', '$sce', '$location', '$anchorScroll', function ($scope, ArticlesService, UserInfoService, $routeParams, $sce, $location, $anchorScroll) {
        $scope.articleId = $routeParams.articleId;
        $scope.email = '';
        $scope.trustSrc = function (url) {
            return $sce.trustAsResourceUrl(url);
        }
        $scope.article = ArticlesService.getArticle($scope.articleId);

        $scope.saveEmail = function () {
            UserInfoService.save({'email':$scope.email},function(){
                $scope.email = '';
            });
        }
        $location.hash('content');

        // call $anchorScroll()
        $anchorScroll();
    }]);
