package libro.desarrollo;

import java.io.FileInputStream;
import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

public class Funciones {

    ImageView imageView = null;

    public ImageView getImage(String nombre, String extencion, double ancho, double alto) {

        try {

            FileInputStream input = new FileInputStream("src/imagenes/" + nombre + extencion);
            Image image = new Image(input, ancho, alto, false, true);
            imageView = new ImageView(image);

        } catch (Exception e) {
            System.out.println("error" + e);
        }

        return imageView;

    }

    public VBox setTextos(String textoContenido, double top, double buttom) {

        Text texto = new Text();
        texto.setText(textoContenido);
        texto.setTextAlignment(TextAlignment.JUSTIFY);
        texto.setWrappingWidth(490);
        texto.setFont(new Font("Arial", 19));

        VBox vbText = new VBox(texto);
        vbText.setMargin(texto, new Insets(top, 0, buttom, 0));
        vbText.setAlignment(Pos.TOP_CENTER);

        return vbText;
    }
    
    public VBox setTextosBold(String textoContenido, double top, double buttom) {

        Text texto = new Text();
        texto.setText(textoContenido);
        texto.setTextAlignment(TextAlignment.JUSTIFY);
        texto.setWrappingWidth(490);
        texto.setFont(Font.font("Arial",FontWeight.BOLD, 21));

        VBox vbText = new VBox(texto);
        vbText.setMargin(texto, new Insets(top, 0, buttom , 0));
        vbText.setAlignment(Pos.TOP_CENTER);

        return vbText;
    }

    public void TransicionBoton(Button btn, double x, double y, int opc) {

        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(400), btn);

        if (opc == 1) {
            
            scaleTransition.setToX(x);
            scaleTransition.setToY(y);

            scaleTransition.play();
        } else if (opc == 2) {
            
            btn.setScaleX(1.0);
            btn.setScaleY(1.0);

        }

    }

}
