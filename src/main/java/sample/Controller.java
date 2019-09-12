package sample;

import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Controller {

    public TextFlow textFl = new TextFlow();
    public Text text = new Text("First line \n");
    public Button button = new Button();

    public Person person = new Person("Maciek", 36);
    public Person person2 = new Person("Oluszka", 37);

    private List<Person> list = new ArrayList<>();



    public void initialize(){
        textFl.getChildren().add(text);
        list.add(person);
        list.add(person2);
    }

    public void addText(){
        for (Person p : list){
            Text text = new Text();
            text.setText(p.getName());
            textFl.getChildren().add(text);
            Text text2 = new Text();
            text2.setText(String.valueOf(p.getAge()));
            text2.setText(String.valueOf(p.getAge()));
            textFl.getChildren().add(text2);
            Text text3 = new Text();
            text3.setText("\n");
            textFl.getChildren().add(text3);
        }
//        Text t1 = new Text("Second line\n");
//        t1.setLineSpacing(20);
//        Separator separator = new Separator();
//        separator.prefWidthProperty().bind(textFl.widthProperty());
//        separator.setStyle("-fx-background-color: red;");
//        Text t2 = new Text();
//        t2.setTextField(person.toString());
//        t2.setFont(Font.font(14));
//        textFl.getChildren().add(t1);
//        textFl.getChildren().add(separator);
//        textFl.getChildren().add(t2);
    }
}
