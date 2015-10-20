var app = angular.module('AmtApp', ['ngResource', 'ngSanitize', 'ngRoute', 'pascalprecht.translate']);


app.config(function ($translateProvider) {
    $translateProvider.useStaticFilesLoader({
        prefix: 'languages/',
        suffix: '.json'
    });
    $translateProvider.preferredLanguage('arAR');
});

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

/* Category service */
app.service('ArticlesService', ['$resource', function ($resource) {
    this.getAllArticles = function () {
        return $resource('articles', {}, {
            query: {method: 'GET', params: {}, isArray: true}
        }).query();
    };
}]);
app.service('SlidesService', ['$resource', function ($resource) {
    this.getAllSlides = function () {
        return $resource('slide', {}, {
            query: {method: 'GET', params: {}, isArray: true}
        }).query();
    };
}]);

app.controller('ArticlesCtrl', ['$scope', 'ArticlesService', 'SlidesService', '$sce', '$timeout', function ($scope, ArticlesService, SlidesService, $sce, $timeout) {
    $scope.slides = SlidesService.getAllSlides();
    $scope.articles = ArticlesService.getAllArticles();
    $scope.trustSrc = function (url) {
        return $sce.trustAsResourceUrl(url);
    }
    $timeout(function () {
        jQuery(document).ready(function () {
            jQuery('.fullwidthbanner').revolution(
                {
                    delay: 7000,
                    startwidth: 1080,
                    startheight: 500,
                    hideThumbs: 10
                });
        });
        jQuery(document).ready(function(){
            jQuery("body").fitVids();
        });
        jQuery(document).ready(function ($) {
            var rsi = $('#slider-in-laptop').royalSlider({
                autoHeight: false,
                arrowsNav: false,
                fadeinLoadedSlide: false,
                controlNavigationSpacing: 0,
                controlNavigation: 'bullets',
                imageScaleMode: 'fill',
                imageAlignCenter: true,
                loop: false,
                loopRewind: false,
                numImagesToPreload: 6,
                keyboardNavEnabled: true,
                autoScaleSlider: true,
                autoScaleSliderWidth: 486,
                autoScaleSliderHeight: 315,

                /* size of all images http://help.dimsemenov.com/kb/royalslider-jquery-plugin-faq/adding-width-and-height-properties-to-images */
                imgWidth: 792,
                imgHeight: 479

            }).data('royalSlider');
            $('#slider-next').click(function () {
                rsi.next();
            });
            $('#slider-prev').click(function () {
                rsi.prev();
            });
        });
    });
}]);
