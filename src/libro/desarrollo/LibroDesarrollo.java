/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package libro.desarrollo;

import java.net.URI;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.nio.file.Paths;
import javafx.application.Platform;

/**
 *
 * @author Alan
 */
public class LibroDesarrollo extends Application {

    Funciones fun = new Funciones();

    double pantallaWidht = 1330;
    double pantallaHeight = 870;
    int nPagina = 1;

    @Override
    public void start(Stage primaryStage) {

        HBox paginas = new HBox();

        paginas.setStyle("-fx-background-color: #FFF; -fx-alignment: center;");

        //Botones
        VBox izq = new VBox();
        Button buttonIzq = new Button("", fun.getImage("flecha-izq", ".png", 70, 70));
        buttonIzq.setStyle("-fx-background-color: transparent; -fx-padding: 0 0 0 50px;");
        buttonIzq.setCursor(Cursor.HAND);
        izq.getChildren().add(buttonIzq);
        izq.setAlignment(Pos.CENTER);

        buttonIzq.setOnMouseEntered((event) -> {

            fun.TransicionBoton(buttonIzq, 1.4, 1.4, 1);
        });

        buttonIzq.setOnMouseExited((event) -> {

            fun.TransicionBoton(buttonIzq, 1.0, 1.0, 2);

        });

        VBox der = new VBox();
        Button buttonDer = new Button("", fun.getImage("flecha-der", ".png", 70, 70));
        buttonDer.setStyle("-fx-background-color: transparent; -fx-padding: 0 50px 0 0px;");
        buttonDer.setCursor(Cursor.HAND);
        der.getChildren().add(buttonDer);
        der.setAlignment(Pos.CENTER_LEFT);

        buttonDer.setOnMouseEntered((event) -> {

            fun.TransicionBoton(buttonDer, 1.4, 1.4, 1);
        });

        buttonDer.setOnMouseExited((event) -> {

            fun.TransicionBoton(buttonDer, 1.0, 1.0, 2);

        });

        paginas.getChildren().addAll(izq, Pagina1(), der);

        Scene scene = new Scene(paginas, 1450, pantallaHeight);

        primaryStage.setTitle("Desarrollo web");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        buttonIzq.setOnAction((event) -> {

            if (nPagina - 1 > 0) {

                paginas.getChildren().clear();

                paginas.getChildren().addAll(izq, CambiarPagina(nPagina - 1), der);

                nPagina -= 1;

            }

        });

        buttonDer.setOnAction((event) -> {

            if (nPagina < 7) {

                paginas.getChildren().clear();

                paginas.getChildren().addAll(izq, CambiarPagina(nPagina + 1), der);
                nPagina += 1;

            }

        });

    }

    private HBox CambiarPagina(int pag) {

        HBox PageUpdate = null;

        switch (pag) {
            case 1:
                PageUpdate = Pagina1();
                break;

            case 2:

                PageUpdate = Pagina2();
                break;

            case 3:
                PageUpdate = Pagina3();
                break;
                
            case 4:
                PageUpdate = Pagina4();
                break;
                
            case 5:
                PageUpdate = Pagina5();
                break;
                
            case 6:
                PageUpdate = Pagina6();
                break;
                
            case 7:
                PageUpdate = Pagina7();
                break;
                
            default:
                throw new AssertionError();
        }

            String ruta = "src/audios/pasando-hoja.mp3";
        Platform.runLater(() -> {
            URI uri = Paths.get(ruta).toUri();

            String uriString = uri.toString();

            Media media = new Media(uriString);

            MediaPlayer mediaPlayer = new MediaPlayer(media);

            if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
                mediaPlayer.stop();
                mediaPlayer.seek(Duration.ZERO);
            }
            mediaPlayer.play();
        });

