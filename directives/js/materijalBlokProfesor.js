app.directive('materijalBlokProfesor', function(funkcije) { 
  return { 
    restrict: 'E', 
    scope: { 
      materijal: '=' 
    }, 
    templateUrl: '../directives/templates/materijalBlokProfesor.html',
    link: function(scope, elem, attrs) {
    	scope.svidjaMiSe = function(materijal) {
    		materijal.brojPreporukaPozitivno = materijal.brojPreporukaPozitivno + 1;
    		funkcije.izmenimaterijal(materijal);
    	}
    	scope.neSvidjaMiSe = function(materijal) {
    		materijal.brojPreporukaNegativno = materijal.brojPreporukaNegativno + 1;
    		funkcije.izmenimaterijal(materijal);
    	}
        scope.obelezi = function(materijal) {
            materijal.materijalFleg = 1;
            funkcije.izmenimaterijal(materijal);
        }
    }
  }; 
});