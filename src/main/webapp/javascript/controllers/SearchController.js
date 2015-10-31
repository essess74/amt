app.controller('SearchCtrl', [
    '$scope', 'ArticlesService', '$routeParams', '$sce', '$location', '$anchorScroll', function ($scope, ArticlesService, $routeParams, $sce, $location, $anchorScroll) {
        $scope.keyWords = $routeParams.keyWords;

        $scope.trustSrc = function (url) {
            return $sce.trustAsResourceUrl(url);
        };
        $scope.fetchPage = function (page){
            $scope.articles = ArticlesService.getArticlesWithKeywords($scope.keyWords,page);
            $location.hash('content');
            $anchorScroll();
        };
        $scope.fetchPage(0);
        $scope.range = function(n) {
            var toReturn = [];
            for(var i = 1; i<= n;i++){
                toReturn.push(i);
            }
            return toReturn;
        };
    }]);
