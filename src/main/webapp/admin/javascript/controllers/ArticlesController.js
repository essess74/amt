app.controller('ArticleCtrl', ['$scope', 'ArticlesService', '$sce', function ($scope, ArticlesService, $sce) {
    $scope.articles = ArticlesService.getAllArticles();
    $scope.trustSrc = function (url) {
        return $sce.trustAsResourceUrl(url);
    };
}]);
app.controller('EditArticleCtrl', ['$scope', 'ArticlesService', '$sce', '$routeParams', function ($scope, ArticlesService, $sce, $routeParams) {
    $scope.articleId = $routeParams.articleId;
    $scope.article = ArticlesService.getArticle($scope.articleId);
    $scope.isImage = function () {
        return $scope.article.type == 'IMG';
    }
    $scope.isOther = function(){
        return $scope.article.type == 'OTH';
    }
    $scope.saveArticle = function () {
        ArticlesService.saveArticle($scope.article);
    }
    $scope.trustSrc = function (url) {
        return $sce.trustAsResourceUrl(url);
    };
    $scope.someHandlerMethod = function (a, b, c) {
        $scope.article.imageId = b;
    };
}]);
