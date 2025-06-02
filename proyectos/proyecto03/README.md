Integrantes del equipo:
    - Bensunsse Gonzalez Gael 
    - Malvaez Camacho Erick
    
Descripción de la estructura del proyecto:
    - Carta: En esta clase modelamos un objeto carta, con sus cinco caracteristicas, agregamos metodos para comparar nuestras cartas con otras y saber si cumplian o no la regla del juego, ademas de los tipicos get para obtener cada atributo de las cartas

    - Jugador: Aqui creamos todo lo que puede hacer el jugador y la computadora que igual juega, por ejemplo agregar  cartas, validar su secuencia de cartas, terminar la partida, mostrar su secuencia de cartas, como atributos de jugador solo tomamos tres, su nombre, sus puntos, y su baraja o lista de cartas

    - Lista: Es una lista ligada sencilla, solo tenemos la referencia al siguiente nodo, elegimos como estructura de datos principal para nuestro proyecto este tipo de lista por que creemos que es la que mejor se acomoda, por que no vamos a tener que estar buscando una carta en especifico para recuperarla o asi entonces por eso no decicidimos la doblemente ligada, nuestra lista puede hacer lo básico agregar, eleminiar, obtener elementos, y además le agregamos un par de funciones para el conteo de puntos, como saber su tamaño, si esta basia, y vaciarla

    - PickAPerro: En esta clase como tal representamos el juego, aqui tenemos nuestra baraja de cartas, la zona de juego (las cartas), los turnos entre el usuario y la compu; como metedos tenemos primero el constructor, crear y rebuelve el mazo, muestra el estado del juego, gestionan los turnos de cada jugador, procesan el fin de cada ronda y muestran el resultado. También se encarga de que todo este bien con las secuencias de cartas para guardar los puntos

    - Main: Es la clase para ejecutar el juego, solo crea un objeto de tipo PickAPerro y lo jugamos

Instrucciones para ejecutarlo:
    1. Despues de haber clonado el proyecto ir hasta el proyecto con:
        cd proyecto03
    2. Ya que estes en el proyecto compila los archivos con:
        javac *.java
    3. Corre el proyecto con:
        java Main 

    
Inconvenientes:
    Fue la primera vez que ambos utilizabamos github de forma colaborativa por asi decirlo, entonces chocaron muchas veces las cosas que uno asi con los cambios del otro, o las ramas que creamos y luego para incluirlas es un relago, pero en general nos supimos adaptar y trabajar en equipo, fue muy nutritivo el trabajar asi ya que es interesante ver y comparar las ideas tenemos, ademas de ir compartiendo y fortaleciendo conocimientos mutuamente

IDE:
    No se utilizaron, el trabajo se realizo utilizando VIM y NeoVIM