        return PageUpdate;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private HBox Pagina1() {

        HBox page = new HBox();
        page.setMaxHeight(pantallaHeight);
        page.setMaxWidth(pantallaHeight);

        VBox izquierda = new VBox();
        izquierda.setMinWidth(620);
        izquierda.setMinHeight(pantallaHeight);
        izquierda.setAlignment(Pos.TOP_CENTER);

        VBox centro = new VBox();
        centro.setMinWidth(50);
        centro.setMinHeight(pantallaHeight);

        VBox derecha = new VBox();
        derecha.setMinWidth(620);
        derecha.setMinHeight(pantallaHeight);
        derecha.setAlignment(Pos.TOP_CENTER);

        ImageView imageView = fun.getImage("medio", ".png", 50, 870);
        ImageView img1 = fun.getImage("webI1", ".png", 460, 290);

        //Primer Pagina
        Label label = new Label("Desarrolo Web");
        label.setStyle("-fx-padding: 60px 0 0 0; -fx-font-weight: bold;");
        label.setFont(new Font("copper-black ", 42));
        
        VBox texto1 = fun.setTextos("Bienvenido a un viaje fascinante a través del mundo del desarrollo web. En este libro, exploraremos los conceptos más básicos, tambien abordaremos la importancia de la web, su historia travez de los años y la actuilidad del desarrollo de aplicaciones y sitios webs.", 25, 0);

        Text texto2 = new Text();
        texto2.setText("La programación web es esencial en nuestra vida digital actual, desde sitios web hasta aplicaciones móviles. En este libro, aprenderás a crear páginas web, aplicaciones interactivas y a conectarte con servidores en tiempo real.");
        texto2.setTextAlignment(TextAlignment.JUSTIFY);
        texto2.setWrappingWidth(490);
        texto2.setFont(new Font("Arial", 19));

        VBox vboxTexto2 = new VBox(texto2);
        vboxTexto2.setMargin(texto2, new Insets(20, 0, 0, 0));
        vboxTexto2.setAlignment(Pos.TOP_CENTER);

        Text texto3 = new Text();
        texto3.setText("No importa si eres un principiante o tienes experiencia; aquí encontrarás consejos, ejemplos y proyectos para experimentar. Prepárate para sumergirte en el emocionante mundo de la programación web y construir experiencias impresionantes en línea. ¡Comencemos!");
        texto3.setTextAlignment(TextAlignment.JUSTIFY);
        texto3.setWrappingWidth(490);
        texto3.setFont(new Font("Arial", 19));

        VBox vboxTexto3 = new VBox(texto3);
        vboxTexto3.setMargin(texto3, new Insets(20, 0, 0, 0));
        vboxTexto3.setAlignment(Pos.TOP_CENTER);

        //Segunda Pagina
        Label label2 = new Label("Importancia de la Programación Web");
        label2.setFont(new Font("copper-black ", 26));
        label2.setStyle("-fx-padding: 45px 0 0 0;  -fx-font-weight: bold;");

        Text texto4 = new Text();
        texto4.setText("La programación web es esencial en nuestra vida digital actual, desde sitios web hasta aplicaciones móviles. En este libro, aprenderás a crear páginas web, aplicaciones interactivas y a conectarte con servidores en tiempo real.");
        texto4.setTextAlignment(TextAlignment.JUSTIFY);
        texto4.setWrappingWidth(490);
        texto4.setFont(new Font("Arial", 19));

        VBox vboxTexto4 = new VBox(texto4);
        vboxTexto4.setMargin(texto4, new Insets(20, 0, 0, 0));
        vboxTexto4.setAlignment(Pos.TOP_CENTER);

        Text texto5 = new Text();
        texto5.setText("En este capítulo, exploraremos en detalle por qué la programación web es de vital importancia en la actualidad y cómo ha transformado la forma en que vivimos, trabajamos y nos comunicamos.");
        texto5.setTextAlignment(TextAlignment.JUSTIFY);
        texto5.setWrappingWidth(490);
        texto5.setFont(new Font("Arial", 19));

        VBox vboxTexto5 = new VBox(texto5);
        vboxTexto5.setMargin(texto5, new Insets(20, 0, 0, 0));
        vboxTexto5.setAlignment(Pos.TOP_CENTER);

        Text texto6 = new Text();
        texto6.setText("La web proporciona un medio para acceder a una vasta cantidad de información en línea. Desde noticias y recursos educativos hasta contenido de entretenimiento y servicios comerciales, la web es una fuente inagotable de conocimiento y entretenimiento.");
        texto6.setTextAlignment(TextAlignment.JUSTIFY);
        texto6.setWrappingWidth(490);
        texto6.setFont(new Font("Arial", 19));

        ImageView image2 = fun.getImage("imagen1", ".png", 380, 230);

        VBox vboxTexto6 = new VBox(texto6);
        vboxTexto6.setMargin(texto6, new Insets(20, 0, 10, 0));
        vboxTexto6.setAlignment(Pos.TOP_CENTER);

        VBox texto7 = fun.setTextos("El desarrollo web ha transformado la forma en que compramos y vendemos productos y servicios. Las tiendas en línea y las plataformas de comercio electrónico permiten a las empresas llegar a clientes de todo el mundo, lo que ha impulsado el crecimiento del comercio electrónico a nivel global.", 10, 0);

        izquierda.getChildren().addAll(label, texto1, img1, vboxTexto2, vboxTexto3);

        centro.getChildren().add(imageView);

        derecha.getChildren().addAll(label2, vboxTexto4, vboxTexto5, vboxTexto6, image2, texto7);

        page.getChildren().addAll(izquierda, centro, derecha);

        return page;
    }

