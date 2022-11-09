### Parcial Taller Programación 3

Grupo 6 (Equipo Consorcios Inteligentes) :
------------------------------------------

Arbert, Gastón
Carbone, Walter
Ledesma, Oriana
Lois, Agustina
Srur, Sofía

Consignas :
-----------
El parcial práctico se desarrolla de forma grupal siguiente los grupos de trabajo de Proyecto Final o los de esta materia.
La consigna es desarrollar una Aplicación Móvil en Android con el Lenguaje Kotlin, con las especificaciones definidas en este documento.
El diseño, colores, tipografías e imágenes lo dejamos a libre elección del grupo. Es importante la utilización de los componentes, controles y
funcionalidades vistas en clase.

Diseño de la aplicación:
------------------------
https://excalidraw.com/#json=_Dtdk1N20Gf8zNvD7uWMr,MC0CjUKm3RpjlqiTlCtkAA

API utilizada :
---------------
https://rickandmortyapi.com/documentation/#get-all-characters

Detalle de lo desarrollado :
----------------------------
Para la app se desarrolló 1 Activity y 5 Fragments.

* Fragments
  CharacterDetailFragment
  FavoritesFragment
  HomeFragment
  LoginFragment
  SettingsFragment

* Clase API
  RickAndMortyService

* Clase Personajes (atributos)
  CharacterData

* Activity
  MainActivity

* Resources
  Layout
  activity_main --> activity de la app
  card_item
  character_detail
  fragment_favorites  --> fragmento de personajes favoritos
  fragment_home --Z fragmento del home
  fragment_login --> fragmento con los campos para hacer el login
  fragment_settings --> fragmento con los datos para el setting del user de la app
  
  # Uso de la aplicación
  
 - Inicia con la vista del Login donde se cargaran los datos del usuario:
  
  ![](https://i.postimg.cc/NFPt52Rm/Whats-App-Image-2022-11-08-at-8-02-41-PM.jpg)
  
  Luego se mostrará el listado de personajes de Rick and Morty
    - Teniendo la opción de buscar por nombre a los personajes.
  ![](https://i.postimg.cc/nLzSdSmK/Whats-App-Image-2022-11-08-at-8-32-06-PM.jpg)
  
  Haciendo click en una de las cartas accedemos al detalle del personaje  

  
  ![](https://i.postimg.cc/kXdzvcgG/Whats-App-Image-2022-11-08-at-7-56-07-PM-3.jpg)

   - Teniendo la opción de sumar a la lista de favoritos, a un personaje, haciendo click en el botón verde con simbolo de " + "
  -  De esta forma accedemos al listado de favoritos.
  
  ![](https://i.postimg.cc/Cx5ZPbvT/Whats-App-Image-2022-11-08-at-7-56-07-PM-2.jpg)

- Podemos modificar la vista de la aplicación desde los settings del navegador 
![](https://i.postimg.cc/vmfxdb5G/Whats-App-Image-2022-11-08-at-8-40-22-PM.jpg)

- Y activar el modo nocturno 
Dandote la opción de verlo de esta forma 
Ejemplos: 
Lista de favoritos
![](https://i.postimg.cc/FKx5V4CB/Imagen-de-Whats-App-2022-11-08-a-las-21-56-06.jpg)
Detalle de personaje 
![](https://i.postimg.cc/K8ZdcV87/detalle.jpg)
   
