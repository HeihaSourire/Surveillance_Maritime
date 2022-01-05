# Projet Entreprise : Préparation mission maritime

Les missions maritimes ont besoin de donnés météorologiques. Ces donnés peuvent être retouvés dans des serveurs "Open Data".
Ce projet vise à :

1. Juger les donnés nécessaires pour le bon déroulement de ce type de mission.
2. Étudier les possibilités de serveurs pour récolter les données.
3. Programmer une interface qui donne accès aux données à l'utilisateur final.

Pour requêter les données, nous avons fait appel à différentes REST API.
Les données récupérées dans les serveurs ont été les suivantes :
## Vent
Pour obtenir ces données, nous avons utilisé le serveur Windy, qui donne de très bonnes données par rapport au vent sur mer.
## Température
Les données de température sont aussi importantes. Nous avons fait appel à OpenWeatherMap.
## METAR et TAF
Ces données aéroportuaires de métérologie sont accessibles grâce au site officiel du NOAA.
## AIS
Pour la mission maritime, les données sur les bateaux sont aussi pertinentes. Nous avons utilisé l'API de Marine Traffic pour obtenir l'information sur les bateaux dans un zone à préciser.