    private HBox Pagina2() {

        HBox page = new HBox();
        page.setMaxHeight(pantallaHeight);
        page.setMaxWidth(pantallaHeight);

        VBox izquierda = new VBox();
        izquierda.setMinWidth(620);
        izquierda.setMinHeight(pantallaHeight);
        izquierda.setAlignment(Pos.TOP_CENTER);

        VBox centro = new VBox();
        centro.setMinWidth(50);
        centro.setMinHeight(pantallaHeight);

        VBox derecha = new VBox();
        derecha.setMinWidth(620);
        derecha.setMinHeight(pantallaHeight);
        derecha.setAlignment(Pos.TOP_CENTER);

        //Primer Pagina
        Label label = new Label("Historia de la Web");
        label.setStyle("-fx-padding: 50px 0 0 0; -fx-font-weight: bold;");
        label.setFont(new Font("copper-black ", 26));

        ImageView imageView = fun.getImage("medio", ".png", 50, 870);

        VBox texto1 = fun.setTextos("La historia de la World Wide Web (WWW o Web) es una narrativa fascinante que abarca varias décadas y ha revolucionado la forma en que las personas acceden, comparten y consumen información en todo el mundo.", 10, 0);

        ImageView imgWeb = fun.getImage("web2", ".png", 420, 200);

        VBox textoBold1 = fun.setTextosBold("Década de 1940 a 1950: Orígenes de la Computación", 10, 0);

        VBox texto2 = fun.setTextos("Durante la Segunda Guerra Mundial, se desarrollaron las primeras computadoras electrónicas, como la ENIAC y la UNIVAC, que sentaron las bases para la computación moderna.", 10, 0);

        VBox textoBold2 = fun.setTextosBold("Década de 1960: Conceptos de Redes", 10, 0);

        VBox texto3 = fun.setTextos("En los años 60, surgieron los primeros conceptos de redes de computadoras, como ARPANET (Advanced Research Projects Agency Network), un proyecto del Departamento de Defensa de EE. UU. que sentó las bases para la interconexión de computadoras.", 20, 0);

        VBox textoBold3 = fun.setTextosBold("Década de 1970: Invención de TCP/IP", 10, 0);

        VBox texto4 = fun.setTextos("En 1973, Vinton Cerf y Bob Kahn desarrollaron el protocolo TCP/IP (Transmission Control Protocol/Internet ", 10, 0);

        //Segunda Pagina
        VBox texto5 = fun.setTextos("Protocol) que permitió la comunicación entre diferentes redes de computadoras y es la base de Internet.", 60, 0);

        VBox textoBold4 = fun.setTextosBold("Década de 1980: Creación del WWW", 20, 0);

        VBox texto6 = fun.setTextos("En 1989, Tim Berners-Lee, un científico de la computación en el CERN (Organización Europea para la Investigación Nuclear), propuso un sistema de información basado en hipertexto para compartir y acceder a documentos científicos. Esto se convirtió en la World Wide Web.", 10, 0);

        VBox texto7 = fun.setTextos("En 1990, Berners-Lee escribió el primer navegador web y el primer servidor web, creando así el primer sitio web y el primer servidor web.", 10, 15);

        ImageView imgWeb2 = fun.getImage("web3", ".png", 450, 320);

        VBox textoBold5 = fun.setTextosBold("Década de 1990: La web se Populariza", 20, 0);

        VBox texto8 = fun.setTextos("En 1993, se lanzó el navegador web Mosaic, que facilitó la navegación en la web para usuarios no técnicos y contribuyó a la popularización de la web.", 10, 15);

        izquierda.getChildren().addAll(label, imgWeb, texto1, textoBold1, texto2, textoBold2, texto3, textoBold3, texto4);

        centro.getChildren().add(imageView);

        derecha.getChildren().addAll(texto5, textoBold4, texto6, texto7, imgWeb2, textoBold5, texto8);
        page.getChildren().addAll(izquierda, centro, derecha);

        return page;
    }

