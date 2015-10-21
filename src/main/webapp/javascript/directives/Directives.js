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

app.directive('lastElementInRepeat', ['$timeout', function ($timeout) {
        return {
            restrict: 'A',
            link: function (scope, element, attr) {
                if (scope.$last === true) {
                    $timeout(function(){
                        jQuery('.fullwidthbanner').revolution(
                            {
                                delay: 7000,
                                startwidth: 1080,
                                startheight: 500,
                                hideThumbs: 10
                            });
                        jQuery("body").fitVids();
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
                }

            }
        }
    }]
);