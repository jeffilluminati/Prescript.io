package application.splash;

import javafx.animation.*;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.io.*;


public class Splash {
    static Scene splash;
    private Pane pane, splashLayout;
    private ProgressBar loadProgress;
    private Label progressText;
    ImageView iv;
    final String IMAGE_URL = "src/resources/images/icons/icon.png";
    final private SequentialTransition progress = new SequentialTransition();
    Thread proganim;

    private ObservableList<String> texts = FXCollections.observableArrayList("Implementing MVC Framework...",
            "Creating 20+ Files...", "Reading Java API...", "Importing *...", "Generating classes...",
            "Generating interfaces...", "Generating enumerations...", "Extending classes...",
            "Implementing interfaces...", "Setting preferences...",
            "Introducing models to environment...", "Catching all Pokemon...", "Seeking damages...",
            "Formatting Menubar...", "Creating JavaFX Controls...", "Deriving images...", "Finding logo...", "Generating logo...",
            "Loading FXML Files...", "Generating login.fxml...", "Searching for JavaFX Widgets...", "Generating GUI...",
            "Generating sidebar...", "Styling the window...", "Initializing LoginController...",  "Threading everything together...",
            "Reading everything...", "Preparing Environment...", "Finally loading Login...", "Completed.");

    public Splash() {
        splash = new Scene((pane = new Pane()));
        pane.setStyle("-fx-background-color:white");
    }

    public void init() throws FileNotFoundException {
        iv = new ImageView(new Image(new FileInputStream(IMAGE_URL)));
        iv.setFitWidth(200);
        iv.setFitHeight(200);
        iv.setX(0);
        iv.setY(0);

        loadProgress = new ProgressBar();
        loadProgress.setPrefWidth(800);
        progressText = new Label("Generating phyton.workspace...");
        progressText.setFont(new Font("System", 13));
        //progressText.setStyle("-fx-text-fill:white");
        splashLayout = new VBox(loadProgress, progressText);
        progressText.setAlignment(Pos.CENTER);
        splashLayout.setEffect(new DropShadow());
        splashLayout.setStyle("-fx-border-radius: 5");
        splashLayout.setLayoutX(0);
        splashLayout.setLayoutY(240);
        splashLayout.setOpaqueInsets(new Insets(10));
        pane.getChildren().addAll(iv, splashLayout);
    }

    public void show() throws FileNotFoundException {
        init();
        (proganim = new Thread(progresser)).start();

    }

    private Runnable progresser = () -> {
        progress.getChildren().add(new Transition() {
            { setCycleDuration(Duration.millis(8000)); }
            @Override
            protected void interpolate(double frac) {
                loadProgress.setProgress(frac);
                progressText.setText(texts.get((int)(frac*(texts.size()-1))));
            }
        });
        progress.play();
    };



    public Scene getSplashScene() { return splash; }

    public SequentialTransition getProgresser() { return progress; }

    public Thread getProganim() { return proganim; }

    public void stopAllThreads() { proganim.interrupt(); }
}