    private HBox Pagina3() {

        HBox page = new HBox();
        page.setMaxHeight(pantallaHeight);
        page.setMaxWidth(pantallaHeight);

        VBox izquierda = new VBox();
        izquierda.setMinWidth(620);
        izquierda.setMinHeight(pantallaHeight);
        izquierda.setAlignment(Pos.TOP_CENTER);

        VBox centro = new VBox();
        centro.setMinWidth(50);
        centro.setMinHeight(pantallaHeight);

        VBox derecha = new VBox();
        derecha.setMinWidth(620);
        derecha.setMinHeight(pantallaHeight);
        derecha.setAlignment(Pos.TOP_CENTER);

        ImageView imageView = fun.getImage("medio", ".png", 50, 870);
        
        //Primer Pagina  

        VBox texto1 = fun.setTextos("Empresas como Netscape y Microsoft lanzaron sus propios navegadores web en competencia con Mosaic.", 60, 0);

        VBox textoBold1 = fun.setTextosBold("Década de 2000: La Web 2.0", 20, 0);

        VBox texto2 = fun.setTextos("A principios de la década de 2000, se popularizaron los blogs, las redes sociales y los servicios web interactivos, marcando el comienzo de la era de la Web 2.0.", 10, 0);
        
        VBox texto2_1 = fun.setTextos("Google se convirtió en un motor de búsqueda líder, y la publicidad en línea se volvió una fuente importante de ingresos.", 10, 0);
        
        VBox textoBold2 = fun.setTextosBold("Década de 2010: Web Móvil y Redes Sociales", 20, 0);
        
        VBox texto3 = fun.setTextos("La década de 2010 presenció la proliferación de dispositivos móviles y la creciente importancia de la web móvil.", 10, 0);
        
        VBox texto4 = fun.setTextos("Redes sociales como Facebook, Twitter, Instagram y LinkedIn se convirtieron en parte integral de la vida cotidiana de las personas.", 10, 20);
        
        ImageView redes = fun.getImage("redes-sociales", ".png", 495, 255);
        
        //Segundo Pagina
        
        VBox textoBold3 = fun.setTextosBold("Década de 2020: Web Moderna y Avances Tecnológicos", 60, 0);
        
        VBox texto5 = fun.setTextos("La web moderna incluye tecnologías como HTML5, CSS3 y JavaScript avanzado, que permiten experiencias interactivas y receptivas en la web.", 10, 0);
        
        VBox texto6 = fun.setTextos("Avances como la inteligencia artificial, la realidad virtual y la inteligencia de datos están moldeando el futuro de la web.", 10, 20);
        
        VBox texto7 = fun.setTextos("La historia de la web es una historia de innovación continua, colaboración global y un cambio radical en la forma en que las personas se comunican, trabajan y acceden a la información. La web ha evolucionado desde sus humildes comienzos en el CERN hasta convertirse en una fuerza omnipresente que afecta todos los aspectos de la vida moderna.", 20, 0);
        
        ImageView imgWeb = fun.getImage("web4", ".jpg", 495, 310);
        
        izquierda.getChildren().addAll(texto1, textoBold1, texto2, texto2_1 ,textoBold2, texto3, texto4, redes);

        centro.getChildren().add(imageView);

        derecha.getChildren().addAll(textoBold3, texto5, texto6, imgWeb ,texto7);
        page.getChildren().addAll(izquierda, centro, derecha);

        return page;
    }
    
