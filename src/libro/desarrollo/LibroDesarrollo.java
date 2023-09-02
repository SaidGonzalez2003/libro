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

            if (nPagina < 4) {

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

        Text texto1 = new Text();
        texto1.setText("Bienvenido a un viaje fascinante a través del mundo de la programación web. En este libro, exploraremos desde los conceptos más básicos hasta las complejidades del desarrollo web.");
        texto1.setTextAlignment(TextAlignment.JUSTIFY);
        texto1.setWrappingWidth(490);
        texto1.setFont(new Font("Arial", 19));

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

        //Primer Pagina
        Label label = new Label("Historia de la Web");
        label.setStyle("-fx-padding: 60px 0 0 0; -fx-font-weight: bold;");
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
        Label label = new Label("Historia de la Web");
        label.setStyle("-fx-padding: 60px 0 0 0; -fx-font-weight: bold;");
        label.setFont(new Font("copper-black ", 26));

        ImageView imageView = fun.getImage("medio", ".png", 50, 870);

        VBox texto1 = fun.setTextos("La historia de la World Wide Web (WWW o Web) es una narrativa fascinante que abarca varias décadas y ha revolucionado la forma en que las personas acceden, comparten y consumen información en todo el mundo.", 20, 0);

        ImageView imgWeb = fun.getImage("web2", ".png", 420, 200);

        VBox textoBold1 = fun.setTextosBold("Década de 1940 a 1950: Orígenes de la Computación", 10, 0);

        izquierda.getChildren().addAll(label, imgWeb, texto1, textoBold1);

        centro.getChildren().add(imageView);

        //derecha.getChildren().addAll(label2, vboxTexto4, vboxTexto5, vboxTexto6, image2, texto7);
        page.getChildren().addAll(izquierda, centro, derecha);

        return page;
    }

}
