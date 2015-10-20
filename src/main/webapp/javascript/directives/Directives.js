app.directive('cTopBar', function () {
    return {
        restrict: 'E',
        templateUrl: 'component/top-bar.html'
    };
});

app.directive('cMainMenu', function () {
    return {
        restrict: 'E',
        templateUrl: 'component/main-menu.html'
    };
});

app.directive('cIndex', function () {
    return {
        restrict: 'E',
        templateUrl: 'component/index.html'
    };
});

app.directive('cFooter', function () {
    return {
        restrict: 'E',
        templateUrl: 'component/footer.html'
    };
});

app.directive('cCopyright', function () {
    return {
        restrict: 'E',
        templateUrl: 'component/copyright.html'
    };
});