    private HBox Pagina4() {

        HBox page = new HBox();
        page.setMaxHeight(pantallaHeight);
        page.setMaxWidth(pantallaHeight);

        VBox izquierda = new VBox();
        izquierda.setMinWidth(620);
        izquierda.setMinHeight(pantallaHeight);
        izquierda.setAlignment(Pos.TOP_CENTER);

        VBox centro = new VBox();
        centro.setMinWidth(50);
        centro.setMinHeight(pantallaHeight);

        VBox derecha = new VBox();
        derecha.setMinWidth(620);
        derecha.setMinHeight(pantallaHeight);
        derecha.setAlignment(Pos.TOP_CENTER);

        //Primer Pagina
        Label label = new Label("Herramientas necerarias");
        label.setStyle("-fx-padding: 60px 0 0 0; -fx-font-weight: bold;");
        label.setFont(new Font("copper-black ", 26));

        ImageView imageView = fun.getImage("medio", ".png", 50, 870);

        VBox texto1 = fun.setTextos("Para desarrollar sitios web, necesitarás una serie de herramientas y tecnologías esenciales. Aquí hay una lista de las herramientas y tecnologías básicas que necesitarás:", 20, 0);
        VBox textoBold1 = fun.setTextosBold("Editor de Codigo o IDE", 20, 0);

        VBox texto2 = fun.setTextos("Un editor de código es esencial para escribir, editar y depurar el código. Algunas opciones populares son Visual Studio Code Sublime Text, Atom y WebStorm", 10, 0);

        VBox texto3 = fun.setTextos("Los IDEs o Entornos de Desarrollo Integrado son excelentes opciones en especial si trabajas con leguajes de servidor con Java, algunos IDEs populares son IntelliJ IDEA, Eclipse, NetBeans y Visual estudio.", 10, 0);

        VBox textoBold2 = fun.setTextosBold("Navegador Web", 20, 0);

        VBox texto4 = fun.setTextos("Necesitas varios navegadores web para probar tu sitio web y asegurarte de que funcione correctamente en diferentes plataformas y navegadores. Algunos navegadores populares incluyen Google Chrome, Mozilla Firefox, Microsoft Edge y Safari.", 10, 0);

        VBox textoBold3 = fun.setTextosBold("HTML (Lenguaje de Marcado de Hipertexto)", 20, 0);

        VBox texto5 = fun.setTextos("El lenguaje de marcado HTML (Hypertext Markup Language) es uno de los pilares fundamentales de la World Wide Web y se utiliza para crear la estructura y el contenido básico de las páginas web. HTML se utiliza en conjunto con CSS (Cascading Style Sheets) y JavaScript para crear sitios web interactivos y atractivos.", 20, 0);

        //Segunda Pagina
        VBox textoBold4 = fun.setTextosBold("CSS (Hojas de estilo en cascada)", 60, 0);

        VBox texto6 = fun.setTextos("El diseño de una página o sitio web necesita un lenguaje común para que los navegadores puedan interpretarlo y mostrarlo a las personas de la forma correcta. Pero también lo requieren para que otros diseñadores hagan las modificaciones necesarias para su optimización.", 10, 0);

        VBox texto7 = fun.setTextos("Uno de estos lenguajes es el CSS, un gran aliado del HTML que transforma la experiencia de tus visitantes. Css es un lenguaje que maneja el diseño y presentación de las páginas web, es decir, cómo lucen cuando un usuario las visita. Funciona junto con el lenguaje HTML que se encarga del contenido básico de los sitios.", 10, 0);

        VBox textoBold5 = fun.setTextosBold("JavaScript", 20, 0);

        VBox texto8 = fun.setTextos("JavaScript es un lenguaje de programación que los desarrolladores utilizan para hacer páginas web interactivas. Desde actualizar fuentes de redes sociales a mostrar animaciones y mapas interactivos, las funciones de JavaScript pueden mejorar la experiencia del usuario de un sitio web. Como lenguaje de scripting del lado del servidor, se trata de una de las principales tecnologías de la World Wide Web. ", 10, 0);
        VBox texto9 = fun.setTextos("Por ejemplo, al navegar por Internet, en cualquier momento en el que vea un carrusel de imágenes, un menú desplegable “click-to-show” (clic para mostrar), o cambien de manera dinámica los elementos de color en una página web, estará viendo los efectos de JavaScript.", 10, 0);
        VBox texto10 = fun.setTextos("Anteriormente, las páginas web eran estáticas, similares a las páginas de un libro. Una página estática mostraba principalmente información en un diseño fijo y no todo aquello que esperamos de un sitio web moderno.", 10, 0);

        izquierda.getChildren().addAll(label, texto1, textoBold1, texto2, texto3, textoBold2, texto4, textoBold3, texto5);

        centro.getChildren().add(imageView);

        derecha.getChildren().addAll(textoBold4, texto6, texto7, textoBold5, texto8, texto9, texto10);
        page.getChildren().addAll(izquierda, centro, derecha);

        return page;
    }
    
