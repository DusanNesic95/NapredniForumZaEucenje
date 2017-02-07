app.directive('materijalBlok', function(funkcije) { 
  return { 
    restrict: 'E', 
    scope: { 
      materijal: '=' 
    }, 
    templateUrl: '../directives/templates/materijalBlok.html',
    link: function(scope, elem, attrs) {
    	scope.svidjaMiSe = function(materijal) {
    		materijal.brojPreporukaPozitivno = materijal.brojPreporukaPozitivno + 1;
    		funkcije.izmenimaterijal(materijal);
    	}
    	scope.neSvidjaMiSe = function(materijal) {
    		materijal.brojPreporukaNegativno = materijal.brojPreporukaNegativno + 1;
    		funkcije.izmenimaterijal(materijal);
    	}
    }
  }; 
});