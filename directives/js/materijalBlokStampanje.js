app.directive('materijalBlokStampanje', function(funkcije) { 
  return { 
    restrict: 'E', 
    scope: { 
      materijal: '=' 
    }, 
    templateUrl: '../directives/templates/materijalBlokStampanje.html'
  }; 
});