    private HBox Pagina5() {

        HBox page = new HBox();
        page.setMaxHeight(pantallaHeight);
        page.setMaxWidth(pantallaHeight);

        VBox izquierda = new VBox();
        izquierda.setMinWidth(620);
        izquierda.setMinHeight(pantallaHeight);
        izquierda.setAlignment(Pos.TOP_CENTER);

        VBox centro = new VBox();
        centro.setMinWidth(50);
        centro.setMinHeight(pantallaHeight);

        VBox derecha = new VBox();
        derecha.setMinWidth(620);
        derecha.setMinHeight(pantallaHeight);
        derecha.setAlignment(Pos.TOP_CENTER);

        //Primer Pagina
        VBox textoBold1 = fun.setTextosBold("Sistema de Control de Versiones", 60, 0);

        ImageView imageView = fun.getImage("medio", ".png", 50, 870);

        VBox texto1 = fun.setTextos("Un control de versiones es un sistema que registra los cambios realizados en un archivo o conjunto de archivos a lo largo del tiempo, de modo que puedas recuperar versiones específicas más adelante.", 10, 0);
        VBox texto2 = fun.setTextos("Git es un sistema de control de versiones distribuido que registra las distintas versiones de un archivo (o conjunto de archivos). Le permite a los usuarios acceder, comparar, actualizar, y distribuir cualquiera de las versiones registradas en cualquier momento.", 10, 0);

        VBox textoBold2 = fun.setTextosBold("", 20, 0);

        ImageView imgWeb = fun.getImage("control", ".png", 390, 185);
        
        VBox textoBold3 = fun.setTextosBold("Herramientas de Diseño Gráfico", 10, 0);
        
        VBox texto3 = fun.setTextos("Si eres un diseñador web, necesitarás herramientas como Adobe Photoshop, Adobe Illustrator o herramientas alternativas de diseño gráfico para crear gráficos y elementos visuales para tu sitio.", 10, 0);
        
        VBox texto4 = fun.setTextos("El diseño en una página web es crucial porque crea una buena primera impresión, mejora la usabilidad y la confiabilidad, refleja la marca, facilita la optimización para dispositivos móviles, influye en el SEO, aumenta la conversión y la competitividad, y garantiza la accesibilidad.", 10, 0);
        
        //Segunda Pagina
        
        VBox textoBold4 = fun.setTextosBold("Servidores Web Locales", 60, 0);
        
        VBox texto5 = fun.setTextos("Puedes configurar un servidor web local como Apache, Nginx o usar soluciones más simples como XAMPP o WAMP para probar tu sitio web de manera local antes de implementarlo en un servidor en vivo.", 10, 0);
        
        VBox texto6 = fun.setTextos("XAMPP es un servidor independiente de plataforma, software libre, que consiste principalmente en la base de datos MySQL, el servidor web Apache y los intérpretes para lenguajes de script: PHP y Perl.", 10, 0);
        
        VBox textoBold5 = fun.setTextosBold("Bases de Datos", 20, 0);
        
        VBox texto7 = fun.setTextos("Las bases de datos son un componente fundamental en el desarrollo web, y desempeñan un papel crucial en la gestión y manipulación de datos en aplicaciones en línea.", 10, 0);
        
        VBox texto8 = fun.setTextos("Las bases de datos permiten el almacenamiento de datos de manera estructurada y organizada. Esto es esencial para gestionar información como perfiles de usuario, contenido del sitio, registros de actividad, inventario de productos y mucho más.", 10, 10);
        
        ImageView base = fun.getImage("base", ".png", 475, 272);

        izquierda.getChildren().addAll(textoBold1, texto1, texto2, textoBold2, imgWeb, textoBold3, texto3, texto4);

        centro.getChildren().add(imageView);

        derecha.getChildren().addAll(textoBold4, texto5, texto6, textoBold5, texto7, texto8, base);
        
        page.getChildren().addAll(izquierda, centro, derecha);

        return page;
    }
    
    private HBox Pagina6() {

        HBox page = new HBox();
        page.setMaxHeight(pantallaHeight);
        page.setMaxWidth(pantallaHeight);

        VBox izquierda = new VBox();
        izquierda.setMinWidth(620);
        izquierda.setMinHeight(pantallaHeight);
        izquierda.setAlignment(Pos.TOP_CENTER);

        VBox centro = new VBox();
        centro.setMinWidth(50);
        centro.setMinHeight(pantallaHeight);

        VBox derecha = new VBox();
        derecha.setMinWidth(620);
        derecha.setMinHeight(pantallaHeight);
        derecha.setAlignment(Pos.TOP_CENTER);

        //Primer Pagina
        VBox textoBold1 = fun.setTextosBold("Herramientas de Automatización y Empaquetado", 60, 0);

        ImageView imageView = fun.getImage("medio", ".png", 50, 870);

        VBox texto1 = fun.setTextos("Las herramientas de automatización y empaquetado son programas y utilidades diseñados para simplificar y automatizar tareas repetitivas y complejas en el desarrollo de software.", 10, 0);
        VBox texto2 = fun.setTextos("Utiliza herramientas como Webpack, Gulp o Grunt para automatizar tareas como la minificación de archivos CSS/JS y la optimización de imágenes.", 10, 0);
        VBox texto3 = fun.setTextos("Las herramientas de automatización y empaquetado son esenciales en el desarrollo de software moderno, ya que agilizan procesos, mejoran la calidad del software y simplifican la gestión de dependencias y despliegues, lo que resulta en un desarrollo más eficiente y una entrega más confiable de aplicaciones.", 10, 0);
        
        VBox textoBold2 = fun.setTextosBold("Herramientas de Pruebas y Depuración", 20, 0);

        VBox texto4 = fun.setTextos("Las herramientas de pruebas y depuración son esenciales en el desarrollo web para garantizar que una aplicación o sitio web funcione correctamente y para identificar y solucionar errores y problemas.", 10, 0);
        VBox texto5 = fun.setTextos("Estas herramientas son esenciales para garantizar el correcto funcionamiento, la calidad y la seguridad de las aplicaciones web durante el desarrollo y en producción.", 10, 0);
        
        VBox textoBold3 = fun.setTextosBold("Herramientas de Seguridad", 10, 0);
        
        VBox texto6 = fun.setTextos("La seguridad web es una preocupación crítica en el desarrollo de aplicaciones y sitios web.", 10, 0);
        
        VBox texto7 = fun.setTextos("Las herramientas para la seguridad web son esenciales para evaluar, mejorar y mantener la seguridad de aplicaciones y sitios web en un entorno en constante evolución de amenazas cibernéticas.", 10, 0);
        
        //Segunda Pagina
        
        VBox texto8 = fun.setTextos("Además, se recomienda seguir las mejores prácticas de seguridad durante el desarrollo web y mantenerse actualizado sobre las últimas amenazas y soluciones de seguridad.", 60, 0);
        
        VBox textoBold4 = fun.setTextosBold("Hospedaje y Dominio", 20, 0);
        
        VBox texto9 = fun.setTextos("El dominio y el hospedaje web son dos componentes esenciales para poner un sitio web en línea.", 10, 15);
        
        ImageView dominio = fun.getImage("dominio", ".jpg", 410 , 230 );
        
        VBox texto10 = fun.setTextos("El Hospedaje web o Hosting web es un servicio para alojar sitios web, es decir, todos los contenidos de tus páginas web para que las personas puedan acceder a él en todo momento a través de diferentes dispositivos siempre que tengan conexión a internet. Si deseas arrancar un negocio o proyecto, necesitas un web hosting para tu sitio web. ", 15, 0);
        VBox texto11 = fun.setTextos("Un dominio es la dirección de un sitio web. Lo identificas fácilmente como la parte de la URL que escribes en la barra buscadora después de «https://». Por ejemplo, «hubspot.com» es el dominio de HubSpot. También se conoce como el nombre de un sitio y, al igual que el de una marca, es propietario.", 10, 0);
        
        izquierda.getChildren().addAll(textoBold1, texto1, texto2, texto3, textoBold2, texto4, texto5, textoBold3, texto6, texto7);

        centro.getChildren().add(imageView);

        derecha.getChildren().addAll(texto8, textoBold4, texto9, dominio, texto10, texto11);
        
        page.getChildren().addAll(izquierda, centro, derecha);

        return page;
    }
    
