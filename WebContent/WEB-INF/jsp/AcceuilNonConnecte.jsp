<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<title>Accueil Non Connecté</title>
	</head>
	<body>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  			<a class="navbar-brand" href="<%=request.getContextPath()%>/ServletAcceuilNonConnecte">ENI-Encheres</a>
  			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    			<span class="navbar-toggler-icon"></span>
  			</button>
  			<div class="collapse navbar-collapse" id="navbarText">
    			<ul class="navbar-nav mr-auto">
     				<li class="nav-item active">
        				<a class="nav-link" href="<%=request.getContextPath()%>/CreationCompte">S'inscrire  <span class="sr-only">(current)</span></a>
      				</li>
      				<li class="nav-item">
        				<a class="nav-link" href="<%=request.getContextPath()%>/ServletConnection">Se connecter</a>
      				</li>
    			</ul>
    			<span class="navbar-text">
      			Bienvenue sur le site enchère 
    			</span>
  			</div>
		</nav>
		<h1 class="text-center">Liste des enchères</h1>
		<br>
		<br>
		<div class="col-auto">
			<form class="row g-3 justify">
				<div class="col-md-5">
					<label class="col-md-5 row" for="site-search" >Filtres :</label><br>
					<div class="plaintext col-auto">
						<input class="form-control row" placeholder="Le nom de l'article contient" type="search" id="site-search" name="recherche" aria-label="Le nom de l'article contient">
					</div>
					<div class="col-md-5">
						<button class="col-mb-5 btn btn-primary mb-3 row">Rechercher</button>
					</div>
				</div>
			</form>	
		</div>
		<br>
		<div class="col-auto">
			<label for="Selection-categorie">Catégorie :</label>
			<select class="form-select" name="Categorie" id="Selection-categorie">
				<option value="Toutes">Toutes </option>
				<option value="Informatique">Informatique </option>
				<option value="Ameublement">Ameublement </option>
				<option value="Vêtement">Vêtement </option>
				<option value="Sport&Loisirs">Sport et Loisirs </option>
			</select>
		</div>
		<br>
		<br>
		<div class="container-fluid">
			<div class="row justify">
				<div class="col-6">
					<img src="../WebContent/images/casqueTNBnoir.jpg"	alt="Exemple de produit - casque audio">
					<div>
						<h4>CASQUE AUDIO</h4>
						<p> Prix : tbd </p>
						<p> Fin de l'enchère : JJ/MM/AAAA </p>
						<p> Vendeur : Nom du vendeur </p>
					</div>
				</div>
				<br>
				<div class="col-6">
					<img src="#"	alt="Exemple de produit - #">
					<div>
						<h4>PIOU PIOU</h4>
						<p> Prix : tbd </p>
						<p> Fin de l'enchère : JJ/MM/AAAA </p>
						<p> Vendeur : Nom du vendeur </p>
					</div>
				</div>
			</div>	
		</div>	
		<footer class="text-center"></footer>
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</body>
</html>