    private HBox Pagina7() {

        HBox page = new HBox();
        page.setMaxHeight(pantallaHeight);
        page.setMaxWidth(pantallaHeight);

        VBox izquierda = new VBox();
        izquierda.setMinWidth(620);
        izquierda.setMinHeight(pantallaHeight);
        izquierda.setAlignment(Pos.TOP_CENTER);

        VBox centro = new VBox();
        centro.setMinWidth(50);
        centro.setMinHeight(pantallaHeight);

        VBox derecha = new VBox();
        derecha.setMinWidth(620);
        derecha.setMinHeight(pantallaHeight);
        derecha.setAlignment(Pos.TOP_CENTER);

        ImageView imageView = fun.getImage("medio", ".png", 50, 870);
        //Primer Pagina


        VBox texto1 = fun.setTextos("Los dominios funcionan como la dirección de tu casa. Si tus amigos quieren visitarte, en lugar de usar las coordenadas de GPS de tu casa, simplemente escriben tu dirección, que es mucho más fácil de recordar.", 60, 0);

        VBox texto2 = fun.setTextos("Todos los sitios web tienen una dirección IP, una serie única de números que conecta los equipos con los servidores web, pero es imposible que los usuarios memoricen las direcciones IP de todos los sitios que quieran visitar. Por suerte, los dominios reemplazan la dirección IP de los sitios web, lo que permite a la audiencia recordarlos e identificarlos fácilmente.", 10, 0);
        
        VBox texto3 = fun.setTextos("En resumen, un dominio web es la dirección que permite a las personas encontrar tu sitio en Internet, mientras que el hospedaje web proporciona el espacio y los recursos necesarios para almacenar y servir los archivos y datos de tu sitio. Ambos son fundamentales para poner un sitio web en línea y hacerlo accesible para usuarios de todo el mundo.", 10, 0);
        
        VBox textoBold1 = fun.setTextosBold("Conocimiento sobre SEO", 20, 0);
        
        VBox texto4 = fun.setTextos("el SEO (Search Engine Optimization, en español Optimización de Motores de Búsqueda) es una práctica fundamental en el mundo del marketing digital y el desarrollo web. El SEO es un conjunto de estrategias y técnicas diseñadas para mejorar la visibilidad de un sitio web en los motores de búsqueda como Google, Bing y Yahoo.", 10, 0);
        
        VBox texto5 = fun.setTextos("El objetivo principal del SEO es aumentar la cantidad y la calidad del tráfico orgánico (no pagado) hacia un sitio web.", 10, 0);
        
        //Segunda Pagina
        
        VBox texto6 = fun.setTextos("El SEO es una disciplina esencial para aumentar la visibilidad en línea y el tráfico de un sitio web. Al comprender y aplicar estrategias de SEO de manera efectiva, puedes mejorar la presencia de tu sitio en los motores de búsqueda y llegar a un público más amplio.", 60, 15);

        ImageView seo = fun.getImage("seo", ".png", 420, 335);
        
        VBox textoBold2 = fun.setTextosBold("Control de Calidad y Pruebas", 20, 0);
        
        VBox texto7 = fun.setTextos("El control de calidad y las pruebas en el desarrollo web son procesos fundamentales para garantizar que una aplicación o sitio web funcione correctamente y cumpla con los estándares de calidad.", 10, 0);
        
        VBox texto8 = fun.setTextos("El control de calidad se refiere al conjunto de actividades y procesos que tienen como objetivo garantizar la calidad y la excelencia de un producto o servicio, en este caso, una aplicación web.", 10, 0);

        VBox textoBold3 = fun.setTextosBold("Herramientas de Diseño Gráfico", 20, 0);
             
        
        VBox textoBold4 = fun.setTextosBold("Servidores Web Locales", 20, 0);
        
        
        izquierda.getChildren().addAll(texto1, texto2, texto3, textoBold1, texto4, texto5);

        centro.getChildren().add(imageView);

        derecha.getChildren().addAll(texto6, seo, textoBold2, texto7, texto8);
        
        page.getChildren().addAll(izquierda, centro, derecha);

        return page;
    }
    
    private HBox Pagina8() {

        HBox page = new HBox();
        page.setMaxHeight(pantallaHeight);
        page.setMaxWidth(pantallaHeight);

        VBox izquierda = new VBox();
        izquierda.setMinWidth(620);
        izquierda.setMinHeight(pantallaHeight);
        izquierda.setAlignment(Pos.TOP_CENTER);

        VBox centro = new VBox();
        centro.setMinWidth(50);
        centro.setMinHeight(pantallaHeight);

        VBox derecha = new VBox();
        derecha.setMinWidth(620);
        derecha.setMinHeight(pantallaHeight);
        derecha.setAlignment(Pos.TOP_CENTER);

        //Primer Pagina
        VBox textoBold1 = fun.setTextosBold("Sistema de Control de Versiones", 60, 0);

        ImageView imageView = fun.getImage("medio", ".png", 50, 870);

        VBox texto1 = fun.setTextos("Un control de versiones es un sistema que registra los cambios realizados en un archivo o conjunto de archivos a lo largo del tiempo, de modo que puedas recuperar versiones específicas más adelante.", 10, 0);
        VBox texto2 = fun.setTextos("Git es un sistema de control de versiones distribuido que registra las distintas versiones de un archivo (o conjunto de archivos). Le permite a los usuarios acceder, comparar, actualizar, y distribuir cualquiera de las versiones registradas en cualquier momento.", 10, 0);

        VBox textoBold2 = fun.setTextosBold("", 20, 0);

        ImageView imgWeb = fun.getImage("control", ".png", 390, 185);
        
        VBox textoBold3 = fun.setTextosBold("Herramientas de Diseño Gráfico", 10, 0);
        
        VBox texto3 = fun.setTextos("Si eres un diseñador web, necesitarás herramientas como Adobe Photoshop, Adobe Illustrator o herramientas alternativas de diseño gráfico para crear gráficos y elementos visuales para tu sitio.", 10, 0);
        
        VBox texto4 = fun.setTextos("El diseño en una página web es crucial porque crea una buena primera impresión, mejora la usabilidad y la confiabilidad, refleja la marca, facilita la optimización para dispositivos móviles, influye en el SEO, aumenta la conversión y la competitividad, y garantiza la accesibilidad.", 10, 0);
        
        //Segunda Pagina
        
        VBox textoBold4 = fun.setTextosBold("Servidores Web Locales", 20, 0);
        
        VBox texto5 = fun.setTextos("Puedes configurar un servidor web local como Apache, Nginx o usar soluciones más simples como XAMPP o WAMP para probar tu sitio web de manera local antes de implementarlo en un servidor en vivo.", 10, 0);
        
        izquierda.getChildren().addAll(textoBold1, texto1, texto2, textoBold2, imgWeb, textoBold3, texto3, texto4);

        centro.getChildren().add(imageView);

        derecha.getChildren().addAll(textoBold4, texto5);
        page.getChildren().addAll(izquierda, centro, derecha);

        return page;
    }
    
}
